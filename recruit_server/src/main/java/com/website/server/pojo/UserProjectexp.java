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
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName == null ? null : postName.trim();
    }

    public String getDescribe() {
        return describe1;
    }

    public void setDescribe(String describe) {
        this.describe1 = describe == null ? null : describe.trim();
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
                ", describe='" + describe1 + '\'' +
                ", stratTime=" + stratTime +
                ", stopTime=" + stopTime +
                '}';
    }
}