package com.sar.goldapp.configuration;

import jakarta.inject.Inject;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
public class WebSocketAuthChannelInterceptorAdapter implements ChannelInterceptor {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private final WebSocketAuthenticatorService webSocketAuthenticatorService;

    @Inject
    public WebSocketAuthChannelInterceptorAdapter(final WebSocketAuthenticatorService webSocketAuthenticatorService) {
        this.webSocketAuthenticatorService = webSocketAuthenticatorService;
    }

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        final StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
        if (StompCommand.CONNECT == accessor.getCommand()) {
            final String jwtToken = accessor.getFirstNativeHeader(AUTHORIZATION_HEADER);

            final UsernamePasswordAuthenticationToken user = webSocketAuthenticatorService.getAuthenticatedOrFail(jwtToken);
            accessor.setUser(user);
        }
        return message;
    }

}
