package com.website.client.pojo;

public class JobKindInfo {
    private Integer jkId;

    private String jkName;

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
}