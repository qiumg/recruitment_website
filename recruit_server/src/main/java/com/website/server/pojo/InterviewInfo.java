package com.website.server.pojo;

import java.util.Date;

public class InterviewInfo {
    private Integer iId;

    private Integer userId;

    private Integer hrId;

    private String hrName;

    private String iAddress;

    private Date iTime;

    private String iStatic;

    public Integer getiId() {
        return iId;
    }

    public void setiId(Integer iId) {
        this.iId = iId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getHrId() {
        return hrId;
    }

    public void setHrId(Integer hrId) {
        this.hrId = hrId;
    }

    public String getHrName() {
        return hrName;
    }

    public void setHrName(String hrName) {
        this.hrName = hrName == null ? null : hrName.trim();
    }

    public String getiAddress() {
        return iAddress;
    }

    public void setiAddress(String iAddress) {
        this.iAddress = iAddress == null ? null : iAddress.trim();
    }

    public Date getiTime() {
        return iTime;
    }

    public void setiTime(Date iTime) {
        this.iTime = iTime;
    }

    public String getiStatic() {
        return iStatic;
    }

    public void setiStatic(String iStatic) {
        this.iStatic = iStatic == null ? null : iStatic.trim();
    }
}