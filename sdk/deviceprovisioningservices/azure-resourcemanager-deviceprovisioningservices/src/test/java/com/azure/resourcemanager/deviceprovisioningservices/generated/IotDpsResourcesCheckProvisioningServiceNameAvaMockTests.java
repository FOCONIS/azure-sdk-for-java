// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.deviceprovisioningservices.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.deviceprovisioningservices.IotDpsManager;
import com.azure.resourcemanager.deviceprovisioningservices.models.NameAvailabilityInfo;
import com.azure.resourcemanager.deviceprovisioningservices.models.NameUnavailabilityReason;
import com.azure.resourcemanager.deviceprovisioningservices.models.OperationInputs;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class IotDpsResourcesCheckProvisioningServiceNameAvaMockTests {
    @Test
    public void testCheckProvisioningServiceNameAvailabilityWithResponse() throws Exception {
        String responseStr = "{\"nameAvailable\":false,\"reason\":\"AlreadyExists\",\"message\":\"jusrtslhspk\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        IotDpsManager manager = IotDpsManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        NameAvailabilityInfo response = manager.iotDpsResources()
            .checkProvisioningServiceNameAvailabilityWithResponse(new OperationInputs().withName("wbme"),
                com.azure.core.util.Context.NONE)
            .getValue();

        Assertions.assertEquals(false, response.nameAvailable());
        Assertions.assertEquals(NameUnavailabilityReason.ALREADY_EXISTS, response.reason());
        Assertions.assertEquals("jusrtslhspk", response.message());
    }
}
