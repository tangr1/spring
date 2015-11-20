package com.ctof.api;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

    
    /**
    * 表示邀请码资源
    **/
    public class InviteCode  {
    
        private java.time.LocalDateTime createdAt = null;
        private String code = null;
        private Long inviterId = null;
        private java.time.LocalDateTime modifiedAt = null;
        private Integer quota = null;
        private Long id = null;
        private Integer used = null;
        public enum TypeEnum {
         EMPLOYEE,  INTERNAL_EXPERT,  EXTERNAL_EXPERT, 
        };
        private TypeEnum type = null;
        private Long startupId = null;

    
        /**
            * 创建时间
        **/
        @JsonProperty("createdAt")
        @Valid
        public java.time.LocalDateTime getCreatedAt() {
            return createdAt;
        }
        public void setCreatedAt(java.time.LocalDateTime createdAt) {
            this.createdAt = createdAt;
        }
    
        /**
            * 邀请码
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
            * 邀请者ID
        **/
        @JsonProperty("inviterId")
        @Valid
        public Long getInviterId() {
            return inviterId;
        }
        public void setInviterId(Long inviterId) {
            this.inviterId = inviterId;
        }
    
        /**
            * 最近一次修改时间
        **/
        @JsonProperty("modifiedAt")
        @Valid
        public java.time.LocalDateTime getModifiedAt() {
            return modifiedAt;
        }
        public void setModifiedAt(java.time.LocalDateTime modifiedAt) {
            this.modifiedAt = modifiedAt;
        }
    
        /**
            * 配额
        **/
        @JsonProperty("quota")
        @Valid
        public Integer getQuota() {
            return quota;
        }
        public void setQuota(Integer quota) {
            this.quota = quota;
        }
    
        /**
            * 邀请码ID，由后端自动生成，创建时不需要
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
            * 已使用额度
        **/
        @JsonProperty("used")
        @Valid
        public Integer getUsed() {
            return used;
        }
        public void setUsed(Integer used) {
            this.used = used;
        }
    
        /**
            * 邀请码类型, 和用户role匹配
        **/
        @JsonProperty("type")
        @Valid
        public TypeEnum getType() {
            return type;
        }
        public void setType(TypeEnum type) {
            this.type = type;
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
    

        @Override
        public String toString()  {
            StringBuilder sb = new StringBuilder();
            sb.append("class InviteCode {\n");
            
            sb.append("  createdAt: ").append(createdAt).append("\n");
            sb.append("  code: ").append(code).append("\n");
            sb.append("  inviterId: ").append(inviterId).append("\n");
            sb.append("  modifiedAt: ").append(modifiedAt).append("\n");
            sb.append("  quota: ").append(quota).append("\n");
            sb.append("  id: ").append(id).append("\n");
            sb.append("  used: ").append(used).append("\n");
            sb.append("  type: ").append(type).append("\n");
            sb.append("  startupId: ").append(startupId).append("\n");
            sb.append("}\n");
            return sb.toString();
        }
    }
    
