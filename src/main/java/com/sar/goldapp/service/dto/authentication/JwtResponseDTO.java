package com.sar.goldapp.service.dto.authentication;

public class JwtResponseDTO {

    private String Authorization;

    private String refreshToken;

    private UserDTO user;

    public JwtResponseDTO() {
    }

    public JwtResponseDTO(String authorization, String refreshToken, UserDTO user) {
        this.Authorization = authorization;
        this.refreshToken = refreshToken;
        this.user = user;
    }

    public String getAuthorization() {
        return Authorization;
    }

    public void setAuthorization(String authorization) {
        Authorization = authorization;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "JwtAuthenticationDTO{" +
                "Authorization='" + Authorization + '\'' +
                "refreshToken='" + refreshToken + '\'' +
                ", user=" + user +
                '}';
    }
}
