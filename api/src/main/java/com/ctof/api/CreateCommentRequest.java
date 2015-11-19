package com.ctof.api;


import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.Valid;
import javax.validation.constraints.*;

    
    /**
    * 表示创建评论请求
    **/
    public class CreateCommentRequest  {
    
        private Long topicId = null;
        private Long replyId = null;
        private Long userId = null;
        private String content = null;

    
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
            sb.append("class CreateCommentRequest {\n");
            
            sb.append("  topicId: ").append(topicId).append("\n");
            sb.append("  replyId: ").append(replyId).append("\n");
            sb.append("  userId: ").append(userId).append("\n");
            sb.append("  content: ").append(content).append("\n");
            sb.append("}\n");
            return sb.toString();
        }
    }
    
