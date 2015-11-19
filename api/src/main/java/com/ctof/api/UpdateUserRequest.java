package com.ctof.api;


import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

    
    /**
    * 表示更新用户请求
    **/
    public class UpdateUserRequest  {
    
        private String password = null;
        public enum RoleEnum {
         ROOT,  ADMIN,  EMPLOYEE,  INTERNAL_EXPERT,  EXTERNAL_EXPERT, 
        };
        private RoleEnum role = null;
        private String phone = null;
        private String name = null;
        private Long startupId = null;
        private Integer ctocoins = null;
        private String email = null;
        public enum StatusEnum {
         NEW,  REVIEWING,  REJECTED,  APPROVED,  DELETED, 
        };
        private StatusEnum status = null;

    
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
        public RoleEnum getRole() {
            return role;
        }
        public void setRole(RoleEnum role) {
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
            * 用户姓名
        **/
        @JsonProperty("name")
        @Valid
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
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
            * 拥有的悬赏分
        **/
        @JsonProperty("ctocoins")
        @Valid
        public Integer getCtocoins() {
            return ctocoins;
        }
        public void setCtocoins(Integer ctocoins) {
            this.ctocoins = ctocoins;
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
    
        /**
            * 用户状态
        **/
        @JsonProperty("status")
        @Valid
        public StatusEnum getStatus() {
            return status;
        }
        public void setStatus(StatusEnum status) {
            this.status = status;
        }
    

        @Override
        public String toString()  {
            StringBuilder sb = new StringBuilder();
            sb.append("class UpdateUserRequest {\n");
            
            sb.append("  password: ").append(password).append("\n");
            sb.append("  role: ").append(role).append("\n");
            sb.append("  phone: ").append(phone).append("\n");
            sb.append("  name: ").append(name).append("\n");
            sb.append("  startupId: ").append(startupId).append("\n");
            sb.append("  ctocoins: ").append(ctocoins).append("\n");
            sb.append("  email: ").append(email).append("\n");
            sb.append("  status: ").append(status).append("\n");
            sb.append("}\n");
            return sb.toString();
        }
    }
    
