// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.arizeaiobservabilityeval.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Partner's specific Properties.
 */
@Fluent
public final class PartnerProperties implements JsonSerializable<PartnerProperties> {
    /*
     * Description of the Organization's purpose
     */
    private String description;

    /**
     * Creates an instance of PartnerProperties class.
     */
    public PartnerProperties() {
    }

    /**
     * Get the description property: Description of the Organization's purpose.
     * 
     * @return the description value.
     */
    public String description() {
        return this.description;
    }

    /**
     * Set the description property: Description of the Organization's purpose.
     * 
     * @param description the description value to set.
     * @return the PartnerProperties object itself.
     */
    public PartnerProperties withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (description() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property description in model PartnerProperties"));
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(PartnerProperties.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("description", this.description);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of PartnerProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of PartnerProperties if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the PartnerProperties.
     */
    public static PartnerProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            PartnerProperties deserializedPartnerProperties = new PartnerProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("description".equals(fieldName)) {
                    deserializedPartnerProperties.description = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedPartnerProperties;
        });
    }
}
