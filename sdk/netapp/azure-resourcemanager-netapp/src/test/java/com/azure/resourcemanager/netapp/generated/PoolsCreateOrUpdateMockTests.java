// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.netapp.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.models.AzureCloud;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.netapp.NetAppFilesManager;
import com.azure.resourcemanager.netapp.models.CapacityPool;
import com.azure.resourcemanager.netapp.models.EncryptionType;
import com.azure.resourcemanager.netapp.models.QosType;
import com.azure.resourcemanager.netapp.models.ServiceLevel;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class PoolsCreateOrUpdateMockTests {
    @Test
    public void testCreateOrUpdate() throws Exception {
        String responseStr
            = "{\"etag\":\"ccknfnwmbtmvp\",\"properties\":{\"poolId\":\"jdhttzaefedxi\",\"size\":1887689540352270929,\"serviceLevel\":\"StandardZRS\",\"provisioningState\":\"Succeeded\",\"totalThroughputMibps\":62.23079,\"utilizedThroughputMibps\":21.047163,\"qosType\":\"Manual\",\"coolAccess\":true,\"encryptionType\":\"Double\"},\"location\":\"bg\",\"tags\":{\"utlwxezwzhok\":\"ylkdghrje\",\"ehgpp\":\"bwnhhtql\",\"csheafidltugsr\":\"pifhpfeoajvgcxtx\"},\"id\":\"smkss\",\"name\":\"h\",\"type\":\"iftxfkf\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        NetAppFilesManager manager = NetAppFilesManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureCloud.AZURE_PUBLIC_CLOUD));

        CapacityPool response = manager.pools()
            .define("dmdqb")
            .withRegion("dhzmmesckdlp")
            .withExistingNetAppAccount("itvtzeexavo", "tfgle")
            .withSize(7692078568165207428L)
            .withServiceLevel(ServiceLevel.ULTRA)
            .withTags(
                mapOf("xdfgsftufqobr", "rcxfailcfxwmdb", "knh", "lnacgcc", "zvulj", "kizvytn", "qnvb", "aaeranokqgukk"))
            .withQosType(QosType.AUTO)
            .withCoolAccess(true)
            .withEncryptionType(EncryptionType.DOUBLE)
            .create();

        Assertions.assertEquals("bg", response.location());
        Assertions.assertEquals("ylkdghrje", response.tags().get("utlwxezwzhok"));
        Assertions.assertEquals(1887689540352270929L, response.size());
        Assertions.assertEquals(ServiceLevel.STANDARD_ZRS, response.serviceLevel());
        Assertions.assertEquals(QosType.MANUAL, response.qosType());
        Assertions.assertEquals(true, response.coolAccess());
        Assertions.assertEquals(EncryptionType.DOUBLE, response.encryptionType());
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
