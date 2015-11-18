package com.ctof.api;


import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

    
    /**
    * 表示认证请求
    **/
    public class AuthenticationRequest  {
    
        private String password = null;
        private String username = null;

    
        /**
            * 密码，需加密，不可明文传输
        **/
        @JsonProperty("password")
        @Valid
        @NotNull
        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }
    
        /**
            * 用户名
        **/
        @JsonProperty("username")
        @Valid
        @NotNull
        public String getUsername() {
            return username;
        }
        public void setUsername(String username) {
            this.username = username;
        }
    

        @Override
        public String toString()  {
            StringBuilder sb = new StringBuilder();
            sb.append("class AuthenticationRequest {\n");
            
            sb.append("  password: ").append(password).append("\n");
            sb.append("  username: ").append(username).append("\n");
            sb.append("}\n");
            return sb.toString();
        }
    }
    
