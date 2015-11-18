package com.ctof.api;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

    
    /**
    * 表示评论资源
    **/
    public class Comment  {
    
        private Date createdAt = null;
        private Long topicId = null;
        private Date modifiedAt = null;
        private Long replyId = null;
        private Long id = null;
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
            * 评论主题的ID
        **/
        @JsonProperty("topicId")
        @Valid
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
            * 评论主题的ID
        **/
        @JsonProperty("replyId")
        @Valid
        public Long getReplyId() {
            return replyId;
        }
        public void setReplyId(Long replyId) {
            this.replyId = replyId;
        }
    
        /**
            * 评论ID，由后端自动生成，创建时不需要
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
            * 评论发布者
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
            * 评论内容
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
            sb.append("class Comment {\n");
            
            sb.append("  createdAt: ").append(createdAt).append("\n");
            sb.append("  topicId: ").append(topicId).append("\n");
            sb.append("  modifiedAt: ").append(modifiedAt).append("\n");
            sb.append("  replyId: ").append(replyId).append("\n");
            sb.append("  id: ").append(id).append("\n");
            sb.append("  userId: ").append(userId).append("\n");
            sb.append("  content: ").append(content).append("\n");
            sb.append("}\n");
            return sb.toString();
        }
    }
    
