// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicesbackup.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * The BackupResourceEncryptionConfigExtended model.
 */
@Fluent
public final class BackupResourceEncryptionConfigExtended extends BackupResourceEncryptionConfig {
    /*
     * User Assigned Identity Id
     */
    private String userAssignedIdentity;

    /*
     * bool to indicate whether to use system Assigned Identity or not
     */
    private Boolean useSystemAssignedIdentity;

    /**
     * Creates an instance of BackupResourceEncryptionConfigExtended class.
     */
    public BackupResourceEncryptionConfigExtended() {
    }

    /**
     * Get the userAssignedIdentity property: User Assigned Identity Id.
     * 
     * @return the userAssignedIdentity value.
     */
    public String userAssignedIdentity() {
        return this.userAssignedIdentity;
    }

    /**
     * Set the userAssignedIdentity property: User Assigned Identity Id.
     * 
     * @param userAssignedIdentity the userAssignedIdentity value to set.
     * @return the BackupResourceEncryptionConfigExtended object itself.
     */
    public BackupResourceEncryptionConfigExtended withUserAssignedIdentity(String userAssignedIdentity) {
        this.userAssignedIdentity = userAssignedIdentity;
        return this;
    }

    /**
     * Get the useSystemAssignedIdentity property: bool to indicate whether to use system Assigned Identity or not.
     * 
     * @return the useSystemAssignedIdentity value.
     */
    public Boolean useSystemAssignedIdentity() {
        return this.useSystemAssignedIdentity;
    }

    /**
     * Set the useSystemAssignedIdentity property: bool to indicate whether to use system Assigned Identity or not.
     * 
     * @param useSystemAssignedIdentity the useSystemAssignedIdentity value to set.
     * @return the BackupResourceEncryptionConfigExtended object itself.
     */
    public BackupResourceEncryptionConfigExtended withUseSystemAssignedIdentity(Boolean useSystemAssignedIdentity) {
        this.useSystemAssignedIdentity = useSystemAssignedIdentity;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BackupResourceEncryptionConfigExtended withEncryptionAtRestType(EncryptionAtRestType encryptionAtRestType) {
        super.withEncryptionAtRestType(encryptionAtRestType);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BackupResourceEncryptionConfigExtended withKeyUri(String keyUri) {
        super.withKeyUri(keyUri);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BackupResourceEncryptionConfigExtended withSubscriptionId(String subscriptionId) {
        super.withSubscriptionId(subscriptionId);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BackupResourceEncryptionConfigExtended withLastUpdateStatus(LastUpdateStatus lastUpdateStatus) {
        super.withLastUpdateStatus(lastUpdateStatus);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BackupResourceEncryptionConfigExtended
        withInfrastructureEncryptionState(InfrastructureEncryptionState infrastructureEncryptionState) {
        super.withInfrastructureEncryptionState(infrastructureEncryptionState);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("encryptionAtRestType",
            encryptionAtRestType() == null ? null : encryptionAtRestType().toString());
        jsonWriter.writeStringField("keyUri", keyUri());
        jsonWriter.writeStringField("subscriptionId", subscriptionId());
        jsonWriter.writeStringField("lastUpdateStatus",
            lastUpdateStatus() == null ? null : lastUpdateStatus().toString());
        jsonWriter.writeStringField("infrastructureEncryptionState",
            infrastructureEncryptionState() == null ? null : infrastructureEncryptionState().toString());
        jsonWriter.writeStringField("userAssignedIdentity", this.userAssignedIdentity);
        jsonWriter.writeBooleanField("useSystemAssignedIdentity", this.useSystemAssignedIdentity);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of BackupResourceEncryptionConfigExtended from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of BackupResourceEncryptionConfigExtended if the JsonReader was pointing to an instance of
     * it, or null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the BackupResourceEncryptionConfigExtended.
     */
    public static BackupResourceEncryptionConfigExtended fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            BackupResourceEncryptionConfigExtended deserializedBackupResourceEncryptionConfigExtended
                = new BackupResourceEncryptionConfigExtended();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("encryptionAtRestType".equals(fieldName)) {
                    deserializedBackupResourceEncryptionConfigExtended
                        .withEncryptionAtRestType(EncryptionAtRestType.fromString(reader.getString()));
                } else if ("keyUri".equals(fieldName)) {
                    deserializedBackupResourceEncryptionConfigExtended.withKeyUri(reader.getString());
                } else if ("subscriptionId".equals(fieldName)) {
                    deserializedBackupResourceEncryptionConfigExtended.withSubscriptionId(reader.getString());
                } else if ("lastUpdateStatus".equals(fieldName)) {
                    deserializedBackupResourceEncryptionConfigExtended
                        .withLastUpdateStatus(LastUpdateStatus.fromString(reader.getString()));
                } else if ("infrastructureEncryptionState".equals(fieldName)) {
                    deserializedBackupResourceEncryptionConfigExtended.withInfrastructureEncryptionState(
                        InfrastructureEncryptionState.fromString(reader.getString()));
                } else if ("userAssignedIdentity".equals(fieldName)) {
                    deserializedBackupResourceEncryptionConfigExtended.userAssignedIdentity = reader.getString();
                } else if ("useSystemAssignedIdentity".equals(fieldName)) {
                    deserializedBackupResourceEncryptionConfigExtended.useSystemAssignedIdentity
                        = reader.getNullable(JsonReader::getBoolean);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedBackupResourceEncryptionConfigExtended;
        });
    }
}
