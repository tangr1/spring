package com.ctof.api;


import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

    
    /**
    * 表示更新回复请求
    **/
    public class UpdateReplyRequest  {
    
        private Long topicId = null;
        private String title = null;
        private Long userId = null;
        private String content = null;

    
        /**
            * 回复主题的ID
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
            sb.append("class UpdateReplyRequest {\n");
            
            sb.append("  topicId: ").append(topicId).append("\n");
            sb.append("  title: ").append(title).append("\n");
            sb.append("  userId: ").append(userId).append("\n");
            sb.append("  content: ").append(content).append("\n");
            sb.append("}\n");
            return sb.toString();
        }
    }
    
