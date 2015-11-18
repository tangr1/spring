/*
 * ******************************************************
 * Copyright VMware, Inc. 2014.   All Rights Reserved.
 * ******************************************************
 */

package com.ctof.server.model;

import com.ctof.server.model.converter.DateToDateTimeConverter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.joda.time.DateTime;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseModel {
    protected Long id;
    protected DateTime createTime;
    protected DateTime modifyTime;

    @PrePersist
    public void prePersist() {
        DateTime now = DateTime.now();
        this.createTime = now;
        this.modifyTime = now;
    }

    @PreUpdate
    public void preUpdate() {
        this.modifyTime = DateTime.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    @Column(name = "created_at")
    @Convert(converter = DateToDateTimeConverter.class)
    @JsonIgnore
    public DateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(DateTime createTime) {
        this.createTime = createTime;
    }

    @Column(name = "modified_at")
    @Convert(converter = DateToDateTimeConverter.class)
    @JsonIgnore
    public DateTime getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(DateTime modifyTime) {
        this.modifyTime = modifyTime;
    }
}
