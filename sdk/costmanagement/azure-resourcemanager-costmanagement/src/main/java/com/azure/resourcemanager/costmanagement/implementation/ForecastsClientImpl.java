// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.costmanagement.implementation;

import com.azure.core.annotation.BodyParam;
import com.azure.core.annotation.ExpectedResponses;
import com.azure.core.annotation.HeaderParam;
import com.azure.core.annotation.Headers;
import com.azure.core.annotation.Host;
import com.azure.core.annotation.HostParam;
import com.azure.core.annotation.PathParam;
import com.azure.core.annotation.Post;
import com.azure.core.annotation.QueryParam;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceInterface;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.annotation.UnexpectedResponseExceptionType;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.RestProxy;
import com.azure.core.management.exception.ManagementException;
import com.azure.core.util.Context;
import com.azure.core.util.FluxUtil;
import com.azure.resourcemanager.costmanagement.fluent.ForecastsClient;
import com.azure.resourcemanager.costmanagement.fluent.models.ForecastResultInner;
import com.azure.resourcemanager.costmanagement.models.ExternalCloudProviderType;
import com.azure.resourcemanager.costmanagement.models.ForecastDefinition;
import reactor.core.publisher.Mono;

/**
 * An instance of this class provides access to all the operations defined in ForecastsClient.
 */
public final class ForecastsClientImpl implements ForecastsClient {
    /**
     * The proxy service used to perform REST calls.
     */
    private final ForecastsService service;

    /**
     * The service client containing this operation class.
     */
    private final CostManagementClientImpl client;

    /**
     * Initializes an instance of ForecastsClientImpl.
     * 
     * @param client the instance of the service client containing this operation class.
     */
    ForecastsClientImpl(CostManagementClientImpl client) {
        this.service
            = RestProxy.create(ForecastsService.class, client.getHttpPipeline(), client.getSerializerAdapter());
        this.client = client;
    }

    /**
     * The interface defining all the services for CostManagementClientForecasts to be used by the proxy service to
     * perform REST calls.
     */
    @Host("{$host}")
    @ServiceInterface(name = "CostManagementClient")
    public interface ForecastsService {
        @Headers({ "Content-Type: application/json" })
        @Post("/{scope}/providers/Microsoft.CostManagement/forecast")
        @ExpectedResponses({ 200, 204 })
        @UnexpectedResponseExceptionType(ManagementException.class)
        Mono<Response<ForecastResultInner>> usage(@HostParam("$host") String endpoint,
            @QueryParam("$filter") String filter, @QueryParam("api-version") String apiVersion,
            @PathParam(value = "scope", encoded = true) String scope,
            @BodyParam("application/json") ForecastDefinition parameters, @HeaderParam("Accept") String accept,
            Context context);

        @Headers({ "Content-Type: application/json" })
        @Post("/providers/Microsoft.CostManagement/{externalCloudProviderType}/{externalCloudProviderId}/forecast")
        @ExpectedResponses({ 200 })
        @UnexpectedResponseExceptionType(ManagementException.class)
        Mono<Response<ForecastResultInner>> externalCloudProviderUsage(@HostParam("$host") String endpoint,
            @QueryParam("$filter") String filter, @QueryParam("api-version") String apiVersion,
            @PathParam("externalCloudProviderType") ExternalCloudProviderType externalCloudProviderType,
            @PathParam("externalCloudProviderId") String externalCloudProviderId,
            @BodyParam("application/json") ForecastDefinition parameters, @HeaderParam("Accept") String accept,
            Context context);
    }

