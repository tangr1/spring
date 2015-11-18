package com.ctof.server.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "invitecodes")
public class InviteCode extends BaseModel {
    @NotNull
    private Type type;
    private String code;
    private Integer quota;
    private Integer usage;
    private Long inviterId;

    @Column
    @Enumerated(EnumType.STRING)
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Column
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column
    public Integer getQuota() {
        return quota;
    }

    public void setQuota(Integer quota) {
        this.quota = quota;
    }

    @Column
    public Integer getUsage() {
        return usage;
    }

    public void setUsage(Integer usage) {
        this.usage = usage;
    }

    @Column
    public Long getInviterId() {
        return inviterId;
    }

    public void setInviterId(Long inviterId) {
        this.inviterId = inviterId;
    }

    public enum Type {
        EMPLOYEE,
        INTERNAL_EXPERT,
        EXTERNAL_EXPERT
    }
}
