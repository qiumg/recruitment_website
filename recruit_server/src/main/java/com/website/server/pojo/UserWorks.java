package com.website.server.pojo;

public class UserWorks {
    private Integer id;

    private Integer resumeId;

    private String link;

    private String describe1;

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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescribe1() {
        return describe1;
    }

    public void setDescribe1(String describe1) {
        this.describe1 = describe1;
    }

    @Override
    public String toString() {
        return "UserWorks{" +
                "id=" + id +
                ", resumeId=" + resumeId +
                ", link='" + link + '\'' +
                ", describe1='" + describe1 + '\'' +
                '}';
    }
}