    /**
     * Lists the forecast charges for scope defined.
     * 
     * @param scope The scope associated with forecast operations. This includes '/subscriptions/{subscriptionId}/' for
     * subscription scope, '/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}' for resourceGroup scope,
     * '/providers/Microsoft.Billing/billingAccounts/{billingAccountId}' for Billing Account scope and
     * '/providers/Microsoft.Billing/billingAccounts/{billingAccountId}/departments/{departmentId}' for Department
     * scope, '/providers/Microsoft.Billing/billingAccounts/{billingAccountId}/enrollmentAccounts/{enrollmentAccountId}'
     * for EnrollmentAccount scope, '/providers/Microsoft.Management/managementGroups/{managementGroupId} for Management
     * Group scope, '/providers/Microsoft.Billing/billingAccounts/{billingAccountId}/billingProfiles/{billingProfileId}'
     * for billingProfile scope,
     * '/providers/Microsoft.Billing/billingAccounts/{billingAccountId}/billingProfiles/{billingProfileId}/invoiceSections/{invoiceSectionId}'
     * for invoiceSection scope, and
     * '/providers/Microsoft.Billing/billingAccounts/{billingAccountId}/customers/{customerId}' specific for partners.
     * @param parameters Parameters supplied to the CreateOrUpdate Forecast Config operation.
     * @param filter May be used to filter forecasts by properties/usageDate (Utc time), properties/chargeType or
     * properties/grain. The filter supports 'eq', 'lt', 'gt', 'le', 'ge', and 'and'. It does not currently support
     * 'ne', 'or', or 'not'.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of forecast along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<Response<ForecastResultInner>> usageWithResponseAsync(String scope, ForecastDefinition parameters,
        String filter) {
        if (this.client.getEndpoint() == null) {
            return Mono.error(
                new IllegalArgumentException("Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (scope == null) {
            return Mono.error(new IllegalArgumentException("Parameter scope is required and cannot be null."));
        }
        if (parameters == null) {
            return Mono.error(new IllegalArgumentException("Parameter parameters is required and cannot be null."));
        } else {
            parameters.validate();
        }
        final String accept = "application/json";
        return FluxUtil
            .withContext(context -> service.usage(this.client.getEndpoint(), filter, this.client.getApiVersion(), scope,
                parameters, accept, context))
            .contextWrite(context -> context.putAll(FluxUtil.toReactorContext(this.client.getContext()).readOnly()));
    }

    /**
     * Lists the forecast charges for scope defined.
     * 
     * @param scope The scope associated with forecast operations. This includes '/subscriptions/{subscriptionId}/' for
     * subscription scope, '/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}' for resourceGroup scope,
     * '/providers/Microsoft.Billing/billingAccounts/{billingAccountId}' for Billing Account scope and
     * '/providers/Microsoft.Billing/billingAccounts/{billingAccountId}/departments/{departmentId}' for Department
     * scope, '/providers/Microsoft.Billing/billingAccounts/{billingAccountId}/enrollmentAccounts/{enrollmentAccountId}'
     * for EnrollmentAccount scope, '/providers/Microsoft.Management/managementGroups/{managementGroupId} for Management
     * Group scope, '/providers/Microsoft.Billing/billingAccounts/{billingAccountId}/billingProfiles/{billingProfileId}'
     * for billingProfile scope,
     * '/providers/Microsoft.Billing/billingAccounts/{billingAccountId}/billingProfiles/{billingProfileId}/invoiceSections/{invoiceSectionId}'
     * for invoiceSection scope, and
     * '/providers/Microsoft.Billing/billingAccounts/{billingAccountId}/customers/{customerId}' specific for partners.
     * @param parameters Parameters supplied to the CreateOrUpdate Forecast Config operation.
     * @param filter May be used to filter forecasts by properties/usageDate (Utc time), properties/chargeType or
     * properties/grain. The filter supports 'eq', 'lt', 'gt', 'le', 'ge', and 'and'. It does not currently support
     * 'ne', 'or', or 'not'.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of forecast along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<Response<ForecastResultInner>> usageWithResponseAsync(String scope, ForecastDefinition parameters,
        String filter, Context context) {
        if (this.client.getEndpoint() == null) {
            return Mono.error(
                new IllegalArgumentException("Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (scope == null) {
            return Mono.error(new IllegalArgumentException("Parameter scope is required and cannot be null."));
        }
        if (parameters == null) {
            return Mono.error(new IllegalArgumentException("Parameter parameters is required and cannot be null."));
        } else {
            parameters.validate();
        }
        final String accept = "application/json";
        context = this.client.mergeContext(context);
        return service.usage(this.client.getEndpoint(), filter, this.client.getApiVersion(), scope, parameters, accept,
            context);
    }

    /**
     * Lists the forecast charges for scope defined.
     * 
     * @param scope The scope associated with forecast operations. This includes '/subscriptions/{subscriptionId}/' for
     * subscription scope, '/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}' for resourceGroup scope,
     * '/providers/Microsoft.Billing/billingAccounts/{billingAccountId}' for Billing Account scope and
     * '/providers/Microsoft.Billing/billingAccounts/{billingAccountId}/departments/{departmentId}' for Department
     * scope, '/providers/Microsoft.Billing/billingAccounts/{billingAccountId}/enrollmentAccounts/{enrollmentAccountId}'
     * for EnrollmentAccount scope, '/providers/Microsoft.Management/managementGroups/{managementGroupId} for Management
     * Group scope, '/providers/Microsoft.Billing/billingAccounts/{billingAccountId}/billingProfiles/{billingProfileId}'
     * for billingProfile scope,
     * '/providers/Microsoft.Billing/billingAccounts/{billingAccountId}/billingProfiles/{billingProfileId}/invoiceSections/{invoiceSectionId}'
     * for invoiceSection scope, and
     * '/providers/Microsoft.Billing/billingAccounts/{billingAccountId}/customers/{customerId}' specific for partners.
     * @param parameters Parameters supplied to the CreateOrUpdate Forecast Config operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of forecast on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<ForecastResultInner> usageAsync(String scope, ForecastDefinition parameters) {
        final String filter = null;
        return usageWithResponseAsync(scope, parameters, filter).flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Lists the forecast charges for scope defined.
     * 
     * @param scope The scope associated with forecast operations. This includes '/subscriptions/{subscriptionId}/' for
     * subscription scope, '/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}' for resourceGroup scope,
     * '/providers/Microsoft.Billing/billingAccounts/{billingAccountId}' for Billing Account scope and
     * '/providers/Microsoft.Billing/billingAccounts/{billingAccountId}/departments/{departmentId}' for Department
     * scope, '/providers/Microsoft.Billing/billingAccounts/{billingAccountId}/enrollmentAccounts/{enrollmentAccountId}'
     * for EnrollmentAccount scope, '/providers/Microsoft.Management/managementGroups/{managementGroupId} for Management
     * Group scope, '/providers/Microsoft.Billing/billingAccounts/{billingAccountId}/billingProfiles/{billingProfileId}'
     * for billingProfile scope,
     * '/providers/Microsoft.Billing/billingAccounts/{billingAccountId}/billingProfiles/{billingProfileId}/invoiceSections/{invoiceSectionId}'
     * for invoiceSection scope, and
     * '/providers/Microsoft.Billing/billingAccounts/{billingAccountId}/customers/{customerId}' specific for partners.
     * @param parameters Parameters supplied to the CreateOrUpdate Forecast Config operation.
     * @param filter May be used to filter forecasts by properties/usageDate (Utc time), properties/chargeType or
     * properties/grain. The filter supports 'eq', 'lt', 'gt', 'le', 'ge', and 'and'. It does not currently support
     * 'ne', 'or', or 'not'.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of forecast along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ForecastResultInner> usageWithResponse(String scope, ForecastDefinition parameters, String filter,
        Context context) {
        return usageWithResponseAsync(scope, parameters, filter, context).block();
    }

    /**
     * Lists the forecast charges for scope defined.
     * 
     * @param scope The scope associated with forecast operations. This includes '/subscriptions/{subscriptionId}/' for
     * subscription scope, '/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}' for resourceGroup scope,
     * '/providers/Microsoft.Billing/billingAccounts/{billingAccountId}' for Billing Account scope and
     * '/providers/Microsoft.Billing/billingAccounts/{billingAccountId}/departments/{departmentId}' for Department
     * scope, '/providers/Microsoft.Billing/billingAccounts/{billingAccountId}/enrollmentAccounts/{enrollmentAccountId}'
     * for EnrollmentAccount scope, '/providers/Microsoft.Management/managementGroups/{managementGroupId} for Management
     * Group scope, '/providers/Microsoft.Billing/billingAccounts/{billingAccountId}/billingProfiles/{billingProfileId}'
     * for billingProfile scope,
     * '/providers/Microsoft.Billing/billingAccounts/{billingAccountId}/billingProfiles/{billingProfileId}/invoiceSections/{invoiceSectionId}'
     * for invoiceSection scope, and
     * '/providers/Microsoft.Billing/billingAccounts/{billingAccountId}/customers/{customerId}' specific for partners.
     * @param parameters Parameters supplied to the CreateOrUpdate Forecast Config operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of forecast.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ForecastResultInner usage(String scope, ForecastDefinition parameters) {
        final String filter = null;
        return usageWithResponse(scope, parameters, filter, Context.NONE).getValue();
    }

    /**
     * Lists the forecast charges for external cloud provider type defined.
     * 
     * @param externalCloudProviderType The external cloud provider type associated with dimension/query operations.
     * This includes 'externalSubscriptions' for linked account and 'externalBillingAccounts' for consolidated account.
     * @param externalCloudProviderId This can be '{externalSubscriptionId}' for linked account or
     * '{externalBillingAccountId}' for consolidated account used with dimension/query operations.
     * @param parameters Parameters supplied to the CreateOrUpdate Forecast Config operation.
     * @param filter May be used to filter forecasts by properties/usageDate (Utc time), properties/chargeType or
     * properties/grain. The filter supports 'eq', 'lt', 'gt', 'le', 'ge', and 'and'. It does not currently support
     * 'ne', 'or', or 'not'.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of forecast along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<Response<ForecastResultInner>> externalCloudProviderUsageWithResponseAsync(
        ExternalCloudProviderType externalCloudProviderType, String externalCloudProviderId,
        ForecastDefinition parameters, String filter) {
        if (this.client.getEndpoint() == null) {
            return Mono.error(
                new IllegalArgumentException("Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (externalCloudProviderType == null) {
            return Mono.error(
                new IllegalArgumentException("Parameter externalCloudProviderType is required and cannot be null."));
        }
        if (externalCloudProviderId == null) {
            return Mono.error(
                new IllegalArgumentException("Parameter externalCloudProviderId is required and cannot be null."));
        }
        if (parameters == null) {
            return Mono.error(new IllegalArgumentException("Parameter parameters is required and cannot be null."));
        } else {
            parameters.validate();
        }
        final String accept = "application/json";
        return FluxUtil
            .withContext(context -> service.externalCloudProviderUsage(this.client.getEndpoint(), filter,
                this.client.getApiVersion(), externalCloudProviderType, externalCloudProviderId, parameters, accept,
                context))
            .contextWrite(context -> context.putAll(FluxUtil.toReactorContext(this.client.getContext()).readOnly()));
    }

    /**
     * Lists the forecast charges for external cloud provider type defined.
     * 
     * @param externalCloudProviderType The external cloud provider type associated with dimension/query operations.
     * This includes 'externalSubscriptions' for linked account and 'externalBillingAccounts' for consolidated account.
     * @param externalCloudProviderId This can be '{externalSubscriptionId}' for linked account or
     * '{externalBillingAccountId}' for consolidated account used with dimension/query operations.
     * @param parameters Parameters supplied to the CreateOrUpdate Forecast Config operation.
     * @param filter May be used to filter forecasts by properties/usageDate (Utc time), properties/chargeType or
     * properties/grain. The filter supports 'eq', 'lt', 'gt', 'le', 'ge', and 'and'. It does not currently support
     * 'ne', 'or', or 'not'.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of forecast along with {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<Response<ForecastResultInner>> externalCloudProviderUsageWithResponseAsync(
        ExternalCloudProviderType externalCloudProviderType, String externalCloudProviderId,
        ForecastDefinition parameters, String filter, Context context) {
        if (this.client.getEndpoint() == null) {
            return Mono.error(
                new IllegalArgumentException("Parameter this.client.getEndpoint() is required and cannot be null."));
        }
        if (externalCloudProviderType == null) {
            return Mono.error(
                new IllegalArgumentException("Parameter externalCloudProviderType is required and cannot be null."));
        }
        if (externalCloudProviderId == null) {
            return Mono.error(
                new IllegalArgumentException("Parameter externalCloudProviderId is required and cannot be null."));
        }
        if (parameters == null) {
            return Mono.error(new IllegalArgumentException("Parameter parameters is required and cannot be null."));
        } else {
            parameters.validate();
        }
        final String accept = "application/json";
        context = this.client.mergeContext(context);
        return service.externalCloudProviderUsage(this.client.getEndpoint(), filter, this.client.getApiVersion(),
            externalCloudProviderType, externalCloudProviderId, parameters, accept, context);
    }

    /**
     * Lists the forecast charges for external cloud provider type defined.
     * 
     * @param externalCloudProviderType The external cloud provider type associated with dimension/query operations.
     * This includes 'externalSubscriptions' for linked account and 'externalBillingAccounts' for consolidated account.
     * @param externalCloudProviderId This can be '{externalSubscriptionId}' for linked account or
     * '{externalBillingAccountId}' for consolidated account used with dimension/query operations.
     * @param parameters Parameters supplied to the CreateOrUpdate Forecast Config operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of forecast on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Mono<ForecastResultInner> externalCloudProviderUsageAsync(
        ExternalCloudProviderType externalCloudProviderType, String externalCloudProviderId,
        ForecastDefinition parameters) {
        final String filter = null;
        return externalCloudProviderUsageWithResponseAsync(externalCloudProviderType, externalCloudProviderId,
            parameters, filter).flatMap(res -> Mono.justOrEmpty(res.getValue()));
    }

    /**
     * Lists the forecast charges for external cloud provider type defined.
     * 
     * @param externalCloudProviderType The external cloud provider type associated with dimension/query operations.
     * This includes 'externalSubscriptions' for linked account and 'externalBillingAccounts' for consolidated account.
     * @param externalCloudProviderId This can be '{externalSubscriptionId}' for linked account or
     * '{externalBillingAccountId}' for consolidated account used with dimension/query operations.
     * @param parameters Parameters supplied to the CreateOrUpdate Forecast Config operation.
     * @param filter May be used to filter forecasts by properties/usageDate (Utc time), properties/chargeType or
     * properties/grain. The filter supports 'eq', 'lt', 'gt', 'le', 'ge', and 'and'. It does not currently support
     * 'ne', 'or', or 'not'.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of forecast along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<ForecastResultInner> externalCloudProviderUsageWithResponse(
        ExternalCloudProviderType externalCloudProviderType, String externalCloudProviderId,
        ForecastDefinition parameters, String filter, Context context) {
        return externalCloudProviderUsageWithResponseAsync(externalCloudProviderType, externalCloudProviderId,
            parameters, filter, context).block();
    }

    /**
     * Lists the forecast charges for external cloud provider type defined.
     * 
     * @param externalCloudProviderType The external cloud provider type associated with dimension/query operations.
     * This includes 'externalSubscriptions' for linked account and 'externalBillingAccounts' for consolidated account.
     * @param externalCloudProviderId This can be '{externalSubscriptionId}' for linked account or
     * '{externalBillingAccountId}' for consolidated account used with dimension/query operations.
     * @param parameters Parameters supplied to the CreateOrUpdate Forecast Config operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return result of forecast.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ForecastResultInner externalCloudProviderUsage(ExternalCloudProviderType externalCloudProviderType,
        String externalCloudProviderId, ForecastDefinition parameters) {
        final String filter = null;
        return externalCloudProviderUsageWithResponse(externalCloudProviderType, externalCloudProviderId, parameters,
            filter, Context.NONE).getValue();
    }
}
