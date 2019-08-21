package com.website.client.pojo;

import java.util.ArrayList;
import java.util.List;

public class JobKind1Info {
    private Integer jk1Id;

    private String jk1Name;

    private Integer jkId;

    private List<JobKind2Info> jobKind2Infos = new ArrayList<>();

    public List<JobKind2Info> getJobKind2Infos() {
        return jobKind2Infos;
    }

    public void setJobKind2Infos(List<JobKind2Info> jobKind2Infos) {
        this.jobKind2Infos = jobKind2Infos;
    }

    public Integer getJk1Id() {
        return jk1Id;
    }

    public void setJk1Id(Integer jk1Id) {
        this.jk1Id = jk1Id;
    }

    public String getJk1Name() {
        return jk1Name;
    }

    public void setJk1Name(String jk1Name) {
        this.jk1Name = jk1Name == null ? null : jk1Name.trim();
    }

    public Integer getJkId() {
        return jkId;
    }

    public void setJkId(Integer jkId) {
        this.jkId = jkId;
    }

    @Override
    public String toString() {
        return "JobKind1Info{" +
                "jk1Id=" + jk1Id +
                ", jk1Name='" + jk1Name + '\'' +
                ", jkId=" + jkId +
                ", jobKind2Infos=" + jobKind2Infos +
                '}';
    }
}