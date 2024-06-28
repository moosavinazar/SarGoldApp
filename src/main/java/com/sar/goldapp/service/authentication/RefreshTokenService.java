package com.sar.goldapp.service.authentication;

import com.sar.goldapp.exception.TokenRefreshException;
import com.sar.goldapp.model.authentication.RefreshToken;
import com.sar.goldapp.model.authentication.User;
import com.sar.goldapp.repository.authentication.RefreshTokenRepository;
import com.sar.goldapp.repository.authentication.UserRepository;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.util.Date;
import java.util.Optional;

@Service
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;

    private final UserRepository userRepository;

    @Value("${sar.goldapp.jwtRefreshExpirationMs}")
    private Long refreshTokenDurationMs;

    @Value("${sar.goldapp.jwtRefreshSecret}")
    private String REFRESH_SECRET;

    public RefreshTokenService(RefreshTokenRepository refreshTokenRepository, UserRepository userRepository) {
        this.refreshTokenRepository = refreshTokenRepository;
        this.userRepository = userRepository;
    }

    public Optional<RefreshToken> findByToken(String token) {
        return refreshTokenRepository.findByToken(token);
    }

    public RefreshToken createRefreshToken(long userId) {

        RefreshToken refreshToken = refreshTokenRepository.findByUserId(userId).orElse(new RefreshToken());

        User user = userRepository.findById(userId).orElse(null);
        refreshToken.setUser(user);
        assert user != null;
        refreshToken.setToken(generateRefreshTokenFromUsername(user.getUsername()));

        refreshToken = refreshTokenRepository.save(refreshToken);
        return refreshToken;

    }

    private SecretKey getSignInKey() {
        byte[] keyByte = Decoders.BASE64.decode(REFRESH_SECRET);
        return Keys.hmacShaKeyFor(keyByte);
    }
    public String generateRefreshTokenFromUsername(String userName) {
        return Jwts.builder().subject(userName)
                .expiration(new Date(new Date().getTime() + refreshTokenDurationMs))
                .signWith(getSignInKey(), Jwts.SIG.HS512)
                .compact();
    }

    public Instant getExpireDate(String token) throws TokenRefreshException {
        Instant result = null;
        try {
            result = Jwts.parser().verifyWith(getSignInKey()).build().parseSignedClaims(token).getPayload().getExpiration().toInstant();
        } catch (ExpiredJwtException e) {
            throw new TokenRefreshException();
        }
        return result;
    }

    public Boolean verifyExpiration(RefreshToken token) throws TokenRefreshException {

        if (getExpireDate(token.getToken()).compareTo(Instant.now()) < 0) {
            refreshTokenRepository.delete(token);
            throw new TokenRefreshException();
        }
        return true;

    }

    @Transactional
    public int deleteByUserId(long userId) {
        return refreshTokenRepository.deleteByUser(userRepository.findById(userId).get());
    }
}
