// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.messaging.eventhubs.implementation;

import com.azure.core.amqp.AmqpRetryOptions;
import com.azure.core.amqp.AmqpTransportType;
import com.azure.core.amqp.ProxyOptions;
import com.azure.core.amqp.implementation.AmqpLinkProvider;
import com.azure.core.amqp.implementation.AmqpMetricsProvider;
import com.azure.core.amqp.implementation.ConnectionOptions;
import com.azure.core.amqp.implementation.MessageSerializer;
import com.azure.core.amqp.implementation.ReactorConnection;
import com.azure.core.amqp.implementation.ReactorDispatcher;
import com.azure.core.amqp.implementation.ReactorExecutor;
import com.azure.core.amqp.implementation.ReactorHandlerProvider;
import com.azure.core.amqp.implementation.ReactorProvider;
import com.azure.core.amqp.implementation.TokenManagerProvider;
import com.azure.core.amqp.implementation.handler.ConnectionHandler;
import com.azure.core.amqp.implementation.handler.ReceiveLinkHandler;
import com.azure.core.amqp.implementation.handler.SendLinkHandler;
import com.azure.core.amqp.implementation.handler.SessionHandler;
import com.azure.core.amqp.models.CbsAuthorizationType;
import com.azure.core.credential.TokenCredential;
import com.azure.core.util.ClientOptions;
import com.azure.core.util.Configuration;
import com.azure.core.util.CoreUtils;
import com.azure.core.util.Header;
import org.apache.qpid.proton.Proton;
import org.apache.qpid.proton.engine.Connection;
import org.apache.qpid.proton.engine.EndpointState;
import org.apache.qpid.proton.engine.Event;
import org.apache.qpid.proton.engine.Receiver;
import org.apache.qpid.proton.engine.Record;
import org.apache.qpid.proton.engine.Sender;
import org.apache.qpid.proton.engine.Session;
import org.apache.qpid.proton.engine.SslDomain;
import org.apache.qpid.proton.engine.SslPeerDetails;
import org.apache.qpid.proton.reactor.Reactor;
import org.apache.qpid.proton.reactor.Selectable;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.Answer;
import reactor.core.scheduler.Scheduler;
import reactor.test.StepVerifier;

