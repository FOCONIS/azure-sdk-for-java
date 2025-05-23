// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.advisor.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Defines values for Category.
 */
public final class Category extends ExpandableStringEnum<Category> {
    /**
     * Static value HighAvailability for Category.
     */
    public static final Category HIGH_AVAILABILITY = fromString("HighAvailability");

    /**
     * Static value Security for Category.
     */
    public static final Category SECURITY = fromString("Security");

    /**
     * Static value Performance for Category.
     */
    public static final Category PERFORMANCE = fromString("Performance");

    /**
     * Static value Cost for Category.
     */
    public static final Category COST = fromString("Cost");

    /**
     * Static value OperationalExcellence for Category.
     */
    public static final Category OPERATIONAL_EXCELLENCE = fromString("OperationalExcellence");

    /**
     * Creates a new instance of Category value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public Category() {
    }

    /**
     * Creates or finds a Category from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding Category.
     */
    public static Category fromString(String name) {
        return fromString(name, Category.class);
    }

    /**
     * Gets known Category values.
     * 
     * @return known Category values.
     */
    public static Collection<Category> values() {
        return values(Category.class);
    }
}
