package com.ctof.api;


import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

    
    /**
    * 表示更新创业公司请求
    **/
    public class UpdateStartupRequest  {
    
        private String phase = null;
        private Integer startMonth = null;
        private String corpIdPhoto = null;
        private Integer startYear = null;
        private String corpName = null;
        private String productName = null;
        private String productDesc = null;
        private String scope = null;
        private String intro = null;
        private String name = null;
        private Long adminId = null;
        private String logo = null;
        private String location = null;

    
        /**
            * 创业公司融资阶段
        **/
        @JsonProperty("phase")
        @Valid
        public String getPhase() {
            return phase;
        }
        public void setPhase(String phase) {
            this.phase = phase;
        }
    
        /**
            * 创业公司创始月份
        **/
        @JsonProperty("startMonth")
        @Valid
        public Integer getStartMonth() {
            return startMonth;
        }
        public void setStartMonth(Integer startMonth) {
            this.startMonth = startMonth;
        }
    
        /**
            * 创业公司照片地址
        **/
        @JsonProperty("corpIdPhoto")
        @Valid
        public String getCorpIdPhoto() {
            return corpIdPhoto;
        }
        public void setCorpIdPhoto(String corpIdPhoto) {
            this.corpIdPhoto = corpIdPhoto;
        }
    
        /**
            * 创业公司创始年份
        **/
        @JsonProperty("startYear")
        @Valid
        public Integer getStartYear() {
            return startYear;
        }
        public void setStartYear(Integer startYear) {
            this.startYear = startYear;
        }
    
        /**
            * 创业公司注册名称
        **/
        @JsonProperty("corpName")
        @Valid
        public String getCorpName() {
            return corpName;
        }
        public void setCorpName(String corpName) {
            this.corpName = corpName;
        }
    
        /**
            * 创业公司产品名称
        **/
        @JsonProperty("productName")
        @Valid
        public String getProductName() {
            return productName;
        }
        public void setProductName(String productName) {
            this.productName = productName;
        }
    
        /**
            * 创业公司产品描述
        **/
        @JsonProperty("productDesc")
        @Valid
        public String getProductDesc() {
            return productDesc;
        }
        public void setProductDesc(String productDesc) {
            this.productDesc = productDesc;
        }
    
        /**
            * 创业公司经营范围
        **/
        @JsonProperty("scope")
        @Valid
        public String getScope() {
            return scope;
        }
        public void setScope(String scope) {
            this.scope = scope;
        }
    
        /**
            * 创业公司介绍
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
            * 创业公司名称
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
            * 创业公司管理员ID
        **/
        @JsonProperty("adminId")
        @Valid
        public Long getAdminId() {
            return adminId;
        }
        public void setAdminId(Long adminId) {
            this.adminId = adminId;
        }
    
        /**
            * 创业公司Logo图片地址
        **/
        @JsonProperty("logo")
        @Valid
        public String getLogo() {
            return logo;
        }
        public void setLogo(String logo) {
            this.logo = logo;
        }
    
        /**
            * 创业公司地址
        **/
        @JsonProperty("location")
        @Valid
        public String getLocation() {
            return location;
        }
        public void setLocation(String location) {
            this.location = location;
        }
    

        @Override
        public String toString()  {
            StringBuilder sb = new StringBuilder();
            sb.append("class UpdateStartupRequest {\n");
            
            sb.append("  phase: ").append(phase).append("\n");
            sb.append("  startMonth: ").append(startMonth).append("\n");
            sb.append("  corpIdPhoto: ").append(corpIdPhoto).append("\n");
            sb.append("  startYear: ").append(startYear).append("\n");
            sb.append("  corpName: ").append(corpName).append("\n");
            sb.append("  productName: ").append(productName).append("\n");
            sb.append("  productDesc: ").append(productDesc).append("\n");
            sb.append("  scope: ").append(scope).append("\n");
            sb.append("  intro: ").append(intro).append("\n");
            sb.append("  name: ").append(name).append("\n");
            sb.append("  adminId: ").append(adminId).append("\n");
            sb.append("  logo: ").append(logo).append("\n");
            sb.append("  location: ").append(location).append("\n");
            sb.append("}\n");
            return sb.toString();
        }
    }
    
