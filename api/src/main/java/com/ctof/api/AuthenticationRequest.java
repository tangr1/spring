package com.ctof.api;


import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

    
    /**
    * 表示认证请求
    **/
    public class AuthenticationRequest  {
    
        private String password = null;
        private Integer expiration = null;
        private String email = null;

    
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
            * token失效时间, 单位为分钟
        **/
        @JsonProperty("expiration")
        @Valid
        public Integer getExpiration() {
            return expiration;
        }
        public void setExpiration(Integer expiration) {
            this.expiration = expiration;
        }
    
        /**
            * 用户注册的email地址
        **/
        @JsonProperty("email")
        @Valid
        @NotNull
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
    

        @Override
        public String toString()  {
            StringBuilder sb = new StringBuilder();
            sb.append("class AuthenticationRequest {\n");
            
            sb.append("  password: ").append(password).append("\n");
            sb.append("  expiration: ").append(expiration).append("\n");
            sb.append("  email: ").append(email).append("\n");
            sb.append("}\n");
            return sb.toString();
        }
    }
    
