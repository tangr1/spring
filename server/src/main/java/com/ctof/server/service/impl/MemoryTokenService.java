package com.ctof.server.service.impl;

import com.ctof.server.service.TokenService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
@Profile({"test"})
public class MemoryTokenService implements TokenService {

    @Value("${application.token.secret}")
    private String secret;

    @Override
    public String getEmailFromToken(String token) {
        String email;
        try {
            email = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
        } catch (Exception e) {
            email = null;
        }
        return email;
    }

    @Override
    public String generateToken(String email, LocalDateTime expiration) {
        return Jwts.builder()
                .setSubject(email)
                .signWith(SignatureAlgorithm.HS256, secret)
                .setExpiration(Date.from(expiration.atZone(ZoneId.of("UTC")).toInstant()))
                .compact();
    }

    @Override
    public boolean validateToken(String token, String email) {
        return (getEmailFromToken(token).equals(email));
    }

    // Memory token cannot be refreshed
    @Override
    public void refreshToken(String token, LocalDateTime expiration) {
    }

    // Memory token cannot be invalidated
    @Override
    public void invalidateToken(String token) {
    }
}
