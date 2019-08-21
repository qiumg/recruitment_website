package com.website.server.pojo;

import java.util.Date;

public class UserProjectexp {
    private Integer id;

    private Integer resumeId;

    private String projectName;

    private String postName;

    private String describe1;

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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getDescribe1() {
        return describe1;
    }

    public void setDescribe1(String describe1) {
        this.describe1 = describe1;
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
        return "UserProjectexp{" +
                "id=" + id +
                ", resumeId=" + resumeId +
                ", projectName='" + projectName + '\'' +
                ", postName='" + postName + '\'' +
                ", describe1='" + describe1 + '\'' +
                ", stratTime=" + stratTime +
                ", stopTime=" + stopTime +
                '}';
    }
}