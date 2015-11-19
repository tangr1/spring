package com.ctof.api;


import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

    
    /**
    * 表示认证响应
    **/
    public class AuthenticationResponse  {
    
        private String expiresIn = null;
        private String token = null;

    
        /**
            * token失效时间
        **/
        @JsonProperty("expiresIn")
        @Valid
        public String getExpiresIn() {
            return expiresIn;
        }
        public void setExpiresIn(String expiresIn) {
            this.expiresIn = expiresIn;
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
            sb.append("  token: ").append(token).append("\n");
            sb.append("}\n");
            return sb.toString();
        }
    }
    
