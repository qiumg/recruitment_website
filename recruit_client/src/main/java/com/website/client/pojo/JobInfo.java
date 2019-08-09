package com.website.client.pojo;

import java.util.Date;

public class JobInfo {
    private Integer jId;

    private String jName;

    private String jCharacter;

    private String jk2Name;

    private Integer jMlow;

    private Integer jMhigh;

    private String jExperience;

    private Date jDate;

    private Integer jNum;

    private String jLoc;

    private String jReq;

    private String jDes;

    private String jBenefit;

    private Integer cId;

    public Integer getjId() {
        return jId;
    }

    public void setjId(Integer jId) {
        this.jId = jId;
    }

    public String getjName() {
        return jName;
    }

    public void setjName(String jName) {
        this.jName = jName == null ? null : jName.trim();
    }

    public String getjCharacter() {
        return jCharacter;
    }

    public void setjCharacter(String jCharacter) {
        this.jCharacter = jCharacter == null ? null : jCharacter.trim();
    }

    public String getJk2Name() {
        return jk2Name;
    }

    public void setJk2Name(String jk2Name) {
        this.jk2Name = jk2Name == null ? null : jk2Name.trim();
    }

    public Integer getjMlow() {
        return jMlow;
    }

    public void setjMlow(Integer jMlow) {
        this.jMlow = jMlow;
    }

    public Integer getjMhigh() {
        return jMhigh;
    }

    public void setjMhigh(Integer jMhigh) {
        this.jMhigh = jMhigh;
    }

    public String getjExperience() {
        return jExperience;
    }

    public void setjExperience(String jExperience) {
        this.jExperience = jExperience == null ? null : jExperience.trim();
    }

    public Date getjDate() {
        return jDate;
    }

    public void setjDate(Date jDate) {
        this.jDate = jDate;
    }

    public Integer getjNum() {
        return jNum;
    }

    public void setjNum(Integer jNum) {
        this.jNum = jNum;
    }

    public String getjLoc() {
        return jLoc;
    }

    public void setjLoc(String jLoc) {
        this.jLoc = jLoc == null ? null : jLoc.trim();
    }

    public String getjReq() {
        return jReq;
    }

    public void setjReq(String jReq) {
        this.jReq = jReq == null ? null : jReq.trim();
    }

    public String getjDes() {
        return jDes;
    }

    public void setjDes(String jDes) {
        this.jDes = jDes == null ? null : jDes.trim();
    }

    public String getjBenefit() {
        return jBenefit;
    }

    public void setjBenefit(String jBenefit) {
        this.jBenefit = jBenefit == null ? null : jBenefit.trim();
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }
}