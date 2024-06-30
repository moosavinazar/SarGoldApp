package com.sar.goldapp.web.rest;

import com.sar.goldapp.controller.authentication.UserController;
import com.sar.goldapp.model.authentication.JwtAuthentication;
import com.sar.goldapp.service.authentication.JwtService;
import com.sar.goldapp.service.authentication.RefreshTokenService;
import com.sar.goldapp.service.dto.authentication.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtRestResources {

    Logger logger = LoggerFactory.getLogger(JwtRestResources.class);
    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    private final UserController userController;

    private final RefreshTokenService refreshTokenService;

    public JwtRestResources(AuthenticationManager authenticationManager, JwtService jwtService, UserController userController, RefreshTokenService refreshTokenService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userController = userController;
        this.refreshTokenService = refreshTokenService;
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponseDTO> jwtLogin(@RequestBody JwtAuthentication jwtAuthentication) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtAuthentication.getUsername(), jwtAuthentication.getPassword()));

        UserDTO userDTO = userController.findByUsername(jwtAuthentication.getUsername());
        JwtResponseDTO jwtResponseDTO = new JwtResponseDTO(
                jwtService.generateTokenFromUsername(jwtAuthentication.getUsername()),
                refreshTokenService.createRefreshToken(userDTO.getId()).getToken(), userDTO);

        return ResponseEntity.ok(jwtResponseDTO);

    }

}
