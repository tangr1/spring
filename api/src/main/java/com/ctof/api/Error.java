package com.ctof.api;


import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

    
    public class Error  {
    
        private String code = null;
        private String message = null;

    
        /**
            * 错误代码
        **/
        @JsonProperty("code")
        @Valid
        public String getCode() {
            return code;
        }
        public void setCode(String code) {
            this.code = code;
        }
    
        /**
            * 错误信息
        **/
        @JsonProperty("message")
        @Valid
        public String getMessage() {
            return message;
        }
        public void setMessage(String message) {
            this.message = message;
        }
    

        @Override
        public String toString()  {
            StringBuilder sb = new StringBuilder();
            sb.append("class Error {\n");
            
            sb.append("  code: ").append(code).append("\n");
            sb.append("  message: ").append(message).append("\n");
            sb.append("}\n");
            return sb.toString();
        }
    }
    
