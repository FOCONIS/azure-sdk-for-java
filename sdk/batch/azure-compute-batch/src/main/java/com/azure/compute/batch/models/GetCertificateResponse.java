// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.
package com.azure.compute.batch.models;

import com.azure.core.annotation.Generated;
import com.azure.core.annotation.Immutable;
import com.azure.core.util.CoreUtils;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.time.OffsetDateTime;

/**
 * The GetCertificateResponse model.
 */
@Immutable
public final class GetCertificateResponse implements JsonSerializable<GetCertificateResponse> {

    /*
     * The X.509 thumbprint of the Certificate. This is a sequence of up to 40 hex digits (it may include spaces but
     * these are removed).
     */
    @Generated
    private final String thumbprint;

    /*
     * The algorithm used to derive the thumbprint. This must be sha1.
     */
    @Generated
    private final String thumbprintAlgorithm;

    /*
     * The URL of the Certificate.
     */
    @Generated
    private String url;

    /*
     * The state of the Certificate.
     */
    @Generated
    private BatchCertificateState state;

    /*
     * The time at which the Certificate entered its current state.
     */
    @Generated
    private OffsetDateTime stateTransitionTime;

    /*
     * The previous state of the Certificate. This property is not set if the Certificate is in its initial active
     * state.
     */
    @Generated
    private BatchCertificateState previousState;

    /*
     * The time at which the Certificate entered its previous state. This property is not set if the Certificate is in
     * its initial Active state.
     */
    @Generated
    private OffsetDateTime previousStateTransitionTime;

    /*
     * The public part of the Certificate as a base-64 encoded .cer file.
     */
    @Generated
    private String publicData;

    /*
     * The error that occurred on the last attempt to delete this Certificate. This property is set only if the
     * Certificate is in the DeleteFailed state.
     */
    @Generated
    private DeleteBatchCertificateError deleteCertificateError;

    /**
     * Creates an instance of GetCertificateResponse class.
     *
     * @param thumbprint the thumbprint value to set.
     * @param thumbprintAlgorithm the thumbprintAlgorithm value to set.
     */
    @Generated
    private GetCertificateResponse(String thumbprint, String thumbprintAlgorithm) {
        this.thumbprint = thumbprint;
        this.thumbprintAlgorithm = thumbprintAlgorithm;
    }

    /**
     * Get the thumbprint property: The X.509 thumbprint of the Certificate. This is a sequence of up to 40 hex digits
     * (it may include spaces but these are removed).
     *
     * @return the thumbprint value.
     */
    @Generated
    public String getThumbprint() {
        return this.thumbprint;
    }

    /**
     * Get the thumbprintAlgorithm property: The algorithm used to derive the thumbprint. This must be sha1.
     *
     * @return the thumbprintAlgorithm value.
     */
    @Generated
    public String getThumbprintAlgorithm() {
        return this.thumbprintAlgorithm;
    }

    /**
     * Get the url property: The URL of the Certificate.
     *
     * @return the url value.
     */
    @Generated
    public String getUrl() {
        return this.url;
    }

    /**
     * Get the state property: The state of the Certificate.
     *
     * @return the state value.
     */
    @Generated
    public BatchCertificateState getState() {
        return this.state;
    }

    /**
     * Get the stateTransitionTime property: The time at which the Certificate entered its current state.
     *
     * @return the stateTransitionTime value.
     */
    @Generated
    public OffsetDateTime getStateTransitionTime() {
        return this.stateTransitionTime;
    }

    /**
     * Get the previousState property: The previous state of the Certificate. This property is not set if the
     * Certificate is in its initial active state.
     *
     * @return the previousState value.
     */
    @Generated
    public BatchCertificateState getPreviousState() {
        return this.previousState;
    }

    /**
     * Get the previousStateTransitionTime property: The time at which the Certificate entered its previous state. This
     * property is not set if the Certificate is in its initial Active state.
     *
     * @return the previousStateTransitionTime value.
     */
    @Generated
    public OffsetDateTime getPreviousStateTransitionTime() {
        return this.previousStateTransitionTime;
    }

    /**
     * Get the publicData property: The public part of the Certificate as a base-64 encoded .cer file.
     *
     * @return the publicData value.
     */
    @Generated
    public String getPublicData() {
        return this.publicData;
    }

    /**
     * Get the deleteCertificateError property: The error that occurred on the last attempt to delete this Certificate.
     * This property is set only if the Certificate is in the DeleteFailed state.
     *
     * @return the deleteCertificateError value.
     */
    @Generated
    public DeleteBatchCertificateError getDeleteCertificateError() {
        return this.deleteCertificateError;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("thumbprint", this.thumbprint);
        jsonWriter.writeStringField("thumbprintAlgorithm", this.thumbprintAlgorithm);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of GetCertificateResponse from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of GetCertificateResponse if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the GetCertificateResponse.
     */
    @Generated
    public static GetCertificateResponse fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String thumbprint = null;
            String thumbprintAlgorithm = null;
            String url = null;
            BatchCertificateState state = null;
            OffsetDateTime stateTransitionTime = null;
            BatchCertificateState previousState = null;
            OffsetDateTime previousStateTransitionTime = null;
            String publicData = null;
            DeleteBatchCertificateError deleteCertificateError = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();
                if ("thumbprint".equals(fieldName)) {
                    thumbprint = reader.getString();
                } else if ("thumbprintAlgorithm".equals(fieldName)) {
                    thumbprintAlgorithm = reader.getString();
                } else if ("url".equals(fieldName)) {
                    url = reader.getString();
                } else if ("state".equals(fieldName)) {
                    state = BatchCertificateState.fromString(reader.getString());
                } else if ("stateTransitionTime".equals(fieldName)) {
                    stateTransitionTime = reader
                        .getNullable(nonNullReader -> CoreUtils.parseBestOffsetDateTime(nonNullReader.getString()));
                } else if ("previousState".equals(fieldName)) {
                    previousState = BatchCertificateState.fromString(reader.getString());
                } else if ("previousStateTransitionTime".equals(fieldName)) {
                    previousStateTransitionTime = reader
                        .getNullable(nonNullReader -> CoreUtils.parseBestOffsetDateTime(nonNullReader.getString()));
                } else if ("publicData".equals(fieldName)) {
                    publicData = reader.getString();
                } else if ("deleteCertificateError".equals(fieldName)) {
                    deleteCertificateError = DeleteBatchCertificateError.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }
            GetCertificateResponse deserializedGetCertificateResponse
                = new GetCertificateResponse(thumbprint, thumbprintAlgorithm);
            deserializedGetCertificateResponse.url = url;
            deserializedGetCertificateResponse.state = state;
            deserializedGetCertificateResponse.stateTransitionTime = stateTransitionTime;
            deserializedGetCertificateResponse.previousState = previousState;
            deserializedGetCertificateResponse.previousStateTransitionTime = previousStateTransitionTime;
            deserializedGetCertificateResponse.publicData = publicData;
            deserializedGetCertificateResponse.deleteCertificateError = deleteCertificateError;
            return deserializedGetCertificateResponse;
        });
    }
}
