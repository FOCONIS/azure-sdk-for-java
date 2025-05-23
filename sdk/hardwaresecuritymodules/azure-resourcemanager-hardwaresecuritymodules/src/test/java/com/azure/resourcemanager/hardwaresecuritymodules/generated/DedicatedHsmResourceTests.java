// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.hardwaresecuritymodules.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.hardwaresecuritymodules.models.DedicatedHsmResource;
import com.azure.resourcemanager.hardwaresecuritymodules.models.Sku;
import com.azure.resourcemanager.hardwaresecuritymodules.models.SkuName;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class DedicatedHsmResourceTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        DedicatedHsmResource model = BinaryData.fromString(
            "{\"sku\":{\"name\":\"payShield10K_LMK1_CPS2500\"},\"zones\":[\"rljdouskcqv\",\"ocrcjdk\",\"tnhxbn\"],\"location\":\"biksq\",\"tags\":{\"fmppe\":\"ssainqpjwnzll\",\"c\":\"bvmgxsabkyqduuji\"},\"id\":\"czdzev\",\"name\":\"dhkrwpdappdsbdk\",\"type\":\"wrwjfeu\"}")
            .toObject(DedicatedHsmResource.class);
        Assertions.assertEquals("biksq", model.location());
        Assertions.assertEquals("ssainqpjwnzll", model.tags().get("fmppe"));
        Assertions.assertEquals(SkuName.PAY_SHIELD10K_LMK1_CPS2500, model.sku().name());
        Assertions.assertEquals("rljdouskcqv", model.zones().get(0));
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        DedicatedHsmResource model = new DedicatedHsmResource().withLocation("biksq")
            .withTags(mapOf("fmppe", "ssainqpjwnzll", "c", "bvmgxsabkyqduuji"))
            .withSku(new Sku().withName(SkuName.PAY_SHIELD10K_LMK1_CPS2500))
            .withZones(Arrays.asList("rljdouskcqv", "ocrcjdk", "tnhxbn"));
        model = BinaryData.fromObject(model).toObject(DedicatedHsmResource.class);
        Assertions.assertEquals("biksq", model.location());
        Assertions.assertEquals("ssainqpjwnzll", model.tags().get("fmppe"));
        Assertions.assertEquals(SkuName.PAY_SHIELD10K_LMK1_CPS2500, model.sku().name());
        Assertions.assertEquals("rljdouskcqv", model.zones().get(0));
    }

    // Use "Map.of" if available
    @SuppressWarnings("unchecked")
    private static <T> Map<String, T> mapOf(Object... inputs) {
        Map<String, T> map = new HashMap<>();
        for (int i = 0; i < inputs.length; i += 2) {
            String key = (String) inputs[i];
            T value = (T) inputs[i + 1];
            map.put(key, value);
        }
        return map;
    }
}
