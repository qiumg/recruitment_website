package com.website.server.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class JobInfo {

    private Integer jId;

    private String jName;

    private String jCharacter;

    private String jk2Name;

    private Integer jMlow;

    private Integer jMhigh;

    private String jExperience;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date jDate;

    private Integer jNum;

    private String jLoc;

    private String jReq;

    private String jDes;

    private String jBenefit;

    private Integer cId;

    private Set<JobKindInfo>  JKSet=  new HashSet<>();
    private Set<JobKind1Info> JK1Set=  new HashSet<>();
    private Set<JobKind2Info> JK2Set=  new HashSet<>();

    public JobInfo() {
    }

    public JobInfo(Integer jId, String jName, String jCharacter, String jk2Name, Integer jMlow, Integer jMhigh, String jExperience, Date jDate, Integer jNum, String jLoc, String jReq, String jDes, String jBenefit, Integer cId) {
        this.jId = jId;
        this.jName = jName;
        this.jCharacter = jCharacter;
        this.jk2Name = jk2Name;
        this.jMlow = jMlow;
        this.jMhigh = jMhigh;
        this.jExperience = jExperience;
        this.jDate = jDate;
        this.jNum = jNum;
        this.jLoc = jLoc;
        this.jReq = jReq;
        this.jDes = jDes;
        this.jBenefit = jBenefit;
        this.cId = cId;
    }

    public JobInfo(Integer jId, String jName, String jCharacter, String jk2Name, Integer jMlow, Integer jMhigh, String jExperience, Date jDate, Integer jNum, String jLoc, String jReq, String jDes, String jBenefit, Integer cId, Set<JobKindInfo> JKSet, Set<JobKind1Info> JK1Set, Set<JobKind2Info> JK2Set) {
        this.jId = jId;
        this.jName = jName;
        this.jCharacter = jCharacter;
        this.jk2Name = jk2Name;
        this.jMlow = jMlow;
        this.jMhigh = jMhigh;
        this.jExperience = jExperience;
        this.jDate = jDate;
        this.jNum = jNum;
        this.jLoc = jLoc;
        this.jReq = jReq;
        this.jDes = jDes;
        this.jBenefit = jBenefit;
        this.cId = cId;
        this.JKSet = JKSet;
        this.JK1Set = JK1Set;
        this.JK2Set = JK2Set;
    }



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

    @Override
    public String toString() {
        return "JobInfo{" +
                "jId=" + jId +
                ", jName='" + jName + '\'' +
                ", jCharacter='" + jCharacter + '\'' +
                ", jk2Name='" + jk2Name + '\'' +
                ", jMlow=" + jMlow +
                ", jMhigh=" + jMhigh +
                ", jExperience='" + jExperience + '\'' +
                ", jDate=" + jDate +
                ", jNum=" + jNum +
                ", jLoc='" + jLoc + '\'' +
                ", jReq='" + jReq + '\'' +
                ", jDes='" + jDes + '\'' +
                ", jBenefit='" + jBenefit + '\'' +
                ", cId=" + cId +
                ", JKSet=" + JKSet +
                ", JK1Set=" + JK1Set +
                ", JK2Set=" + JK2Set +
                '}';
    }
}