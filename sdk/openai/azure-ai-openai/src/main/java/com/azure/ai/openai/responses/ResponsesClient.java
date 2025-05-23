// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.
package com.azure.ai.openai.responses;

import static com.azure.ai.openai.implementation.OpenAIUtils.addAzureVersionToRequestOptions;

import com.azure.ai.openai.responses.implementation.NonAzureResponsesClientImpl;
import com.azure.ai.openai.responses.implementation.OpenAIServerSentEvents;
import com.azure.ai.openai.responses.implementation.ResponsesClientImpl;
import com.azure.ai.openai.responses.implementation.accesshelpers.CreateResponsesRequestAccessHelper;
import com.azure.ai.openai.responses.models.CreateResponseRequestAccept;
import com.azure.ai.openai.responses.models.CreateResponsesRequest;
import com.azure.ai.openai.responses.models.CreateResponsesRequestIncludable;
import com.azure.ai.openai.responses.models.DeleteResponseResponse;
import com.azure.ai.openai.responses.models.ListInputItemsRequestOrder;
import com.azure.ai.openai.responses.models.ResponsesInputItemList;
import com.azure.ai.openai.responses.models.ResponsesItem;
import com.azure.ai.openai.responses.models.ResponsesResponse;
import com.azure.ai.openai.responses.models.ResponsesStreamEvent;
import com.azure.core.annotation.Generated;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceClient;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.exception.ClientAuthenticationException;
import com.azure.core.exception.HttpResponseException;
import com.azure.core.exception.ResourceModifiedException;
import com.azure.core.exception.ResourceNotFoundException;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.PagedResponseBase;
import com.azure.core.http.rest.RequestOptions;
import com.azure.core.http.rest.Response;
import com.azure.core.util.BinaryData;
import com.azure.core.util.IterableStream;
import java.nio.ByteBuffer;
import java.util.List;
import reactor.core.publisher.Flux;

/**
 * Initializes a new instance of the synchronous ResponsesClient type.
 */
@ServiceClient(builder = ResponsesClientBuilder.class)
public final class ResponsesClient {

    @Generated
    private final ResponsesClientImpl serviceClient;

    private final NonAzureResponsesClientImpl nonAzureServiceClient;

    /**
     * Initializes an instance of ResponsesClient class.
     *
     * @param serviceClient the service client implementation.
     */
    ResponsesClient(ResponsesClientImpl serviceClient) {
        this.serviceClient = serviceClient;
        this.nonAzureServiceClient = null;
    }

    /**
     * Initializes an instance of ResponsesClient class for NonAzure Implementation.
     *
     * @param serviceClient the service client implementation.
     */
    ResponsesClient(NonAzureResponsesClientImpl serviceClient) {
        this.serviceClient = null;
        this.nonAzureServiceClient = serviceClient;
    }

