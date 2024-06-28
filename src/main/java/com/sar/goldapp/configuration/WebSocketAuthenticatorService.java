package com.sar.goldapp.configuration;

import com.sar.goldapp.model.authentication.User;
import com.sar.goldapp.service.authentication.JwtService;
import com.sar.goldapp.service.authentication.UserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
public class WebSocketAuthenticatorService {

    private final UserService userService;
    private final JwtService jwtService;

    public WebSocketAuthenticatorService(UserService userService, JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }

    public UsernamePasswordAuthenticationToken getAuthenticatedOrFail(final String jwtToken) {

        String username = jwtService.getUserName(jwtToken);
        User user = (User) userService.loadUserByUsername(username);

        return new UsernamePasswordAuthenticationToken(username, null, user.getAuthorities());

    }

}
