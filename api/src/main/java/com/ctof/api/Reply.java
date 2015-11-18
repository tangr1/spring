package com.ctof.api;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

    
    /**
    * 表示回复资源
    **/
    public class Reply  {
    
        private Date createdAt = null;
        private Long topicId = null;
        private Date modifiedAt = null;
        private Long id = null;
        private String title = null;
        private Long userId = null;
        private String content = null;

    
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
            * 回复主题的ID
        **/
        @JsonProperty("topicId")
        @Valid
        @NotNull
        public Long getTopicId() {
            return topicId;
        }
        public void setTopicId(Long topicId) {
            this.topicId = topicId;
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
            * 回复ID，由后端自动生成，创建时不需要
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
            * 回复标题
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
            * 回复发布者
        **/
        @JsonProperty("userId")
        @Valid
        @NotNull
        public Long getUserId() {
            return userId;
        }
        public void setUserId(Long userId) {
            this.userId = userId;
        }
    
        /**
            * 回复内容
        **/
        @JsonProperty("content")
        @Valid
        public String getContent() {
            return content;
        }
        public void setContent(String content) {
            this.content = content;
        }
    

        @Override
        public String toString()  {
            StringBuilder sb = new StringBuilder();
            sb.append("class Reply {\n");
            
            sb.append("  createdAt: ").append(createdAt).append("\n");
            sb.append("  topicId: ").append(topicId).append("\n");
            sb.append("  modifiedAt: ").append(modifiedAt).append("\n");
            sb.append("  id: ").append(id).append("\n");
            sb.append("  title: ").append(title).append("\n");
            sb.append("  userId: ").append(userId).append("\n");
            sb.append("  content: ").append(content).append("\n");
            sb.append("}\n");
            return sb.toString();
        }
    }
    
