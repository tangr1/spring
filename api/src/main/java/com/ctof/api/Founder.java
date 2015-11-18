package com.ctof.api;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

    
    /**
    * 表示创业人资源
    **/
    public class Founder  {
    
        private Date createdAt = null;
        private Date modifiedAt = null;
        private String intro = null;
        private String name = null;
        private Long id = null;
        private String position = null;
        private Long startupId = null;
        private String email = null;

    
        /**
            * 创建时间
        **/
        @JsonProperty("createdAt")
        @Valid
        public Date getCreatedAt() {
            return createdAt;
        }
        public void setCreatedAt(Date createdAt) {
            this.createdAt = createdAt;
        }
    
        /**
            * 最近一次修改时间
        **/
        @JsonProperty("modifiedAt")
        @Valid
        public Date getModifiedAt() {
            return modifiedAt;
        }
        public void setModifiedAt(Date modifiedAt) {
            this.modifiedAt = modifiedAt;
        }
    
        /**
            * 创始人介绍
        **/
        @JsonProperty("intro")
        @Valid
        public String getIntro() {
            return intro;
        }
        public void setIntro(String intro) {
            this.intro = intro;
        }
    
        /**
            * 创始人姓名
        **/
        @JsonProperty("name")
        @Valid
        @NotNull
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    
        /**
            * 创业人ID，由后端自动生成，创建创业人时不需要
        **/
        @JsonProperty("id")
        @Valid
        public Long getId() {
            return id;
        }
        public void setId(Long id) {
            this.id = id;
        }
    
        /**
            * 创始人职位
        **/
        @JsonProperty("position")
        @Valid
        public String getPosition() {
            return position;
        }
        public void setPosition(String position) {
            this.position = position;
        }
    
        /**
            * 创业公司ID
        **/
        @JsonProperty("startupId")
        @Valid
        public Long getStartupId() {
            return startupId;
        }
        public void setStartupId(Long startupId) {
            this.startupId = startupId;
        }
    
        /**
            * 创始人邮件地址
        **/
        @JsonProperty("email")
        @Valid
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
    

        @Override
        public String toString()  {
            StringBuilder sb = new StringBuilder();
            sb.append("class Founder {\n");
            
            sb.append("  createdAt: ").append(createdAt).append("\n");
            sb.append("  modifiedAt: ").append(modifiedAt).append("\n");
            sb.append("  intro: ").append(intro).append("\n");
            sb.append("  name: ").append(name).append("\n");
            sb.append("  id: ").append(id).append("\n");
            sb.append("  position: ").append(position).append("\n");
            sb.append("  startupId: ").append(startupId).append("\n");
            sb.append("  email: ").append(email).append("\n");
            sb.append("}\n");
            return sb.toString();
        }
    }
    
