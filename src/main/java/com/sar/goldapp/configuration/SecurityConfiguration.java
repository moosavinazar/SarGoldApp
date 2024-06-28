package com.sar.goldapp.configuration;

import com.sar.goldapp.service.authentication.JwtService;
import com.sar.goldapp.service.authentication.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration {

    @Autowired
    @Qualifier("handlerExceptionResolver")
    private HandlerExceptionResolver exceptionResolver;

    private final UserService userService;

    private final JwtService jwtService;

    public SecurityConfiguration(JwtService jwtService, UserService userService) {
        this.jwtService = jwtService;
        this.userService = userService;
    }

    @Bean
    public JwtFilter jwtFilter() {
        return new JwtFilter(jwtService, userService, exceptionResolver);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(
                        (auth) -> auth
                                .requestMatchers("/", "/login", "/refresh-token", "/websocket/**", "/app/**", "/gold/**",
                                        "/camera/**", "/*.js", "/*.css", "/assets/**", "/api/**", "/v2/api-docs",
                                        "/v2/api-docs/**", "/swagger-resources/**",
                                        "/swagger-ui", "/swagger-ui/**", "/swagger-ui.html")
                                .permitAll()
                                .requestMatchers("/create-group", "/permissions")
                                .hasAnyAuthority("OP_SUPER_ADMIN")
                                .requestMatchers("/groups", "/update-person", "/create-price-group", "/price-groups", "/users/**",
                                        "/create-user", "/users", "/update-user")
                                .hasAnyAuthority("OP_ADMIN")
                                .requestMatchers("/create-command-child", "/get-command-children/**", "/update-command-child","/price-groups",
                                        "/delete-command-child/**", "/create-pay-command", "/create-receive-command",
                                        "/commands", "/uncleared-commands", "/command/**", "/admin-balance", "/admin-trade",
                                        "/admin-demands", "/admin-demands-list", "/admin-demands-compact", "/admin-banks",
                                        "/admin-banks-list", "/admin-banks-compact", "/get-risk-list", "/get-risk/**",
                                        "/today", "/confirm-pay-info/**", "/send-confirm-pay-info", "/delete-pay-information/**",
                                        "/clear-command/**", "/transaction", "/transaction/**")
                                .hasAnyAuthority("OP_ACC")
                                .requestMatchers("/get-my-command-children", "/get-command-children-uncleared", "/my-balance",
                                        "/my-transaction", "/send-pay-info", "/get-last-price", "/get-last-price-list",
                                        "/current-user", "/current-user-price", "/persons")
                                .hasAnyAuthority("OP_USER")
                                .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    /*@Bean
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
    }*/

    // TODO above or below method

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserDetailsService userDetailsService() {
        return userService;
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration auth) throws Exception {
        return auth.getAuthenticationManager();
    }

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

}
