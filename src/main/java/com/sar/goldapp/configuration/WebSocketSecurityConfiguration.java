package com.sar.goldapp.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.security.config.annotation.web.messaging.MessageSecurityMetadataSourceRegistry;
import org.springframework.security.config.annotation.web.socket.AbstractSecurityWebSocketMessageBrokerConfigurer;

@Configuration
public class WebSocketSecurityConfiguration extends AbstractSecurityWebSocketMessageBrokerConfigurer {

    @Override
    protected void configureInbound(MessageSecurityMetadataSourceRegistry messages) {
        /*messages.nullDestMatcher().permitAll()
                .simpDestMatchers("/app/**").authenticated()
                .simpDestMatchers("/app/send-order-request").hasAnyAuthority("OP_SET_ORDER")
                .simpSubscribeDestMatchers("/gold/price/**").hasAnyAuthority("OP_SUBSCRIBE_PRICE")
                .simpSubscribeDestMatchers("/gold/order").hasAnyAuthority("OP_SUBSCRIBE_ALL_ORDER")
                .simpSubscribeDestMatchers("/gold/my-order/**").hasAnyAuthority("OP_SUBSCRIBE_ORDER")
                .anyMessage().authenticated();*/
        messages.simpTypeMatchers(SimpMessageType.SUBSCRIBE).authenticated()
                .simpDestMatchers("/gold/send-order-confirm", "/gold/send-order-unconfirm", "/gold/set-price",
                        "/gold/active-sell", "/gold/deactive-sell", "/gold/active-sell/**", "/gold/deactive-sell/**",
                        "/gold/active-buy", "/gold/deactive-buy", "/gold/active-buy/**", "/gold/deactive-buy/**")
                .hasAnyAuthority("OP_ACC")

                .simpDestMatchers("/gold/send-order-request")
                .hasAnyAuthority("OP_USER")

                .simpSubscribeDestMatchers("/gold/order", "/gold/temp-request")
                .hasAnyAuthority("OP_ACC")

                .simpSubscribeDestMatchers("/gold/price/**", "/gold/my-order/**", "/gold/my-temp-request/**")
                .hasAnyAuthority("OP_USER")

                .simpDestMatchers("/app/**").authenticated()
                .simpDestMatchers("/gold/**").authenticated()
                .simpTypeMatchers(SimpMessageType.CONNECT, SimpMessageType.UNSUBSCRIBE, SimpMessageType.DISCONNECT)
                .permitAll()
                .anyMessage().authenticated();


    }

    @Override
    protected boolean sameOriginDisabled() {
        return true;
    }
}
