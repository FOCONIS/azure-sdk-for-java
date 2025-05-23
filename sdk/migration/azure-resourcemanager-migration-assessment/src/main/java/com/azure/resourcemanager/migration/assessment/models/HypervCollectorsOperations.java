// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.migration.assessment.models;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;

/**
 * Resource collection API of HypervCollectorsOperations.
 */
public interface HypervCollectorsOperations {
    /**
     * List HypervCollector resources by AssessmentProject.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param projectName Assessment Project Name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response of a HypervCollector list operation as paginated response with {@link PagedIterable}.
     */
    PagedIterable<HypervCollector> listByAssessmentProject(String resourceGroupName, String projectName);

    /**
     * List HypervCollector resources by AssessmentProject.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param projectName Assessment Project Name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response of a HypervCollector list operation as paginated response with {@link PagedIterable}.
     */
    PagedIterable<HypervCollector> listByAssessmentProject(String resourceGroupName, String projectName,
        Context context);

    /**
     * Get a HypervCollector.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param projectName Assessment Project Name.
     * @param hypervCollectorName Hyper-V collector ARM name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a HypervCollector along with {@link Response}.
     */
    Response<HypervCollector> getWithResponse(String resourceGroupName, String projectName, String hypervCollectorName,
        Context context);

    /**
     * Get a HypervCollector.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param projectName Assessment Project Name.
     * @param hypervCollectorName Hyper-V collector ARM name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a HypervCollector.
     */
    HypervCollector get(String resourceGroupName, String projectName, String hypervCollectorName);

    /**
     * Delete a HypervCollector.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param projectName Assessment Project Name.
     * @param hypervCollectorName Hyper-V collector ARM name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response}.
     */
    Response<Void> deleteWithResponse(String resourceGroupName, String projectName, String hypervCollectorName,
        Context context);

    /**
     * Delete a HypervCollector.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param projectName Assessment Project Name.
     * @param hypervCollectorName Hyper-V collector ARM name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void delete(String resourceGroupName, String projectName, String hypervCollectorName);

    /**
     * Get a HypervCollector.
     * 
     * @param id the resource ID.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a HypervCollector along with {@link Response}.
     */
    HypervCollector getById(String id);

    /**
     * Get a HypervCollector.
     * 
     * @param id the resource ID.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a HypervCollector along with {@link Response}.
     */
    Response<HypervCollector> getByIdWithResponse(String id, Context context);

    /**
     * Delete a HypervCollector.
     * 
     * @param id the resource ID.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void deleteById(String id);

    /**
     * Delete a HypervCollector.
     * 
     * @param id the resource ID.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response}.
     */
    Response<Void> deleteByIdWithResponse(String id, Context context);

    /**
     * Begins definition for a new HypervCollector resource.
     * 
     * @param name resource name.
     * @return the first stage of the new HypervCollector definition.
     */
    HypervCollector.DefinitionStages.Blank define(String name);
}
