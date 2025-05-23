// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.netapp.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.netapp.models.Dimension;
import com.azure.resourcemanager.netapp.models.MetricAggregationType;
import com.azure.resourcemanager.netapp.models.MetricSpecification;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class MetricSpecificationTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        MetricSpecification model = BinaryData.fromString(
            "{\"name\":\"otkftutqxlngx\",\"displayName\":\"fgugnxkrxdqmid\",\"displayDescription\":\"hzrvqd\",\"unit\":\"bhj\",\"supportedAggregationTypes\":[\"Average\",\"Average\"],\"supportedTimeGrainTypes\":[\"qfbow\",\"kanyktzlcuiywg\",\"ywgndrv\"],\"internalMetricName\":\"hzgpphrcgyncocpe\",\"enableRegionalMdmAccount\":false,\"sourceMdmAccount\":\"mcoo\",\"sourceMdmNamespace\":\"xlzevgbmqjqabcy\",\"dimensions\":[{\"name\":\"kwlzuvccfwnfn\",\"displayName\":\"cfionl\"},{\"name\":\"x\",\"displayName\":\"qgtz\"},{\"name\":\"pnqbqqwxrjfe\",\"displayName\":\"lnwsubisn\"},{\"name\":\"mpmngnzscxaqwoo\",\"displayName\":\"cbonqvpk\"}],\"aggregationType\":\"rxnjeaseipheofl\",\"fillGapWithZero\":false,\"category\":\"y\",\"resourceIdDimensionNameOverride\":\"nj\",\"isInternal\":true}")
            .toObject(MetricSpecification.class);
        Assertions.assertEquals("otkftutqxlngx", model.name());
        Assertions.assertEquals("fgugnxkrxdqmid", model.displayName());
        Assertions.assertEquals("hzrvqd", model.displayDescription());
        Assertions.assertEquals("bhj", model.unit());
        Assertions.assertEquals(MetricAggregationType.AVERAGE, model.supportedAggregationTypes().get(0));
        Assertions.assertEquals("qfbow", model.supportedTimeGrainTypes().get(0));
        Assertions.assertEquals("hzgpphrcgyncocpe", model.internalMetricName());
        Assertions.assertEquals(false, model.enableRegionalMdmAccount());
        Assertions.assertEquals("mcoo", model.sourceMdmAccount());
        Assertions.assertEquals("xlzevgbmqjqabcy", model.sourceMdmNamespace());
        Assertions.assertEquals("kwlzuvccfwnfn", model.dimensions().get(0).name());
        Assertions.assertEquals("cfionl", model.dimensions().get(0).displayName());
        Assertions.assertEquals("rxnjeaseipheofl", model.aggregationType());
        Assertions.assertEquals(false, model.fillGapWithZero());
        Assertions.assertEquals("y", model.category());
        Assertions.assertEquals("nj", model.resourceIdDimensionNameOverride());
        Assertions.assertEquals(true, model.isInternal());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        MetricSpecification model = new MetricSpecification().withName("otkftutqxlngx")
            .withDisplayName("fgugnxkrxdqmid")
            .withDisplayDescription("hzrvqd")
            .withUnit("bhj")
            .withSupportedAggregationTypes(Arrays.asList(MetricAggregationType.AVERAGE, MetricAggregationType.AVERAGE))
            .withSupportedTimeGrainTypes(Arrays.asList("qfbow", "kanyktzlcuiywg", "ywgndrv"))
            .withInternalMetricName("hzgpphrcgyncocpe")
            .withEnableRegionalMdmAccount(false)
            .withSourceMdmAccount("mcoo")
            .withSourceMdmNamespace("xlzevgbmqjqabcy")
            .withDimensions(Arrays.asList(new Dimension().withName("kwlzuvccfwnfn").withDisplayName("cfionl"),
                new Dimension().withName("x").withDisplayName("qgtz"),
                new Dimension().withName("pnqbqqwxrjfe").withDisplayName("lnwsubisn"),
                new Dimension().withName("mpmngnzscxaqwoo").withDisplayName("cbonqvpk")))
            .withAggregationType("rxnjeaseipheofl")
            .withFillGapWithZero(false)
            .withCategory("y")
            .withResourceIdDimensionNameOverride("nj")
            .withIsInternal(true);
        model = BinaryData.fromObject(model).toObject(MetricSpecification.class);
        Assertions.assertEquals("otkftutqxlngx", model.name());
        Assertions.assertEquals("fgugnxkrxdqmid", model.displayName());
        Assertions.assertEquals("hzrvqd", model.displayDescription());
        Assertions.assertEquals("bhj", model.unit());
        Assertions.assertEquals(MetricAggregationType.AVERAGE, model.supportedAggregationTypes().get(0));
        Assertions.assertEquals("qfbow", model.supportedTimeGrainTypes().get(0));
        Assertions.assertEquals("hzgpphrcgyncocpe", model.internalMetricName());
        Assertions.assertEquals(false, model.enableRegionalMdmAccount());
        Assertions.assertEquals("mcoo", model.sourceMdmAccount());
        Assertions.assertEquals("xlzevgbmqjqabcy", model.sourceMdmNamespace());
        Assertions.assertEquals("kwlzuvccfwnfn", model.dimensions().get(0).name());
        Assertions.assertEquals("cfionl", model.dimensions().get(0).displayName());
        Assertions.assertEquals("rxnjeaseipheofl", model.aggregationType());
        Assertions.assertEquals(false, model.fillGapWithZero());
        Assertions.assertEquals("y", model.category());
        Assertions.assertEquals("nj", model.resourceIdDimensionNameOverride());
        Assertions.assertEquals(true, model.isInternal());
    }
}
