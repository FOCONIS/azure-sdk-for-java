// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.managednetworkfabric.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.managednetworkfabric.models.AdministrativeState;
import com.azure.resourcemanager.managednetworkfabric.models.AnnotationResource;
import com.azure.resourcemanager.managednetworkfabric.models.ConfigurationState;
import com.azure.resourcemanager.managednetworkfabric.models.IpExtendedCommunityRule;
import com.azure.resourcemanager.managednetworkfabric.models.ProvisioningState;
import java.io.IOException;
import java.util.List;

/**
 * IP Extended Community Properties defines the resource properties.
 */
@Fluent
public final class IpExtendedCommunityProperties extends AnnotationResource {
    /*
     * Configuration state of the resource.
     */
    private ConfigurationState configurationState;

    /*
     * Provisioning state of the resource.
     */
    private ProvisioningState provisioningState;

    /*
     * Administrative state of the resource.
     */
    private AdministrativeState administrativeState;

    /*
     * List of IP Extended Community Rules.
     */
    private List<IpExtendedCommunityRule> ipExtendedCommunityRules;

    /**
     * Creates an instance of IpExtendedCommunityProperties class.
     */
    public IpExtendedCommunityProperties() {
    }

    /**
     * Get the configurationState property: Configuration state of the resource.
     * 
     * @return the configurationState value.
     */
    public ConfigurationState configurationState() {
        return this.configurationState;
    }

    /**
     * Get the provisioningState property: Provisioning state of the resource.
     * 
     * @return the provisioningState value.
     */
    public ProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Get the administrativeState property: Administrative state of the resource.
     * 
     * @return the administrativeState value.
     */
    public AdministrativeState administrativeState() {
        return this.administrativeState;
    }

    /**
     * Get the ipExtendedCommunityRules property: List of IP Extended Community Rules.
     * 
     * @return the ipExtendedCommunityRules value.
     */
    public List<IpExtendedCommunityRule> ipExtendedCommunityRules() {
        return this.ipExtendedCommunityRules;
    }

    /**
     * Set the ipExtendedCommunityRules property: List of IP Extended Community Rules.
     * 
     * @param ipExtendedCommunityRules the ipExtendedCommunityRules value to set.
     * @return the IpExtendedCommunityProperties object itself.
     */
    public IpExtendedCommunityProperties
        withIpExtendedCommunityRules(List<IpExtendedCommunityRule> ipExtendedCommunityRules) {
        this.ipExtendedCommunityRules = ipExtendedCommunityRules;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IpExtendedCommunityProperties withAnnotation(String annotation) {
        super.withAnnotation(annotation);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        if (ipExtendedCommunityRules() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property ipExtendedCommunityRules in model IpExtendedCommunityProperties"));
        } else {
            ipExtendedCommunityRules().forEach(e -> e.validate());
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(IpExtendedCommunityProperties.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("annotation", annotation());
        jsonWriter.writeArrayField("ipExtendedCommunityRules", this.ipExtendedCommunityRules,
            (writer, element) -> writer.writeJson(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of IpExtendedCommunityProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of IpExtendedCommunityProperties if the JsonReader was pointing to an instance of it, or null
     * if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the IpExtendedCommunityProperties.
     */
    public static IpExtendedCommunityProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            IpExtendedCommunityProperties deserializedIpExtendedCommunityProperties
                = new IpExtendedCommunityProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("annotation".equals(fieldName)) {
                    deserializedIpExtendedCommunityProperties.withAnnotation(reader.getString());
                } else if ("ipExtendedCommunityRules".equals(fieldName)) {
                    List<IpExtendedCommunityRule> ipExtendedCommunityRules
                        = reader.readArray(reader1 -> IpExtendedCommunityRule.fromJson(reader1));
                    deserializedIpExtendedCommunityProperties.ipExtendedCommunityRules = ipExtendedCommunityRules;
                } else if ("configurationState".equals(fieldName)) {
                    deserializedIpExtendedCommunityProperties.configurationState
                        = ConfigurationState.fromString(reader.getString());
                } else if ("provisioningState".equals(fieldName)) {
                    deserializedIpExtendedCommunityProperties.provisioningState
                        = ProvisioningState.fromString(reader.getString());
                } else if ("administrativeState".equals(fieldName)) {
                    deserializedIpExtendedCommunityProperties.administrativeState
                        = AdministrativeState.fromString(reader.getString());
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedIpExtendedCommunityProperties;
        });
    }
}
