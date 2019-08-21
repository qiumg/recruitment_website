package com.website.client.pojo;

import java.util.ArrayList;
import java.util.List;


public class JobKindInfo {
    private Integer jkId;

    private String jkName;

    private List<JobKind1Info> jobKind1Infos= new ArrayList<>();

    public List<JobKind1Info> getJobKind1Infos() {
        return jobKind1Infos;
    }

    public void setJobKind1Infos(List<JobKind1Info> jobKind1Infos) {
        this.jobKind1Infos = jobKind1Infos;
    }

    public Integer getJkId() {
        return jkId;
    }

    public void setJkId(Integer jkId) {
        this.jkId = jkId;
    }

    public String getJkName() {
        return jkName;
    }

    public void setJkName(String jkName) {
        this.jkName = jkName == null ? null : jkName.trim();
    }

    @Override
    public String toString() {
        return "JobKindInfo{" +
                "jkId=" + jkId +
                ", jkName='" + jkName + '\'' +
                ", jobKind1Infos=" + jobKind1Infos +
                '}';
    }
}