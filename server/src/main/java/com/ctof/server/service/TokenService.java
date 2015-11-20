package com.ctof.server.service;

import java.time.LocalDateTime;

public interface TokenService {

    String getEmailFromToken(String token);

    String generateToken(String email, LocalDateTime expiration);

    boolean validateToken(String token, String email);

    void refreshToken(String token, LocalDateTime expiration);

    void invalidateToken(String token);
}
