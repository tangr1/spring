package com.ctof.server.model;

import javax.persistence.*;

@Entity
@Table(name = "invitecodes")
public class InviteCodeModel extends BaseModel {
    private Type type;
    private String code;
    private Integer quota;
    private Integer used;
    private Long inviterId;
    private Long startupId;

    @Column(name = "startup_id")
    public Long getStartupId() {
        return startupId;
    }

    public void setStartupId(Long startupId) {
        this.startupId = startupId;
    }

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
    public Integer getUsed() {
        return used;
    }

    public void setUsed(Integer used) {
        this.used = used;
    }

    @Column(name = "inviter_id")
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
