// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicessiterecovery.implementation;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.recoveryservicessiterecovery.fluent.ReplicationAppliancesClient;
import com.azure.resourcemanager.recoveryservicessiterecovery.fluent.models.ReplicationApplianceInner;
import com.azure.resourcemanager.recoveryservicessiterecovery.models.ReplicationAppliance;
import com.azure.resourcemanager.recoveryservicessiterecovery.models.ReplicationAppliances;

public final class ReplicationAppliancesImpl implements ReplicationAppliances {
    private static final ClientLogger LOGGER = new ClientLogger(ReplicationAppliancesImpl.class);

    private final ReplicationAppliancesClient innerClient;

    private final com.azure.resourcemanager.recoveryservicessiterecovery.SiteRecoveryManager serviceManager;

    public ReplicationAppliancesImpl(ReplicationAppliancesClient innerClient,
        com.azure.resourcemanager.recoveryservicessiterecovery.SiteRecoveryManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public PagedIterable<ReplicationAppliance> list(String resourceGroupName, String resourceName) {
        PagedIterable<ReplicationApplianceInner> inner = this.serviceClient().list(resourceGroupName, resourceName);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new ReplicationApplianceImpl(inner1, this.manager()));
    }

    public PagedIterable<ReplicationAppliance> list(String resourceGroupName, String resourceName, String filter,
        Context context) {
        PagedIterable<ReplicationApplianceInner> inner
            = this.serviceClient().list(resourceGroupName, resourceName, filter, context);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new ReplicationApplianceImpl(inner1, this.manager()));
    }

    private ReplicationAppliancesClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.resourcemanager.recoveryservicessiterecovery.SiteRecoveryManager manager() {
        return this.serviceManager;
    }
}
