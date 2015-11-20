package com.ctof.server.service.impl;

import com.ctof.server.service.TokenService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
@Profile({"dev", "prod"})
public class RedisTokenService implements TokenService {

    @Value("${application.token.secret}")
    private String secret;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public String getEmailFromToken(String token) {
        if (token == null || !redisTemplate.hasKey(token)) {
            return null;
        }

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
        String token = Jwts.builder()
                .setSubject(email)
                .signWith(SignatureAlgorithm.HS256, secret)
                .setExpiration(Date.from(expiration.atZone(ZoneId.of("UTC")).toInstant()))
                .compact();
        ValueOperations<String, String> vp = redisTemplate.opsForValue();
        vp.set(token, "", expiration.toEpochSecond(ZoneOffset.UTC) -
                LocalDateTime.now(ZoneOffset.UTC).toEpochSecond(ZoneOffset.UTC), TimeUnit.SECONDS);
        return token;
    }

    @Override
    public boolean validateToken(String token, String email) {
        return token != null && redisTemplate.hasKey(token) && getEmailFromToken(token).equals(email);
    }

    @Override
    public void refreshToken(String token, LocalDateTime expiration) {
        if (token != null && redisTemplate.hasKey(token)) {
            redisTemplate.expire(token, expiration.toEpochSecond(ZoneOffset.UTC) -
                    LocalDateTime.now(ZoneOffset.UTC).toEpochSecond(ZoneOffset.UTC), TimeUnit.SECONDS);
        }
    }

    @Override
    public void invalidateToken(String token) {
        if (token != null && redisTemplate.hasKey(token)) {
            redisTemplate.delete(token);
        }
    }
}
