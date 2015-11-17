package com.ctof.server.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "topics")
public class Topic extends BaseModel {
    private Long userId = null;
    @NotNull
    private String title = null;
    private String body = null;
    private String category = null;
    @Min(10)
    private Long reward = null;
    private TopicStatus status = null;

    @Column
    @Enumerated(EnumType.STRING)
    public TopicStatus getStatus() {
        return status;
    }

    public void setStatus(TopicStatus status) {
        this.status = status;
    }

    @Column
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Column
    public Long getReward() {
        return reward;
    }

    public void setReward(Long reward) {
        this.reward = reward;
    }

    @Column
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Column
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public enum TopicStatus {
        unconfirmed,
        confirmed,
    }
}
