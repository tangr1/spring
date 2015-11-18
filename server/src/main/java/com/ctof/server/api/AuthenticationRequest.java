package com.ctof.server.api;

import java.io.Serializable;

public class AuthenticationRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    private String email;
    private String password;
    private Integer expiredTime;

    public Integer getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Integer expiredTime) {
        this.expiredTime = expiredTime;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
