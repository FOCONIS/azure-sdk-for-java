// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.mediaservices.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * The resource state of the live event. See https://go.microsoft.com/fwlink/?linkid=2139012 for more information.
 */
public final class LiveEventResourceState extends ExpandableStringEnum<LiveEventResourceState> {
    /**
     * Static value Stopped for LiveEventResourceState.
     */
    public static final LiveEventResourceState STOPPED = fromString("Stopped");

    /**
     * Static value Allocating for LiveEventResourceState.
     */
    public static final LiveEventResourceState ALLOCATING = fromString("Allocating");

    /**
     * Static value StandBy for LiveEventResourceState.
     */
    public static final LiveEventResourceState STAND_BY = fromString("StandBy");

    /**
     * Static value Starting for LiveEventResourceState.
     */
    public static final LiveEventResourceState STARTING = fromString("Starting");

    /**
     * Static value Running for LiveEventResourceState.
     */
    public static final LiveEventResourceState RUNNING = fromString("Running");

    /**
     * Static value Stopping for LiveEventResourceState.
     */
    public static final LiveEventResourceState STOPPING = fromString("Stopping");

    /**
     * Static value Deleting for LiveEventResourceState.
     */
    public static final LiveEventResourceState DELETING = fromString("Deleting");

    /**
     * Creates a new instance of LiveEventResourceState value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public LiveEventResourceState() {
    }

    /**
     * Creates or finds a LiveEventResourceState from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding LiveEventResourceState.
     */
    public static LiveEventResourceState fromString(String name) {
        return fromString(name, LiveEventResourceState.class);
    }

    /**
     * Gets known LiveEventResourceState values.
     * 
     * @return known LiveEventResourceState values.
     */
    public static Collection<LiveEventResourceState> values() {
        return values(LiveEventResourceState.class);
    }
}
