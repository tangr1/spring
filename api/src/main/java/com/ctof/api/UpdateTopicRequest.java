package com.ctof.api;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

    
    /**
    * 表示更新主题请求
    **/
    public class UpdateTopicRequest  {
    
        private Long startupId = null;
        private String title = null;
        private Integer ctocoins = null;
        private String category = null;
        private Long userId = null;
        private Boolean confirmed = null;
        private String content = null;
        private List<String> labels = null;

    
        /**
            * 主题发布者所属创业公司
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
            * 主题标题
        **/
        @JsonProperty("title")
        @Valid
        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }
    
        /**
            * 主题悬赏分
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
            * 主题类别
        **/
        @JsonProperty("category")
        @Valid
        public String getCategory() {
            return category;
        }
        public void setCategory(String category) {
            this.category = category;
        }
    
        /**
            * 主题发布者
        **/
        @JsonProperty("userId")
        @Valid
        public Long getUserId() {
            return userId;
        }
        public void setUserId(Long userId) {
            this.userId = userId;
        }
    
        /**
            * 主题是否已有回复被发布者采纳
        **/
        @JsonProperty("confirmed")
        @Valid
        public Boolean getConfirmed() {
            return confirmed;
        }
        public void setConfirmed(Boolean confirmed) {
            this.confirmed = confirmed;
        }
    
        /**
            * 主题内容
        **/
        @JsonProperty("content")
        @Valid
        public String getContent() {
            return content;
        }
        public void setContent(String content) {
            this.content = content;
        }
    
        /**
            * 主题标签
        **/
        @JsonProperty("labels")
        @Valid
        public List<String> getLabels() {
            return labels;
        }
        public void setLabels(List<String> labels) {
            this.labels = labels;
        }
    

        @Override
        public String toString()  {
            StringBuilder sb = new StringBuilder();
            sb.append("class UpdateTopicRequest {\n");
            
            sb.append("  startupId: ").append(startupId).append("\n");
            sb.append("  title: ").append(title).append("\n");
            sb.append("  ctocoins: ").append(ctocoins).append("\n");
            sb.append("  category: ").append(category).append("\n");
            sb.append("  userId: ").append(userId).append("\n");
            sb.append("  confirmed: ").append(confirmed).append("\n");
            sb.append("  content: ").append(content).append("\n");
            sb.append("  labels: ").append(labels).append("\n");
            sb.append("}\n");
            return sb.toString();
        }
    }
    
