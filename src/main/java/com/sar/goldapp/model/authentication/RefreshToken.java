package com.sar.goldapp.model.authentication;

import jakarta.persistence.*;

@Entity(name = "auth_refresh_token")
public class RefreshToken {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "refresh_token_generator")
    @SequenceGenerator(name = "refresh_token_generator", sequenceName = "refresh_token_seq", allocationSize = 1, initialValue = 5)
    private long id;

    @OneToOne
    private User user;

    @Column(name = "token", nullable = false, unique = true)
    private String token;

    public RefreshToken() {
    }

    public RefreshToken(long id, User user, String token) {
        this.id = id;
        this.user = user;
        this.token = token;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "RefreshToken{" +
                "id=" + id +
                ", user=" + user +
                ", token='" + token + '\'' +
                '}';
    }
}
