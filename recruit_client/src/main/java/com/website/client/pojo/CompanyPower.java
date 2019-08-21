package com.website.client.pojo;

public class CompanyPower {
    private Integer pId;

    private String pName;

    private Integer pTime;

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    public Integer getpTime() {
        return pTime;
    }

    public void setpTime(Integer pTime) {
        this.pTime = pTime;
    }
}