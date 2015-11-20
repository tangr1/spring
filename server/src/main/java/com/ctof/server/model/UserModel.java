package com.ctof.server.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserModel extends BaseModel {
    private String name;
    private String password;
    private String email;
    private String phone;
    private Role role;
    private Long startupId;
    private Status status;

    @Column
    @Enumerated(EnumType.STRING)
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Column
    @Enumerated(EnumType.STRING)
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Column(name = "startup_id")
    public Long getStartupId() {
        return startupId;
    }

    public void setStartupId(Long startupId) {
        this.startupId = startupId;
    }

    @Column
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public enum Role {
        ROOT,
        ADMIN,
        EMPLOYEE,
        INTERNAL_EXPERT,
        EXTERNAL_EXPERT,
    }

    public enum Status {
        NEW,
        REVIEWING,
        REJECTED,
        APPROVED,
        DELETED,
    }
}
