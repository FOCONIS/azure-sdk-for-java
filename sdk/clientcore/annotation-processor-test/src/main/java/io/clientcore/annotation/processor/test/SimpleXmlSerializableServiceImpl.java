// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package io.clientcore.annotation.processor.test;

import io.clientcore.annotation.processor.test.implementation.models.SimpleXmlSerializable;
import io.clientcore.core.http.models.HttpHeaderName;
import io.clientcore.core.http.models.HttpMethod;
import io.clientcore.core.http.models.HttpRequest;
import io.clientcore.core.http.models.Response;
import io.clientcore.core.http.pipeline.HttpPipeline;
import io.clientcore.core.models.binarydata.BinaryData;
import io.clientcore.annotation.processor.test.implementation.SimpleXmlSerializableService;
import io.clientcore.core.instrumentation.logging.ClientLogger;
import io.clientcore.core.serialization.json.JsonSerializer;
import io.clientcore.core.serialization.xml.XmlSerializer;
import io.clientcore.core.utils.CoreUtils;
import java.lang.reflect.ParameterizedType;
import io.clientcore.core.serialization.SerializationFormat;

/**
 * Initializes a new instance of the SimpleXmlSerializableServiceImpl type.
 */
public class SimpleXmlSerializableServiceImpl implements SimpleXmlSerializableService {

    private static final ClientLogger LOGGER = new ClientLogger(SimpleXmlSerializableService.class);

    private final HttpPipeline httpPipeline;

    private final JsonSerializer jsonSerializer;

    private final XmlSerializer xmlSerializer;

    private SimpleXmlSerializableServiceImpl(HttpPipeline httpPipeline) {
        this.httpPipeline = httpPipeline;
        this.jsonSerializer = JsonSerializer.getInstance();
        this.xmlSerializer = XmlSerializer.getInstance();
    }

    /**
     * Creates an instance of SimpleXmlSerializableService that is capable of sending requests to the service.
     * @param httpPipeline The HTTP pipeline to use for sending requests.
     * @return An instance of `SimpleXmlSerializableService`;
     */
    public static SimpleXmlSerializableService getNewInstance(HttpPipeline httpPipeline) {
        return new SimpleXmlSerializableServiceImpl(httpPipeline);
    }

    @SuppressWarnings({ "unchecked", "cast" })
    @Override
    public void sendApplicationXml(SimpleXmlSerializable simpleXmlSerializable) {
        String url = "http://localhost/sendApplicationXml";
        // Create the HTTP request
        HttpRequest httpRequest = new HttpRequest().setMethod(HttpMethod.PUT).setUri(url);
        httpRequest.getHeaders().set(HttpHeaderName.CONTENT_TYPE, "application/xml");
        if (simpleXmlSerializable != null) {
            SerializationFormat serializationFormat = CoreUtils.serializationFormatFromContentType(httpRequest.getHeaders());
            if (xmlSerializer.supportsFormat(serializationFormat)) {
                httpRequest.setBody(BinaryData.fromObject(simpleXmlSerializable, xmlSerializer));
            } else {
                httpRequest.setBody(BinaryData.fromObject(simpleXmlSerializable, jsonSerializer));
            }
        }
        // Send the request through the httpPipeline
        Response<BinaryData> networkResponse = this.httpPipeline.send(httpRequest);
        int responseCode = networkResponse.getStatusCode();
        boolean expectedResponse = responseCode == 200;
        if (!expectedResponse) {
            throw new RuntimeException("Unexpected response code: " + responseCode);
        }
        networkResponse.close();
    }

