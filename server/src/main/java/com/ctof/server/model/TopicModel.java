package com.ctof.server.model;

import com.ctof.server.model.converter.StringArrayToStringConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "topics")
public class TopicModel extends BaseModel {
    @NotNull
    private Long userId = null;
    @NotNull
    private String title = null;
    private String content = null;
    private String category = null;
    @Min(10)
    private Long ctocoins = null;
    private Boolean confirmed = null;
    private String[] labels = null;

    @Column
    public Boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    @Convert(converter = StringArrayToStringConverter.class)
    public String[] getLabels() {
        return labels;
    }

    public void setLabels(String[] labels) {
        this.labels = labels;
    }

    @Column
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Column
    public Long getCtocoins() {
        return ctocoins;
    }

    public void setCtocoins(Long ctocoins) {
        this.ctocoins = ctocoins;
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
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
