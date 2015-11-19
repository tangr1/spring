package com.ctof.api;


import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

    
    /**
    * 表示创建邀请码请求
    **/
    public class CreateInviteCodeRequest  {
    
        private String code = null;
        private Long inviterId = null;
        private Integer quota = null;
        public enum TypeEnum {
         EMPLOYEE,  INTERNAL_EXPERT,  EXTERNAL_EXPERT, 
        };
        private TypeEnum type = null;
        private Long startupId = null;

    
        /**
            * 邀请码
        **/
        @JsonProperty("code")
        @Valid
        @NotNull
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
            * 配额
        **/
        @JsonProperty("quota")
        @Valid
        @NotNull
        public Integer getQuota() {
            return quota;
        }
        public void setQuota(Integer quota) {
            this.quota = quota;
        }
    
        /**
            * 邀请码类型, 和用户role匹配
        **/
        @JsonProperty("type")
        @Valid
        @NotNull
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
            sb.append("class CreateInviteCodeRequest {\n");
            
            sb.append("  code: ").append(code).append("\n");
            sb.append("  inviterId: ").append(inviterId).append("\n");
            sb.append("  quota: ").append(quota).append("\n");
            sb.append("  type: ").append(type).append("\n");
            sb.append("  startupId: ").append(startupId).append("\n");
            sb.append("}\n");
            return sb.toString();
        }
    }
    