    /**
     * Creates a model response.
     * <p><strong>Request Body Schema</strong></p>
     *
     * <pre>
     * {@code
     * {
     *     model: String(o1/o1-2024-12-17/o1-preview/o1-preview-2024-09-12/o1-mini/o1-mini-2024-09-12/gpt-4o/gpt-4o-2024-11-20/gpt-4o-2024-08-06/gpt-4o-2024-05-13/gpt-4o-audio-preview/gpt-4o-audio-preview-2024-10-01/gpt-4o-audio-preview-2024-12-17/gpt-4o-mini-audio-preview/gpt-4o-mini-audio-preview-2024-12-17/chatgpt-4o-latest/gpt-4o-mini/gpt-4o-mini-2024-07-18/gpt-4-turbo/gpt-4-turbo-2024-04-09/gpt-4-0125-preview/gpt-4-turbo-preview/gpt-4-1106-preview/gpt-4-vision-preview/gpt-4/gpt-4-0314/gpt-4-0613/gpt-4-32k/gpt-4-32k-0314/gpt-4-32k-0613/gpt-3.5-turbo/gpt-3.5-turbo-16k/gpt-3.5-turbo-0301/gpt-3.5-turbo-0613/gpt-3.5-turbo-1106/gpt-3.5-turbo-0125/gpt-3.5-turbo-16k-0613) (Required)
     *     temperature: Double (Optional)
     *     top_p: Double (Optional)
     *     reasoning_effort: String(low/medium/high) (Optional)
     *     stream: Boolean (Optional)
     *     metadata (Optional): {
     *         String: String (Required)
     *     }
     *     input (Required): [
     *          (Required){
     *             type: String(message/function_call/function_call_output/computer_call/computer_call_output/file_search_call/web_search_call/code_interpreter_call) (Required)
     *             id: String (Required)
     *         }
     *     ]
     *     previous_response_id: String (Optional)
     *     tools (Optional): [
     *          (Optional){
     *             type: String(code_interpreter/function/file_search/web_search/computer-preview) (Required)
     *         }
     *     ]
     *     include (Optional): [
     *         String(output[*].file_search_call.search_results) (Optional)
     *     ]
     *     truncation: String(auto/disabled) (Optional)
     *     parallel_tool_calls: Boolean (Optional)
     * }
     * }
     * </pre>
     *
     * <p><strong>Response Body Schema</strong></p>
     *
     * <pre>
     * {@code
     * {
     *     id: String (Required)
     *     object: String (Required)
     *     created_at: long (Required)
     *     status: String(queued/in_progress/completed) (Required)
     *     model: String (Required)
     *     previous_response_id: String (Required)
     *     output (Required): [
     *          (Required){
     *             type: String(message/function_call/function_call_output/computer_call/computer_call_output/file_search_call/web_search_call/code_interpreter_call) (Required)
     *             id: String (Required)
     *         }
     *     ]
     *     error (Required): {
     *         message: String (Required)
     *         type: String (Required)
     *         param: String (Required)
     *         code: String (Required)
     *     }
     *     tools (Required): [
     *          (Required){
     *             type: String(code_interpreter/function/file_search/web_search/computer-preview) (Required)
     *         }
     *     ]
     *     truncation: String(auto/disabled) (Required)
     *     temperature: double (Required)
     *     top_p: double (Required)
     *     reasoning_effort: String(low/medium/high) (Required)
     *     usage (Required): {
     *         input_tokens: int (Required)
     *         output_tokens: int (Required)
     *         total_tokens: int (Required)
     *         output_tokens_details (Required): {
     *             reasoning_tokens: int (Required)
     *         }
     *     }
     *     metadata (Required): {
     *         String: String (Required)
     *     }
     * }
     * }
     * </pre>
     *
     * @param accept The accept parameter. Allowed values: "application/json", "text/event-stream".
     * @param requestBody The requestBody parameter.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the response body along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Response<BinaryData> createResponseWithResponse(String accept, BinaryData requestBody,
        RequestOptions requestOptions) {
        if (nonAzureServiceClient != null) {
            return nonAzureServiceClient.createResponseWithResponse(accept, requestBody, requestOptions);
        } else {
            addAzureVersionToRequestOptions(serviceClient.getEndpoint(), requestOptions,
                serviceClient.getServiceVersion());
            return this.serviceClient.createResponseWithResponse(accept, requestBody, requestOptions);
        }
    }

    /**
     * Retrieves a model response with the given ID.
     * <p><strong>Query Parameters</strong></p>
     * <table border="1">
     * <caption>Query Parameters</caption>
     * <tr><th>Name</th><th>Type</th><th>Required</th><th>Description</th></tr>
     * <tr><td>include</td><td>List&lt;String&gt;</td><td>No</td><td>Specifies additional output data to include in the
     * model response. In the form of "," separated string.</td></tr>
     * </table>
     * You can add these to a request with {@link RequestOptions#addQueryParam}
     * <p><strong>Response Body Schema</strong></p>
     *
     * <pre>
     * {@code
     * {
     *     id: String (Required)
     *     object: String (Required)
     *     created_at: long (Required)
     *     status: String(queued/in_progress/completed) (Required)
     *     model: String (Required)
     *     previous_response_id: String (Required)
     *     output (Required): [
     *          (Required){
     *             type: String(message/function_call/function_call_output/computer_call/computer_call_output/file_search_call/web_search_call/code_interpreter_call) (Required)
     *             id: String (Required)
     *         }
     *     ]
     *     error (Required): {
     *         message: String (Required)
     *         type: String (Required)
     *         param: String (Required)
     *         code: String (Required)
     *     }
     *     tools (Required): [
     *          (Required){
     *             type: String(code_interpreter/function/file_search/web_search/computer-preview) (Required)
     *         }
     *     ]
     *     truncation: String(auto/disabled) (Required)
     *     temperature: double (Required)
     *     top_p: double (Required)
     *     reasoning_effort: String(low/medium/high) (Required)
     *     usage (Required): {
     *         input_tokens: int (Required)
     *         output_tokens: int (Required)
     *         total_tokens: int (Required)
     *         output_tokens_details (Required): {
     *             reasoning_tokens: int (Required)
     *         }
     *     }
     *     metadata (Required): {
     *         String: String (Required)
     *     }
     * }
     * }
     * </pre>
     *
     * @param responseId The ID of the response to retrieve.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the response body along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Response<BinaryData> getResponseWithResponse(String responseId, RequestOptions requestOptions) {
        if (nonAzureServiceClient != null) {
            return nonAzureServiceClient.getResponseWithResponse(responseId, requestOptions);
        } else {
            addAzureVersionToRequestOptions(serviceClient.getEndpoint(), requestOptions,
                serviceClient.getServiceVersion());
            return this.serviceClient.getResponseWithResponse(responseId, requestOptions);
        }
    }

    /**
     * Returns a list of input items for a given response.
     * <p><strong>Response Body Schema</strong></p>
     *
     * <pre>
     * {@code
     * {
     *     object: String (Required)
     *     data (Required): [
     *          (Required){
     *             type: String(message/function_call/function_call_output/computer_call/computer_call_output/file_search_call/web_search_call/code_interpreter_call) (Required)
     *             id: String (Required)
     *         }
     *     ]
     *     first_id: String (Required)
     *     last_id: String (Required)
     *     has_more: boolean (Required)
     * }
     * }
     * </pre>
     *
     * @param responseId The ID of the response to retrieve.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the response body along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Response<BinaryData> listInputItemsWithResponse(String responseId, RequestOptions requestOptions) {
        if (nonAzureServiceClient != null) {
            return nonAzureServiceClient.listInputItemsWithResponse(responseId, requestOptions);
        } else {
            addAzureVersionToRequestOptions(serviceClient.getEndpoint(), requestOptions,
                serviceClient.getServiceVersion());
            return this.serviceClient.listInputItemsWithResponse(responseId, requestOptions);
        }
    }

    /**
     * Retrieves a model response with the given ID.
     *
     * @param responseId The ID of the response to retrieve.
     * @param includables The includables parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ResponsesResponse getResponse(String responseId, List<CreateResponsesRequestIncludable> includables) {
        // Generated convenience method for getResponseWithResponse
        RequestOptions requestOptions = new RequestOptions();
        if (includables != null) {
            for (CreateResponsesRequestIncludable paramItemValue : includables) {
                if (paramItemValue != null) {
                    requestOptions.addQueryParam("include[]", paramItemValue.toString(), false);
                }
            }
        }
        return getResponseWithResponse(responseId, requestOptions).getValue().toObject(ResponsesResponse.class);
    }

    /**
     * Retrieves a model response with the given ID.
     *
     * @param responseId The ID of the response to retrieve.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @Generated
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ResponsesResponse getResponse(String responseId) {
        // Generated convenience method for getResponseWithResponse
        RequestOptions requestOptions = new RequestOptions();
        return getResponseWithResponse(responseId, requestOptions).getValue().toObject(ResponsesResponse.class);
    }

    /**
     * Returns a list of input items for a given response.
     *
     * @param responseId The ID of the response to retrieve.
     * @param limit The maximum number of input items to return.
     * @param order The order in which to return the input items.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedIterable<ResponsesItem> listInputItems(String responseId, Integer limit,
        ListInputItemsRequestOrder order) {
        RequestOptions requestOptions = new RequestOptions();
        if (limit != null) {
            requestOptions.addQueryParam("limit", String.valueOf(limit), false);
        }
        if (order != null) {
            requestOptions.addQueryParam("order", order.toString(), false);
        }

        return new PagedIterable<>(() -> {
            Response<BinaryData> response = listInputItemsWithResponse(responseId, requestOptions);
            ResponsesInputItemList pagedItems = response.getValue().toObject(ResponsesInputItemList.class);
            return new PagedResponseBase<>(response.getRequest(), response.getStatusCode(), response.getHeaders(),
                pagedItems.getData(), pagedItems.isHasMore() ? pagedItems.getLastId() : null, response.getHeaders());
        }, nextLink -> {
            RequestOptions nextPageRequestOptions = new RequestOptions();
            if (limit != null) {
                nextPageRequestOptions.addQueryParam("limit", String.valueOf(limit), false);
            }
            if (order != null) {
                nextPageRequestOptions.addQueryParam("order", order.toString(), false);
            }
            // nextLink is always define, as it being `null` is the break condition for the loop
            nextPageRequestOptions.addQueryParam("after", nextLink, false);

            Response<BinaryData> response = listInputItemsWithResponse(responseId, nextPageRequestOptions);
            ResponsesInputItemList pagedItems = response.getValue().toObject(ResponsesInputItemList.class);

            return new PagedResponseBase<>(response.getRequest(), response.getStatusCode(), response.getHeaders(),
                pagedItems.getData(), pagedItems.isHasMore() ? pagedItems.getLastId() : null, response.getHeaders());
        });
    }

    /**
     * Creates a model response.
     *
     * @param accept The accept parameter.
     * @param requestBody The requestBody parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private ResponsesResponse createResponse(CreateResponseRequestAccept accept, CreateResponsesRequest requestBody) {
        // Generated convenience method for createResponseWithResponse
        RequestOptions requestOptions = new RequestOptions();
        return createResponseWithResponse(accept.toString(), BinaryData.fromObject(requestBody), requestOptions)
            .getValue()
            .toObject(ResponsesResponse.class);
    }

    /**
     * Creates a model response.
     *
     * @param requestBody The requestBody parameter.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ResponsesResponse createResponse(CreateResponsesRequest requestBody, RequestOptions requestOptions) {
        CreateResponsesRequestAccessHelper.setStream(requestBody, false);
        return createResponseWithResponse(CreateResponseRequestAccept.APPLICATION_JSON.toString(),
            BinaryData.fromObject(requestBody), requestOptions).getValue().toObject(ResponsesResponse.class);
    }

    /**
     * Creates a model response.
     *
     * @param requestBody The requestBody parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public ResponsesResponse createResponse(CreateResponsesRequest requestBody) {
        CreateResponsesRequestAccessHelper.setStream(requestBody, false);
        RequestOptions requestOptions = new RequestOptions();
        return createResponseWithResponse(CreateResponseRequestAccept.APPLICATION_JSON.toString(),
            BinaryData.fromObject(requestBody), requestOptions).getValue().toObject(ResponsesResponse.class);
    }

    /**
     * Creates a model response.
     *
     * @param requestBody The requestBody parameter.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public IterableStream<ResponsesStreamEvent> createResponseStreaming(CreateResponsesRequest requestBody,
        RequestOptions requestOptions) {
        CreateResponsesRequestAccessHelper.setStream(requestBody, true);
        Flux<ByteBuffer> events = createResponseWithResponse(CreateResponseRequestAccept.TEXT_EVENT_STREAM.toString(),
            BinaryData.fromObject(requestBody), requestOptions).getValue().toFluxByteBuffer();
        OpenAIServerSentEvents eventsProcessor = new OpenAIServerSentEvents(events);
        return new IterableStream<>(eventsProcessor.getEvents());
    }

    /**
     * Creates a model response.
     *
     * @param requestBody The requestBody parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public IterableStream<ResponsesStreamEvent> createResponseStreaming(CreateResponsesRequest requestBody) {
        RequestOptions requestOptions = new RequestOptions();
        CreateResponsesRequestAccessHelper.setStream(requestBody, true);
        Flux<ByteBuffer> events = createResponseWithResponse(CreateResponseRequestAccept.TEXT_EVENT_STREAM.toString(),
            BinaryData.fromObject(requestBody), requestOptions).getValue().toFluxByteBuffer();
        OpenAIServerSentEvents eventsProcessor = new OpenAIServerSentEvents(events);
        return new IterableStream<>(eventsProcessor.getEvents());
    }

    /**
     * Deletes a response by ID.
     * <p><strong>Response Body Schema</strong></p>
     *
     * <pre>
     * {@code
     * {
     *     object: String (Required)
     *     id: String (Required)
     *     deleted: boolean (Required)
     * }
     * }
     * </pre>
     *
     * @param responseId The responseId parameter.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @return the response body along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    private Response<BinaryData> deleteResponseWithResponse(String responseId, RequestOptions requestOptions) {
        if (nonAzureServiceClient != null) {
            return nonAzureServiceClient.deleteResponseWithResponse(responseId, requestOptions);
        } else {
            addAzureVersionToRequestOptions(serviceClient.getEndpoint(), requestOptions,
                serviceClient.getServiceVersion());
            return this.serviceClient.deleteResponseWithResponse(responseId, requestOptions);
        }
    }

    /**
     * Deletes a response by ID.
     *
     * @param responseId The responseId parameter.
     * @param requestOptions The options to configure the HTTP request before HTTP client sends it.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public DeleteResponseResponse deleteResponse(String responseId, RequestOptions requestOptions) {
        return deleteResponseWithResponse(responseId, requestOptions).getValue().toObject(DeleteResponseResponse.class);
    }

    /**
     * Deletes a response by ID.
     *
     * @param responseId The responseId parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws HttpResponseException thrown if the request is rejected by server.
     * @throws ClientAuthenticationException thrown if the request is rejected by server on status code 401.
     * @throws ResourceNotFoundException thrown if the request is rejected by server on status code 404.
     * @throws ResourceModifiedException thrown if the request is rejected by server on status code 409.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public DeleteResponseResponse deleteResponse(String responseId) {
        RequestOptions requestOptions = new RequestOptions();
        return deleteResponseWithResponse(responseId, requestOptions).getValue().toObject(DeleteResponseResponse.class);
    }
}
