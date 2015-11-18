package com.ctof.server.api;

import org.joda.time.DateTime;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable {

    private static final long serialVersionUID = 1L;
    private String token;
    private DateTime expiresIn;

    public DateTime getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(DateTime expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
