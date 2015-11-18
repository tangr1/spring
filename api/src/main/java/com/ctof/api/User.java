package com.ctof.api;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

    
    /**
    * 表示用户资源
    **/
    public class User  {
    
        private Date createdAt = null;
        private String password = null;
        private String role = null;
        private String phone = null;
        private Date modifiedAt = null;
        private String name = null;
        private Long id = null;
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
            * 用户密码，仅在创建用户时需要提供，并需加密
        **/
        @JsonProperty("password")
        @Valid
        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }
    
        /**
            * 用户角色，目前可能为ROOT, ADMIN, EMPLOYEE, INTERNAL_EXPERT, EXTERNAL_EXPERT五种
        **/
        @JsonProperty("role")
        @Valid
        public String getRole() {
            return role;
        }
        public void setRole(String role) {
            this.role = role;
        }
    
        /**
            * 用户电话号码
        **/
        @JsonProperty("phone")
        @Valid
        public String getPhone() {
            return phone;
        }
        public void setPhone(String phone) {
            this.phone = phone;
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
            * 用户姓名
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
            * 用户ID，由后端自动生成，创建用户时不需要
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
            * 用户所属的创业公司ID，如为专家或根用户，则此项为空
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
            * 用户邮件地址
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
            sb.append("class User {\n");
            
            sb.append("  createdAt: ").append(createdAt).append("\n");
            sb.append("  password: ").append(password).append("\n");
            sb.append("  role: ").append(role).append("\n");
            sb.append("  phone: ").append(phone).append("\n");
            sb.append("  modifiedAt: ").append(modifiedAt).append("\n");
            sb.append("  name: ").append(name).append("\n");
            sb.append("  id: ").append(id).append("\n");
            sb.append("  startupId: ").append(startupId).append("\n");
            sb.append("  email: ").append(email).append("\n");
            sb.append("}\n");
            return sb.toString();
        }
    }
    
