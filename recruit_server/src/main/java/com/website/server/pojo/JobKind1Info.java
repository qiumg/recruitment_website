package com.website.server.pojo;

public class JobKind1Info {
    private Integer jk1Id;

    private String jk1Name;

    private Integer jkId;

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
}