// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.mediaservices.implementation;

import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.mediaservices.fluent.MediaServicesOperationResultsClient;
import com.azure.resourcemanager.mediaservices.fluent.models.MediaServiceInner;
import com.azure.resourcemanager.mediaservices.models.MediaService;
import com.azure.resourcemanager.mediaservices.models.MediaServicesOperationResults;
import com.azure.resourcemanager.mediaservices.models.MediaServicesOperationResultsGetResponse;

public final class MediaServicesOperationResultsImpl implements MediaServicesOperationResults {
    private static final ClientLogger LOGGER = new ClientLogger(MediaServicesOperationResultsImpl.class);

    private final MediaServicesOperationResultsClient innerClient;

    private final com.azure.resourcemanager.mediaservices.MediaServicesManager serviceManager;

    public MediaServicesOperationResultsImpl(MediaServicesOperationResultsClient innerClient,
        com.azure.resourcemanager.mediaservices.MediaServicesManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public Response<MediaService> getWithResponse(String locationName, String operationId, Context context) {
        MediaServicesOperationResultsGetResponse inner
            = this.serviceClient().getWithResponse(locationName, operationId, context);
        if (inner != null) {
            return new SimpleResponse<>(inner.getRequest(), inner.getStatusCode(), inner.getHeaders(),
                new MediaServiceImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public MediaService get(String locationName, String operationId) {
        MediaServiceInner inner = this.serviceClient().get(locationName, operationId);
        if (inner != null) {
            return new MediaServiceImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    private MediaServicesOperationResultsClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.resourcemanager.mediaservices.MediaServicesManager manager() {
        return this.serviceManager;
    }
}
