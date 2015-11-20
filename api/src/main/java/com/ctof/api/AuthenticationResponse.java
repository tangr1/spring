package com.ctof.api;

import com.ctof.api.User;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

    
    /**
    * 表示认证响应
    **/
    public class AuthenticationResponse  {
    
        private java.time.LocalDateTime expiresIn = null;
        private User user = null;
        private String token = null;

    
        /**
            * token失效时间
        **/
        @JsonProperty("expiresIn")
        @Valid
        public java.time.LocalDateTime getExpiresIn() {
            return expiresIn;
        }
        public void setExpiresIn(java.time.LocalDateTime expiresIn) {
            this.expiresIn = expiresIn;
        }
    
        /**
            * 用户信息
        **/
        @JsonProperty("user")
        @Valid
        public User getUser() {
            return user;
        }
        public void setUser(User user) {
            this.user = user;
        }
    
        /**
            * 访问token
        **/
        @JsonProperty("token")
        @Valid
        public String getToken() {
            return token;
        }
        public void setToken(String token) {
            this.token = token;
        }
    

        @Override
        public String toString()  {
            StringBuilder sb = new StringBuilder();
            sb.append("class AuthenticationResponse {\n");
            
            sb.append("  expiresIn: ").append(expiresIn).append("\n");
            sb.append("  user: ").append(user).append("\n");
            sb.append("  token: ").append(token).append("\n");
            sb.append("}\n");
            return sb.toString();
        }
    }
    