import java.io.IOException;
import java.nio.channels.Pipe;
import java.time.Duration;
import java.util.Arrays;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EventHubReactorConnectionTest {
    private static final String NAME_KEY = "name";
    private static final String VERSION_KEY = "version";
    private static final String CONNECTION_ID = "test-connection-id";
    private static final String HOSTNAME = String.format("test-event-hub%s/",
        Configuration.getGlobalConfiguration().get("AZURE_EVENTHUBS_ENDPOINT_SUFFIX", ".servicebus.windows.net"));

    private static String product;
    private static String clientVersion;

    @Mock
    private Reactor reactor;
    @Mock
    private Selectable selectable;
    @Mock
    private TokenManagerProvider tokenManagerProvider;
    @Mock
    private TokenCredential tokenCredential;
    @Mock
    private Scheduler scheduler;
    @Mock
    private Connection reactorConnection;
    @Mock
    private MessageSerializer messageSerializer;
    @Mock
    private ReactorProvider reactorProvider;
    @Mock
    private ReactorHandlerProvider handlerProvider;
    @Mock
    private Session session;
    @Mock
    private Record record;

    private ConnectionOptions connectionOptions;
    private ConnectionHandler connectionHandler;
    private AmqpLinkProvider linkProvider = new AmqpLinkProvider();

    @BeforeAll
    public static void init() {
        Map<String, String> properties = CoreUtils.getProperties("azure-messaging-eventhubs.properties");
        product = properties.get(NAME_KEY);
        clientVersion = properties.get(VERSION_KEY);
    }

    @BeforeEach
    public void setup() throws IOException {
        MockitoAnnotations.initMocks(this);

        final ClientOptions clientOptions = new ClientOptions()
            .setHeaders(Arrays.asList(new Header(NAME_KEY, product), new Header(VERSION_KEY, clientVersion)));

        final ProxyOptions proxy = ProxyOptions.SYSTEM_DEFAULTS;
        this.connectionOptions
            = new ConnectionOptions(HOSTNAME, tokenCredential, CbsAuthorizationType.SHARED_ACCESS_SIGNATURE,
                ClientConstants.AZURE_ACTIVE_DIRECTORY_SCOPE, AmqpTransportType.AMQP, new AmqpRetryOptions(), proxy,
                scheduler, clientOptions, SslDomain.VerifyMode.VERIFY_PEER_NAME, "product-test", "client-test-version");
        final SslPeerDetails peerDetails = Proton.sslPeerDetails(HOSTNAME, ConnectionHandler.AMQPS_PORT);

        connectionHandler
            = new ConnectionHandler(CONNECTION_ID, connectionOptions, peerDetails, AmqpMetricsProvider.noop());

        when(reactor.selectable()).thenReturn(selectable);
        when(reactor.connectionToHost(connectionHandler.getHostname(), connectionHandler.getProtocolPort(),
            connectionHandler)).thenReturn(reactorConnection);
        when(reactor.process()).thenReturn(true);
        when(reactor.attachments()).thenReturn(record);

        final ReactorDispatcher reactorDispatcher = new ReactorDispatcher(CONNECTION_ID, reactor, Pipe.open());
        when(reactorProvider.getReactor()).thenReturn(reactor);
        when(reactorProvider.getReactorDispatcher()).thenReturn(reactorDispatcher);
        when(reactorProvider.createReactor(connectionHandler.getConnectionId(), connectionHandler.getMaxFrameSize()))
            .thenReturn(reactor);
        when(reactorProvider.createExecutor(any(Reactor.class), anyString(), anyString(),
            any(ReactorConnection.ReactorExceptionHandler.class), any(AmqpRetryOptions.class)))
                .then(answerByCreatingExecutor());

        final SessionHandler sessionHandler = new SessionHandler(CONNECTION_ID, HOSTNAME, "EVENT_HUB",
            reactorDispatcher, Duration.ofSeconds(20), AmqpMetricsProvider.noop());

        when(handlerProvider.createConnectionHandler(CONNECTION_ID, connectionOptions)).thenReturn(connectionHandler);
        when(handlerProvider.createSessionHandler(eq(CONNECTION_ID), eq(HOSTNAME), anyString(), any(Duration.class)))
            .thenReturn(sessionHandler);

        when(reactorConnection.session()).thenReturn(session);
        final Record record = mock(Record.class);
        when(session.attachments()).thenReturn(record);
    }

    @AfterEach
    public void reset() {
        Mockito.reset(reactor, selectable, tokenManagerProvider, reactorConnection, messageSerializer, reactorProvider,
            handlerProvider, tokenCredential, scheduler);

        Mockito.framework().clearInlineMock(this);
    }

    @Test
    public void getsManagementChannel() {
        // Arrange
        final Sender sender = mock(Sender.class);
        final Receiver receiver = mock(Receiver.class);
        final Record linkRecord = mock(Record.class);
        final Event event = mock(Event.class);
        final Connection connectionProtonJ = mock(Connection.class);
        when(event.getConnection()).thenReturn(connectionProtonJ);
        when(connectionProtonJ.getRemoteState()).thenReturn(EndpointState.ACTIVE);

        when(session.sender(any())).thenReturn(sender);
        when(session.receiver(any())).thenReturn(receiver);

        when(sender.attachments()).thenReturn(linkRecord);
        when(receiver.attachments()).thenReturn(linkRecord);

        when(handlerProvider.createReceiveLinkHandler(eq(CONNECTION_ID), eq(HOSTNAME), anyString(), anyString()))
            .thenReturn(new ReceiveLinkHandler(CONNECTION_ID, HOSTNAME, "receiver-name", "test-entity-path",
                AmqpMetricsProvider.noop()));

        when(handlerProvider.createSendLinkHandler(eq(CONNECTION_ID), eq(HOSTNAME), anyString(), anyString()))
            .thenReturn(new SendLinkHandler(CONNECTION_ID, HOSTNAME, "sender-name", "test-entity-path",
                AmqpMetricsProvider.noop()));

        final EventHubReactorAmqpConnection connection
            = new EventHubReactorAmqpConnection(CONNECTION_ID, connectionOptions, "event-hub-name", reactorProvider,
                handlerProvider, linkProvider, tokenManagerProvider, messageSerializer, false, false);

        // Act & Assert
        StepVerifier.create(connection.getManagementNode())
            .then(() -> connectionHandler.onConnectionRemoteOpen(event))
            .assertNext(node -> Assertions.assertTrue(node instanceof ManagementChannel))
            .expectComplete()
            .verify(Duration.ofSeconds(10));
    }

    @AfterEach
    public void teardown() {
        Mockito.framework().clearInlineMock(this);
    }

    private Answer<ReactorExecutor> answerByCreatingExecutor() {
        // Even before introducing 'ReactorProvider.createExecutorForReactor', the tests used to rely on a real
        // 'ReactorExecutor' object, not on a mock(ReactorExecutor), continue using a real 'ReactorExecutor'
        //  object for now with this helper method. The tests could be reworked using mock(ReactorExecutor) later.
        return invocation -> {
            final Reactor r = invocation.getArgument(0);
            final String conId = invocation.getArgument(1);
            final String fqdn = invocation.getArgument(2);
            final ReactorConnection.ReactorExceptionHandler exceptionHandler = invocation.getArgument(3);
            final AmqpRetryOptions retry = invocation.getArgument(4);
            return (new ReactorProvider()).createExecutor(r, conId, fqdn, exceptionHandler, retry);
        };
    }
}
