// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.cosmos.implementation.query;

import com.azure.cosmos.CosmosItemSerializer;
import com.azure.cosmos.implementation.DiagnosticsClientContext;
import com.azure.cosmos.implementation.DocumentCollection;
import com.azure.cosmos.implementation.Utils;
import com.azure.cosmos.implementation.query.hybridsearch.HybridSearchQueryInfo;
import com.azure.cosmos.models.CosmosQueryRequestOptions;
import com.azure.cosmos.models.ModelBridgeInternal;
import reactor.core.publisher.Flux;

import java.util.function.BiFunction;

/**
 * While this class is public, but it is not part of our published public APIs.
 * This is meant to be internally used only by our sdk.
 */
public abstract class PipelinedQueryExecutionContextBase<T>
    implements IDocumentQueryExecutionContext<T> {

    protected final int actualPageSize;
    private final QueryInfo queryInfo;
    private final HybridSearchQueryInfo hybridSearchQueryInfo;
    protected final CosmosItemSerializer itemSerializer;
    protected final Class<T> classOfT;

    protected PipelinedQueryExecutionContextBase(
        int actualPageSize,
        QueryInfo queryInfo,
        HybridSearchQueryInfo hybridSearchQueryInfo,
        CosmosItemSerializer itemSerializer,
        Class<T> classOfT) {

        this.actualPageSize = actualPageSize;
        this.queryInfo = queryInfo;
        this.hybridSearchQueryInfo = hybridSearchQueryInfo;
        this.itemSerializer = itemSerializer;
        this.classOfT = classOfT;
    }

    public static <T> Flux<PipelinedQueryExecutionContextBase<T>> createAsync(
        DiagnosticsClientContext diagnosticsClientContext,
        IDocumentQueryClient client,
        PipelinedDocumentQueryParams<T> initParams,
        Class<T> classOfT,
        DocumentCollection collection) {

        QueryInfo queryInfo = initParams.getQueryInfo();
        HybridSearchQueryInfo hybridSearchQueryInfo = initParams.getHybridSearchQueryInfo();

        CosmosQueryRequestOptions cosmosQueryRequestOptions = initParams.getCosmosQueryRequestOptions();
        int actualPageSize = Utils.getValueOrDefault(ModelBridgeInternal.getMaxItemCountFromQueryRequestOptions(cosmosQueryRequestOptions),
            ParallelQueryConfig.ClientInternalPageSize);

        if (actualPageSize == -1) {
            actualPageSize = Integer.MAX_VALUE;
        }

        CosmosItemSerializer candidateSerializer = client.getEffectiveItemSerializer(cosmosQueryRequestOptions);

        if (hybridSearchQueryInfo != null) {
            return PipelinedDocumentQueryExecutionContext.createHybridAsyncCore(
                diagnosticsClientContext,
                client,
                initParams,
                actualPageSize,
                candidateSerializer,
                classOfT,
                collection);
        }


        int pageSize = Math.min(actualPageSize, Utils.getValueOrDefault(queryInfo.getTop(), (actualPageSize)));

        final CosmosItemSerializer itemSerializer  = candidateSerializer != CosmosItemSerializer.DEFAULT_SERIALIZER
            ? candidateSerializer
            : ValueUnwrapCosmosItemSerializer.create(queryInfo.hasSelectValue());

        if (queryInfo.hasOrderBy()
            || queryInfo.hasAggregates()
            || queryInfo.hasGroupBy()
            || queryInfo.hasDCount()
            || queryInfo.hasDistinct()
            || queryInfo.hasNonStreamingOrderBy()) {

            return PipelinedDocumentQueryExecutionContext.createAsyncCore(
                diagnosticsClientContext,
                client,
                initParams,
                pageSize,
                itemSerializer,
                classOfT,
                collection);
        }

        return PipelinedQueryExecutionContext.createAsyncCore(
            diagnosticsClientContext,
            client,
            initParams,
            pageSize,
            itemSerializer,
            classOfT,
            collection);
    }

    protected static <T> BiFunction<String, PipelinedDocumentQueryParams<T>, Flux<IDocumentQueryExecutionComponent<T>>> createCommonPipelineComponentFunction(
        BiFunction<String, PipelinedDocumentQueryParams<T>, Flux<IDocumentQueryExecutionComponent<T>>> createBaseComponent,
        QueryInfo queryInfo) {

        BiFunction<String, PipelinedDocumentQueryParams<T>, Flux<IDocumentQueryExecutionComponent<T>>> createSkipComponentFunction;
        if (queryInfo.hasOffset()) {
            createSkipComponentFunction =
                (continuationToken, documentQueryParams) ->
                    SkipDocumentQueryExecutionContext.createAsync(createBaseComponent,
                        queryInfo.getOffset(),
                        continuationToken,
                        documentQueryParams);
        } else {
            createSkipComponentFunction = createBaseComponent;
        }

        BiFunction<String, PipelinedDocumentQueryParams<T>, Flux<IDocumentQueryExecutionComponent<T>>> createLimitComponentFunction;
        if (queryInfo.hasLimit()) {
            createLimitComponentFunction =
                (continuationToken, documentQueryParams) ->
                    TakeDocumentQueryExecutionContext.createAsync(createSkipComponentFunction,
                    queryInfo.getLimit(),
                    continuationToken,
                    documentQueryParams,
                    TakeDocumentQueryExecutionContext.TakeEnum.LIMIT);
        } else {
            createLimitComponentFunction = createSkipComponentFunction;
        }

        if (queryInfo.hasTop()) {
            return (continuationToken, documentQueryParams) ->
                TakeDocumentQueryExecutionContext.createAsync(createLimitComponentFunction,
                queryInfo.getTop(),
                continuationToken,
                documentQueryParams,
                TakeDocumentQueryExecutionContext.TakeEnum.TOP);
        } else {
            return createLimitComponentFunction;
        }
    }

    protected static <T> BiFunction<String, PipelinedDocumentQueryParams<T>, Flux<IDocumentQueryExecutionComponent<T>>> createCommonHybridPipelineComponentFunction(
        BiFunction<String, PipelinedDocumentQueryParams<T>, Flux<IDocumentQueryExecutionComponent<T>>> createBaseComponent,
        HybridSearchQueryInfo hybridSearchQueryInfo) {

        BiFunction<String, PipelinedDocumentQueryParams<T>, Flux<IDocumentQueryExecutionComponent<T>>> createSkipComponentFunction;
        if (hybridSearchQueryInfo.hasSkip()) {
            createSkipComponentFunction =
                (continuationToken, documentQueryParams) ->
                    SkipDocumentQueryExecutionContext.createAsync(createBaseComponent,
                        hybridSearchQueryInfo.getSkip(),
                        continuationToken,
                        documentQueryParams);
        } else {
            createSkipComponentFunction = createBaseComponent;
        }

        BiFunction<String, PipelinedDocumentQueryParams<T>, Flux<IDocumentQueryExecutionComponent<T>>> createLimitComponentFunction;
        if (hybridSearchQueryInfo.hasTake() && hybridSearchQueryInfo.hasSkip()) {
            createLimitComponentFunction =
                (continuationToken, documentQueryParams) ->
                    TakeDocumentQueryExecutionContext.createAsync(createSkipComponentFunction,
                        hybridSearchQueryInfo.getTake(),
                        continuationToken,
                        documentQueryParams,
                        TakeDocumentQueryExecutionContext.TakeEnum.LIMIT);
        } else {
            createLimitComponentFunction = createSkipComponentFunction;
        }

        if (hybridSearchQueryInfo.hasTake()) {
            return (continuationToken, documentQueryParams) ->
                TakeDocumentQueryExecutionContext.createAsync(createLimitComponentFunction,
                    hybridSearchQueryInfo.getTake(),
                    continuationToken,
                    documentQueryParams,
                    TakeDocumentQueryExecutionContext.TakeEnum.TOP);
        } else {
            return createLimitComponentFunction;
        }
    }

    public QueryInfo getQueryInfo() {
        return this.queryInfo;
    }

    public HybridSearchQueryInfo getHybridSearchQueryInfo() {
        return this.hybridSearchQueryInfo;
    }
}
