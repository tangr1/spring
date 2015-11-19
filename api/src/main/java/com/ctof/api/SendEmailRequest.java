package com.ctof.api;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

    
    /**
    * 表示发送邮件请求
    **/
    public class SendEmailRequest  {
    
        private List<String> cc = null;
        private String subject = null;
        private List<String> to = null;
        private String body = null;

    
        /**
            * 抄送人
        **/
        @JsonProperty("cc")
        @Valid
        public List<String> getCc() {
            return cc;
        }
        public void setCc(List<String> cc) {
            this.cc = cc;
        }
    
        /**
            * 标题
        **/
        @JsonProperty("subject")
        @Valid
        public String getSubject() {
            return subject;
        }
        public void setSubject(String subject) {
            this.subject = subject;
        }
    
        /**
            * 收件人
        **/
        @JsonProperty("to")
        @Valid
        public List<String> getTo() {
            return to;
        }
        public void setTo(List<String> to) {
            this.to = to;
        }
    
        /**
            * 正文
        **/
        @JsonProperty("body")
        @Valid
        public String getBody() {
            return body;
        }
        public void setBody(String body) {
            this.body = body;
        }
    

        @Override
        public String toString()  {
            StringBuilder sb = new StringBuilder();
            sb.append("class SendEmailRequest {\n");
            
            sb.append("  cc: ").append(cc).append("\n");
            sb.append("  subject: ").append(subject).append("\n");
            sb.append("  to: ").append(to).append("\n");
            sb.append("  body: ").append(body).append("\n");
            sb.append("}\n");
            return sb.toString();
        }
    }
    