    @SuppressWarnings({ "unchecked", "cast" })
    @Override
    public void sendTextXml(SimpleXmlSerializable simpleXmlSerializable) {
        String url = "http://localhost/sendTextXml";
        // Create the HTTP request
        HttpRequest httpRequest = new HttpRequest().setMethod(HttpMethod.PUT).setUri(url);
        httpRequest.getHeaders().set(HttpHeaderName.CONTENT_TYPE, "text/xml");
        if (simpleXmlSerializable != null) {
            SerializationFormat serializationFormat = CoreUtils.serializationFormatFromContentType(httpRequest.getHeaders());
            if (xmlSerializer.supportsFormat(serializationFormat)) {
                httpRequest.setBody(BinaryData.fromObject(simpleXmlSerializable, xmlSerializer));
            } else {
                httpRequest.setBody(BinaryData.fromObject(simpleXmlSerializable, jsonSerializer));
            }
        }
        // Send the request through the httpPipeline
        Response<BinaryData> networkResponse = this.httpPipeline.send(httpRequest);
        int responseCode = networkResponse.getStatusCode();
        boolean expectedResponse = responseCode == 200;
        if (!expectedResponse) {
            throw new RuntimeException("Unexpected response code: " + responseCode);
        }
        networkResponse.close();
    }

    @SuppressWarnings({ "unchecked", "cast" })
    @Override
    public SimpleXmlSerializable getXml(String contentType) {
        String url = "http://localhost/getXml";
        // Create the HTTP request
        HttpRequest httpRequest = new HttpRequest().setMethod(HttpMethod.GET).setUri(url);
        httpRequest.getHeaders().add(HttpHeaderName.CONTENT_TYPE, contentType);
        // Send the request through the httpPipeline
        Response<BinaryData> networkResponse = this.httpPipeline.send(httpRequest);
        int responseCode = networkResponse.getStatusCode();
        boolean expectedResponse = responseCode == 200;
        if (!expectedResponse) {
            throw new RuntimeException("Unexpected response code: " + responseCode);
        }
        Object result = null;
        ParameterizedType returnType = CoreUtils.createParameterizedType(io.clientcore.annotation.processor.test.implementation.models.SimpleXmlSerializable.class);
        SerializationFormat serializationFormat = CoreUtils.serializationFormatFromContentType(httpRequest.getHeaders());
        if (jsonSerializer.supportsFormat(serializationFormat)) {
            result = CoreUtils.decodeNetworkResponse(networkResponse.getValue(), jsonSerializer, returnType);
        } else if (xmlSerializer.supportsFormat(serializationFormat)) {
            result = CoreUtils.decodeNetworkResponse(networkResponse.getValue(), xmlSerializer, returnType);
        } else {
            throw new RuntimeException(new UnsupportedOperationException("None of the provided serializers support the format: " + serializationFormat + "."));
        }
        networkResponse.close();
        return (io.clientcore.annotation.processor.test.implementation.models.SimpleXmlSerializable) result;
    }

    @SuppressWarnings({ "unchecked", "cast" })
    @Override
    public SimpleXmlSerializable getInvalidXml(String contentType) {
        String url = "http://localhost/getInvalidXml";
        // Create the HTTP request
        HttpRequest httpRequest = new HttpRequest().setMethod(HttpMethod.GET).setUri(url);
        httpRequest.getHeaders().add(HttpHeaderName.CONTENT_TYPE, contentType);
        // Send the request through the httpPipeline
        Response<BinaryData> networkResponse = this.httpPipeline.send(httpRequest);
        int responseCode = networkResponse.getStatusCode();
        boolean expectedResponse = responseCode == 200;
        if (!expectedResponse) {
            throw new RuntimeException("Unexpected response code: " + responseCode);
        }
        Object result = null;
        ParameterizedType returnType = CoreUtils.createParameterizedType(io.clientcore.annotation.processor.test.implementation.models.SimpleXmlSerializable.class);
        SerializationFormat serializationFormat = CoreUtils.serializationFormatFromContentType(httpRequest.getHeaders());
        if (jsonSerializer.supportsFormat(serializationFormat)) {
            result = CoreUtils.decodeNetworkResponse(networkResponse.getValue(), jsonSerializer, returnType);
        } else if (xmlSerializer.supportsFormat(serializationFormat)) {
            result = CoreUtils.decodeNetworkResponse(networkResponse.getValue(), xmlSerializer, returnType);
        } else {
            throw new RuntimeException(new UnsupportedOperationException("None of the provided serializers support the format: " + serializationFormat + "."));
        }
        networkResponse.close();
        return (io.clientcore.annotation.processor.test.implementation.models.SimpleXmlSerializable) result;
    }
}
