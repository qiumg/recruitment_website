package com.website.client.pojo;

import java.util.Date;

public class UserJobexp {
    private Integer id;

    private Integer resumeId;

    private String companyName;

    private String postName;

    private Date stratTime;

    private Date stopTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getResumeId() {
        return resumeId;
    }

    public void setResumeId(Integer resumeId) {
        this.resumeId = resumeId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName == null ? null : postName.trim();
    }

    public Date getStratTime() {
        return stratTime;
    }

    public void setStratTime(Date stratTime) {
        this.stratTime = stratTime;
    }

    public Date getStopTime() {
        return stopTime;
    }

    public void setStopTime(Date stopTime) {
        this.stopTime = stopTime;
    }

    @Override
    public String toString() {
        return "UserJobexp{" +
                "id=" + id +
                ", resumeId=" + resumeId +
                ", companyName='" + companyName + '\'' +
                ", postName='" + postName + '\'' +
                ", stratTime=" + stratTime +
                ", stopTime=" + stopTime +
                '}';
    }
}