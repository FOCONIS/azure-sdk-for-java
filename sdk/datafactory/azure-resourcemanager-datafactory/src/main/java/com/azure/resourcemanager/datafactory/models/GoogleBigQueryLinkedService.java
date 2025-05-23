// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.datafactory.fluent.models.GoogleBigQueryLinkedServiceTypeProperties;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Google BigQuery service linked service.
 */
@Fluent
public final class GoogleBigQueryLinkedService extends LinkedService {
    /*
     * Type of linked service.
     */
    private String type = "GoogleBigQuery";

    /*
     * Google BigQuery service linked service properties.
     */
    private GoogleBigQueryLinkedServiceTypeProperties innerTypeProperties
        = new GoogleBigQueryLinkedServiceTypeProperties();

    /**
     * Creates an instance of GoogleBigQueryLinkedService class.
     */
    public GoogleBigQueryLinkedService() {
    }

    /**
     * Get the type property: Type of linked service.
     * 
     * @return the type value.
     */
    @Override
    public String type() {
        return this.type;
    }

    /**
     * Get the innerTypeProperties property: Google BigQuery service linked service properties.
     * 
     * @return the innerTypeProperties value.
     */
    GoogleBigQueryLinkedServiceTypeProperties innerTypeProperties() {
        return this.innerTypeProperties;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GoogleBigQueryLinkedService withVersion(String version) {
        super.withVersion(version);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GoogleBigQueryLinkedService withConnectVia(IntegrationRuntimeReference connectVia) {
        super.withConnectVia(connectVia);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GoogleBigQueryLinkedService withDescription(String description) {
        super.withDescription(description);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GoogleBigQueryLinkedService withParameters(Map<String, ParameterSpecification> parameters) {
        super.withParameters(parameters);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GoogleBigQueryLinkedService withAnnotations(List<Object> annotations) {
        super.withAnnotations(annotations);
        return this;
    }

    /**
     * Get the project property: The default BigQuery project to query against. Type: string (or Expression with
     * resultType string).
     * 
     * @return the project value.
     */
    public Object project() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().project();
    }

    /**
     * Set the project property: The default BigQuery project to query against. Type: string (or Expression with
     * resultType string).
     * 
     * @param project the project value to set.
     * @return the GoogleBigQueryLinkedService object itself.
     */
    public GoogleBigQueryLinkedService withProject(Object project) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new GoogleBigQueryLinkedServiceTypeProperties();
        }
        this.innerTypeProperties().withProject(project);
        return this;
    }

    /**
     * Get the additionalProjects property: A comma-separated list of public BigQuery projects to access. Type: string
     * (or Expression with resultType string).
     * 
     * @return the additionalProjects value.
     */
    public Object additionalProjects() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().additionalProjects();
    }

    /**
     * Set the additionalProjects property: A comma-separated list of public BigQuery projects to access. Type: string
     * (or Expression with resultType string).
     * 
     * @param additionalProjects the additionalProjects value to set.
     * @return the GoogleBigQueryLinkedService object itself.
     */
    public GoogleBigQueryLinkedService withAdditionalProjects(Object additionalProjects) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new GoogleBigQueryLinkedServiceTypeProperties();
        }
        this.innerTypeProperties().withAdditionalProjects(additionalProjects);
        return this;
    }

    /**
     * Get the requestGoogleDriveScope property: Whether to request access to Google Drive. Allowing Google Drive access
     * enables support for federated tables that combine BigQuery data with data from Google Drive. The default value is
     * false. Type: string (or Expression with resultType string).
     * 
     * @return the requestGoogleDriveScope value.
     */
    public Object requestGoogleDriveScope() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().requestGoogleDriveScope();
    }

    /**
     * Set the requestGoogleDriveScope property: Whether to request access to Google Drive. Allowing Google Drive access
     * enables support for federated tables that combine BigQuery data with data from Google Drive. The default value is
     * false. Type: string (or Expression with resultType string).
     * 
     * @param requestGoogleDriveScope the requestGoogleDriveScope value to set.
     * @return the GoogleBigQueryLinkedService object itself.
     */
    public GoogleBigQueryLinkedService withRequestGoogleDriveScope(Object requestGoogleDriveScope) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new GoogleBigQueryLinkedServiceTypeProperties();
        }
        this.innerTypeProperties().withRequestGoogleDriveScope(requestGoogleDriveScope);
        return this;
    }

    /**
     * Get the authenticationType property: The OAuth 2.0 authentication mechanism used for authentication.
     * ServiceAuthentication can only be used on self-hosted IR.
     * 
     * @return the authenticationType value.
     */
    public GoogleBigQueryAuthenticationType authenticationType() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().authenticationType();
    }

    /**
     * Set the authenticationType property: The OAuth 2.0 authentication mechanism used for authentication.
     * ServiceAuthentication can only be used on self-hosted IR.
     * 
     * @param authenticationType the authenticationType value to set.
     * @return the GoogleBigQueryLinkedService object itself.
     */
    public GoogleBigQueryLinkedService withAuthenticationType(GoogleBigQueryAuthenticationType authenticationType) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new GoogleBigQueryLinkedServiceTypeProperties();
        }
        this.innerTypeProperties().withAuthenticationType(authenticationType);
        return this;
    }

    /**
     * Get the refreshToken property: The refresh token obtained from Google for authorizing access to BigQuery for
     * UserAuthentication.
     * 
     * @return the refreshToken value.
     */
    public SecretBase refreshToken() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().refreshToken();
    }

    /**
     * Set the refreshToken property: The refresh token obtained from Google for authorizing access to BigQuery for
     * UserAuthentication.
     * 
     * @param refreshToken the refreshToken value to set.
     * @return the GoogleBigQueryLinkedService object itself.
     */
    public GoogleBigQueryLinkedService withRefreshToken(SecretBase refreshToken) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new GoogleBigQueryLinkedServiceTypeProperties();
        }
        this.innerTypeProperties().withRefreshToken(refreshToken);
        return this;
    }

    /**
     * Get the clientId property: The client id of the google application used to acquire the refresh token. Type:
     * string (or Expression with resultType string).
     * 
     * @return the clientId value.
     */
    public Object clientId() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().clientId();
    }

    /**
     * Set the clientId property: The client id of the google application used to acquire the refresh token. Type:
     * string (or Expression with resultType string).
     * 
     * @param clientId the clientId value to set.
     * @return the GoogleBigQueryLinkedService object itself.
     */
    public GoogleBigQueryLinkedService withClientId(Object clientId) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new GoogleBigQueryLinkedServiceTypeProperties();
        }
        this.innerTypeProperties().withClientId(clientId);
        return this;
    }

    /**
     * Get the clientSecret property: The client secret of the google application used to acquire the refresh token.
     * 
     * @return the clientSecret value.
     */
    public SecretBase clientSecret() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().clientSecret();
    }

    /**
     * Set the clientSecret property: The client secret of the google application used to acquire the refresh token.
     * 
     * @param clientSecret the clientSecret value to set.
     * @return the GoogleBigQueryLinkedService object itself.
     */
    public GoogleBigQueryLinkedService withClientSecret(SecretBase clientSecret) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new GoogleBigQueryLinkedServiceTypeProperties();
        }
        this.innerTypeProperties().withClientSecret(clientSecret);
        return this;
    }

    /**
     * Get the email property: The service account email ID that is used for ServiceAuthentication and can only be used
     * on self-hosted IR. Type: string (or Expression with resultType string).
     * 
     * @return the email value.
     */
    public Object email() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().email();
    }

    /**
     * Set the email property: The service account email ID that is used for ServiceAuthentication and can only be used
     * on self-hosted IR. Type: string (or Expression with resultType string).
     * 
     * @param email the email value to set.
     * @return the GoogleBigQueryLinkedService object itself.
     */
    public GoogleBigQueryLinkedService withEmail(Object email) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new GoogleBigQueryLinkedServiceTypeProperties();
        }
        this.innerTypeProperties().withEmail(email);
        return this;
    }

    /**
     * Get the keyFilePath property: The full path to the .p12 key file that is used to authenticate the service account
     * email address and can only be used on self-hosted IR. Type: string (or Expression with resultType string).
     * 
     * @return the keyFilePath value.
     */
    public Object keyFilePath() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().keyFilePath();
    }

    /**
     * Set the keyFilePath property: The full path to the .p12 key file that is used to authenticate the service account
     * email address and can only be used on self-hosted IR. Type: string (or Expression with resultType string).
     * 
     * @param keyFilePath the keyFilePath value to set.
     * @return the GoogleBigQueryLinkedService object itself.
     */
    public GoogleBigQueryLinkedService withKeyFilePath(Object keyFilePath) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new GoogleBigQueryLinkedServiceTypeProperties();
        }
        this.innerTypeProperties().withKeyFilePath(keyFilePath);
        return this;
    }

    /**
     * Get the trustedCertPath property: The full path of the .pem file containing trusted CA certificates for verifying
     * the server when connecting over SSL. This property can only be set when using SSL on self-hosted IR. The default
     * value is the cacerts.pem file installed with the IR. Type: string (or Expression with resultType string).
     * 
     * @return the trustedCertPath value.
     */
    public Object trustedCertPath() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().trustedCertPath();
    }

    /**
     * Set the trustedCertPath property: The full path of the .pem file containing trusted CA certificates for verifying
     * the server when connecting over SSL. This property can only be set when using SSL on self-hosted IR. The default
     * value is the cacerts.pem file installed with the IR. Type: string (or Expression with resultType string).
     * 
     * @param trustedCertPath the trustedCertPath value to set.
     * @return the GoogleBigQueryLinkedService object itself.
     */
    public GoogleBigQueryLinkedService withTrustedCertPath(Object trustedCertPath) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new GoogleBigQueryLinkedServiceTypeProperties();
        }
        this.innerTypeProperties().withTrustedCertPath(trustedCertPath);
        return this;
    }

    /**
     * Get the useSystemTrustStore property: Specifies whether to use a CA certificate from the system trust store or
     * from a specified PEM file. The default value is false.Type: boolean (or Expression with resultType boolean).
     * 
     * @return the useSystemTrustStore value.
     */
    public Object useSystemTrustStore() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().useSystemTrustStore();
    }

    /**
     * Set the useSystemTrustStore property: Specifies whether to use a CA certificate from the system trust store or
     * from a specified PEM file. The default value is false.Type: boolean (or Expression with resultType boolean).
     * 
     * @param useSystemTrustStore the useSystemTrustStore value to set.
     * @return the GoogleBigQueryLinkedService object itself.
     */
    public GoogleBigQueryLinkedService withUseSystemTrustStore(Object useSystemTrustStore) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new GoogleBigQueryLinkedServiceTypeProperties();
        }
        this.innerTypeProperties().withUseSystemTrustStore(useSystemTrustStore);
        return this;
    }

    /**
     * Get the encryptedCredential property: The encrypted credential used for authentication. Credentials are encrypted
     * using the integration runtime credential manager. Type: string.
     * 
     * @return the encryptedCredential value.
     */
    public String encryptedCredential() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().encryptedCredential();
    }

    /**
     * Set the encryptedCredential property: The encrypted credential used for authentication. Credentials are encrypted
     * using the integration runtime credential manager. Type: string.
     * 
     * @param encryptedCredential the encryptedCredential value to set.
     * @return the GoogleBigQueryLinkedService object itself.
     */
    public GoogleBigQueryLinkedService withEncryptedCredential(String encryptedCredential) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new GoogleBigQueryLinkedServiceTypeProperties();
        }
        this.innerTypeProperties().withEncryptedCredential(encryptedCredential);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        if (innerTypeProperties() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property innerTypeProperties in model GoogleBigQueryLinkedService"));
        } else {
            innerTypeProperties().validate();
        }
        if (connectVia() != null) {
            connectVia().validate();
        }
        if (parameters() != null) {
            parameters().values().forEach(e -> {
                if (e != null) {
                    e.validate();
                }
            });
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(GoogleBigQueryLinkedService.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("version", version());
        jsonWriter.writeJsonField("connectVia", connectVia());
        jsonWriter.writeStringField("description", description());
        jsonWriter.writeMapField("parameters", parameters(), (writer, element) -> writer.writeJson(element));
        jsonWriter.writeArrayField("annotations", annotations(), (writer, element) -> writer.writeUntyped(element));
        jsonWriter.writeJsonField("typeProperties", this.innerTypeProperties);
        jsonWriter.writeStringField("type", this.type);
        if (additionalProperties() != null) {
            for (Map.Entry<String, Object> additionalProperty : additionalProperties().entrySet()) {
                jsonWriter.writeUntypedField(additionalProperty.getKey(), additionalProperty.getValue());
            }
        }
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of GoogleBigQueryLinkedService from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of GoogleBigQueryLinkedService if the JsonReader was pointing to an instance of it, or null
     * if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the GoogleBigQueryLinkedService.
     */
    public static GoogleBigQueryLinkedService fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            GoogleBigQueryLinkedService deserializedGoogleBigQueryLinkedService = new GoogleBigQueryLinkedService();
            Map<String, Object> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("version".equals(fieldName)) {
                    deserializedGoogleBigQueryLinkedService.withVersion(reader.getString());
                } else if ("connectVia".equals(fieldName)) {
                    deserializedGoogleBigQueryLinkedService
                        .withConnectVia(IntegrationRuntimeReference.fromJson(reader));
                } else if ("description".equals(fieldName)) {
                    deserializedGoogleBigQueryLinkedService.withDescription(reader.getString());
                } else if ("parameters".equals(fieldName)) {
                    Map<String, ParameterSpecification> parameters
                        = reader.readMap(reader1 -> ParameterSpecification.fromJson(reader1));
                    deserializedGoogleBigQueryLinkedService.withParameters(parameters);
                } else if ("annotations".equals(fieldName)) {
                    List<Object> annotations = reader.readArray(reader1 -> reader1.readUntyped());
                    deserializedGoogleBigQueryLinkedService.withAnnotations(annotations);
                } else if ("typeProperties".equals(fieldName)) {
                    deserializedGoogleBigQueryLinkedService.innerTypeProperties
                        = GoogleBigQueryLinkedServiceTypeProperties.fromJson(reader);
                } else if ("type".equals(fieldName)) {
                    deserializedGoogleBigQueryLinkedService.type = reader.getString();
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName, reader.readUntyped());
                }
            }
            deserializedGoogleBigQueryLinkedService.withAdditionalProperties(additionalProperties);

            return deserializedGoogleBigQueryLinkedService;
        });
    }
}
