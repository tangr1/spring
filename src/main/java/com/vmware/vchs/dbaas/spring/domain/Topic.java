package com.vmware.vchs.dbaas.spring.domain;

import javax.persistence.*;
import java.io.Serializable;

// Don't use foreign key for easy migration to nosql
@Entity
public class Topic implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id = null;
    @Column(nullable = false)
    private Long userId = null;
    @Column(nullable = false)
    private String title = null;
    @Column
    private String body = null;
    @Column
    private String category = null;
    @Column
    private Long reward = null;
    @Column
    private TopicStatus status = null;

    public TopicStatus getStatus() {
        return status;
    }

    public void setStatus(TopicStatus status) {
        this.status = status;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getReward() {
        return reward;
    }

    public void setReward(Long reward) {
        this.reward = reward;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

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
