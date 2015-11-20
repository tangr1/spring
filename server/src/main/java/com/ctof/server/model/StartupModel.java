package com.ctof.server.model;

import javax.persistence.*;

@Entity
@Table(name = "startups")
public class StartupModel extends BaseModel {
    private String name;
    private String corpName;
    private Integer startYear;
    private Integer startMonth;
    private String productName;
    private String productDesc;
    private String location;
    private String scope;
    private String phase;
    private String intro;
    private String corpIdPhoto;
    private String logo;
    private Long adminId;
    private Status status;

    @Column
    @Enumerated(EnumType.STRING)
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Column(name = "admin_id")
    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    @Column(name = "corp_name")
    public String getCorpName() {
        return corpName;
    }

    public void setCorpName(String corpName) {
        this.corpName = corpName;
    }

    @Column(name = "start_year")
    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    @Column(name = "start_month")
    public Integer getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(Integer startMonth) {
        this.startMonth = startMonth;
    }

    @Column(name = "product_name")
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Column(name = "product_desc")
    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    @Column
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Column
    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    @Column
    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    @Column
    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    @Column(name = "corp_id_photo")
    public String getCorpIdPhoto() {
        return corpIdPhoto;
    }

    public void setCorpIdPhoto(String corpIdPhoto) {
        this.corpIdPhoto = corpIdPhoto;
    }

    @Column
    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public enum Status {
        NEW,
        REVIEWING,
        REJECTED,
        APPROVED,
        DELETED,
    }
}
