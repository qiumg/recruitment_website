package com.website.client.pojo;

import java.util.Date;

public class UserEducation {
    private Integer id;

    private Integer resumeId;

    private String university;

    private String education;

    private String major;

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

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university == null ? null : university.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
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
        return "UserEducation{" +
                "id=" + id +
                ", resumeId=" + resumeId +
                ", university='" + university + '\'' +
                ", education='" + education + '\'' +
                ", major='" + major + '\'' +
                ", stratTime=" + stratTime +
                ", stopTime=" + stopTime +
                '}';
    }
}