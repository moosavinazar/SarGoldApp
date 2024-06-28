package com.sar.goldapp.service.authentication;

import com.sar.goldapp.model.authentication.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {

    private final Logger log = LoggerFactory.getLogger(JwtService.class);

    @Value("${sar.goldapp.jwtSecret}")
    private String SECRET;

    @Value("${sar.goldapp.jwtExpirationMs}")
    private int jwtExpirationMs;

    public String generateToken(User user) {
        return generateTokenFromUsername(user.getUsername());
    }

    private SecretKey getSignInKey() {
        byte[] keyByte = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyByte);
    }
    public String generateTokenFromUsername(String userName) {
        return Jwts.builder().subject(userName)
                .expiration(new Date(new Date().getTime() + jwtExpirationMs))
                .signWith(getSignInKey(), Jwts.SIG.HS512)
                .compact();
    }

    public String getUserName(String token) {
        return Jwts.parser().verifyWith(getSignInKey()).build().parseSignedClaims(token).getPayload().getSubject();
    }

    public boolean validateJwtToken(String authToken) {

        try {
            Jwts.parser().verifyWith(getSignInKey()).build().parseSignedClaims(authToken);
            return true;
        } catch (SignatureException e) {
            log.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            log.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            log.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            log.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;

    }

}
