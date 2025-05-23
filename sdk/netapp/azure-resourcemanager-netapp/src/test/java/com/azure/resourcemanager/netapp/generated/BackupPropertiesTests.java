// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.netapp.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.netapp.fluent.models.BackupProperties;
import org.junit.jupiter.api.Assertions;

public final class BackupPropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        BackupProperties model = BinaryData.fromString(
            "{\"backupId\":\"kq\",\"creationDate\":\"2021-05-30T08:11:11Z\",\"snapshotCreationDate\":\"2021-11-18T10:38:36Z\",\"completionDate\":\"2021-08-16T02:48:50Z\",\"provisioningState\":\"sjc\",\"size\":9014783078965490836,\"label\":\"ntiew\",\"backupType\":\"Manual\",\"failureReason\":\"bquwrbehw\",\"volumeResourceId\":\"gohbuffkmrq\",\"useExistingSnapshot\":true,\"snapshotName\":\"hmxtdr\",\"backupPolicyResourceId\":\"utacoe\",\"isLargeVolume\":false}")
            .toObject(BackupProperties.class);
        Assertions.assertEquals("ntiew", model.label());
        Assertions.assertEquals("gohbuffkmrq", model.volumeResourceId());
        Assertions.assertEquals(true, model.useExistingSnapshot());
        Assertions.assertEquals("hmxtdr", model.snapshotName());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        BackupProperties model = new BackupProperties().withLabel("ntiew")
            .withVolumeResourceId("gohbuffkmrq")
            .withUseExistingSnapshot(true)
            .withSnapshotName("hmxtdr");
        model = BinaryData.fromObject(model).toObject(BackupProperties.class);
        Assertions.assertEquals("ntiew", model.label());
        Assertions.assertEquals("gohbuffkmrq", model.volumeResourceId());
        Assertions.assertEquals(true, model.useExistingSnapshot());
        Assertions.assertEquals("hmxtdr", model.snapshotName());
    }
}
