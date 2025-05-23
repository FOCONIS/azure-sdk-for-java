// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.logic.generated;

import com.azure.resourcemanager.logic.models.BatchConfigurationProperties;
import com.azure.resourcemanager.logic.models.BatchReleaseCriteria;
import com.azure.resourcemanager.logic.models.RecurrenceFrequency;
import com.azure.resourcemanager.logic.models.WorkflowTriggerRecurrence;

/**
 * Samples for IntegrationAccountBatchConfigurations CreateOrUpdate.
 */
public final class IntegrationAccountBatchConfigurationsCreateOrUpdateSamples {
    /*
     * x-ms-original-file: specification/logic/resource-manager/Microsoft.Logic/stable/2019-05-01/examples/
     * IntegrationAccountBatchConfigurations_CreateOrUpdate.json
     */
    /**
     * Sample code: Create or update a batch configuration.
     * 
     * @param manager Entry point to LogicManager.
     */
    public static void createOrUpdateABatchConfiguration(com.azure.resourcemanager.logic.LogicManager manager) {
        manager.integrationAccountBatchConfigurations()
            .define("testBatchConfiguration")
            .withRegion("westus")
            .withExistingIntegrationAccount("testResourceGroup", "testIntegrationAccount")
            .withProperties(new BatchConfigurationProperties().withBatchGroupName("DEFAULT")
                .withReleaseCriteria(new BatchReleaseCriteria().withMessageCount(10)
                    .withBatchSize(234567)
                    .withRecurrence(new WorkflowTriggerRecurrence().withFrequency(RecurrenceFrequency.MINUTE)
                        .withInterval(1)
                        .withStartTime("2017-03-24T11:43:00")
                        .withTimeZone("India Standard Time"))))
            .create();
    }
}
