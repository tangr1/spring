package com.ctof.server.controller;

import com.ctof.api.AuthenticationRequest;
import com.ctof.api.AuthenticationResponse;
import com.ctof.api.User;
import com.ctof.server.service.TokenService;
import com.ctof.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@RestController
public class AuthenticationController {

    @Value("${application.token.header}")
    private String tokenHeader;

    @Value("${application.token.default-expiration}")
    private Integer defaultExpiration;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserService userService;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value = "/auth/login", method = RequestMethod.POST)
    @Transactional(readOnly = true)
    public ResponseEntity<?> request(@RequestBody AuthenticationRequest request) throws AuthenticationException {

        // Perform the authentication
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Reload password post-authentication so we can generate token
        User user = userService.getByEmail(request.getEmail());
        int expiration = request.getExpiration() != null ? request.getExpiration()
                : defaultExpiration;
        LocalDateTime expiredDateTime = LocalDateTime.now(ZoneOffset.UTC).withNano(0).plusMinutes(expiration);
        String token = tokenService.generateToken(user.getEmail(), expiredDateTime);

        // Return the token
        AuthenticationResponse response = new AuthenticationResponse();
        response.setToken(token);
        response.setExpiresIn(expiredDateTime);
        response.setUser(user);
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "/auth/logout", method = RequestMethod.POST)
    @Transactional(readOnly = true)
    public void request() throws AuthenticationException {
        tokenService.invalidateToken(request.getHeader(tokenHeader));
    }
}
