// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.durabletask.generated;

/**
 * Samples for Schedulers Delete.
 */
public final class SchedulersDeleteSamples {
    /*
     * x-ms-original-file: 2025-04-01-preview/Schedulers_Delete.json
     */
    /**
     * Sample code: Schedulers_Delete.
     * 
     * @param manager Entry point to DurableTaskManager.
     */
    public static void schedulersDelete(com.azure.resourcemanager.durabletask.DurableTaskManager manager) {
        manager.schedulers().delete("rgopenapi", "testscheduler", com.azure.core.util.Context.NONE);
    }
}
