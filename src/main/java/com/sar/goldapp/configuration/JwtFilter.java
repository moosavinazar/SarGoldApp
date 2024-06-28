package com.sar.goldapp.configuration;

import com.sar.goldapp.model.authentication.User;
import com.sar.goldapp.service.authentication.JwtService;
import com.sar.goldapp.service.authentication.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;

public class JwtFilter extends OncePerRequestFilter {

    private HandlerExceptionResolver exceptionResolver;
    private final JwtService jwtService;
    private final UserService userService;

    @Autowired
    public JwtFilter(JwtService jwtService, UserService userService, HandlerExceptionResolver exceptionResolver) {
        this.jwtService = jwtService;
        this.userService = userService;
        this.exceptionResolver = exceptionResolver;
    }

    @Override
    protected void doFilterInternal(@NotNull HttpServletRequest httpServletRequest, @NotNull HttpServletResponse httpServletResponse,
                                    @NotNull FilterChain filterChain) throws ServletException, IOException {

        String jwt = httpServletRequest.getHeader("Authorization");
        //jwt = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTcxMjgwMzExNn0.ZUqUZ9z24IX9fgbuXTpitx0fQLbyFlSqlS4kgrlNp1z7pK2BGapid6nbZYddrqeulj0F5GIvk8JULigWWpZWhQ";

        try {
            if (jwt != null) {
                String username = jwtService.getUserName(jwt);
                if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    User user = (User) userService.loadUserByUsername(username);
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                            new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }
            }

            filterChain.doFilter(httpServletRequest, httpServletResponse);
        } catch (Exception ex) {
            exceptionResolver.resolveException(httpServletRequest, httpServletResponse, null, ex);
        }

    }

}
