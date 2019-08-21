package com.website.server.pojo;

public class JobKind2Info {
    private Integer jk2Id;

    private String jk2Name;

    private Integer jk1Id;

    public Integer getJk2Id() {
        return jk2Id;
    }

    public void setJk2Id(Integer jk2Id) {
        this.jk2Id = jk2Id;
    }

    public String getJk2Name() {
        return jk2Name;
    }

    public void setJk2Name(String jk2Name) {
        this.jk2Name = jk2Name == null ? null : jk2Name.trim();
    }

    public Integer getJk1Id() {
        return jk1Id;
    }

    public void setJk1Id(Integer jk1Id) {
        this.jk1Id = jk1Id;
    }

    @Override
    public String toString() {
        return "JobKind2Info{" +
                "jk2Id=" + jk2Id +
                ", jk2Name='" + jk2Name + '\'' +
                ", jk1Id=" + jk1Id +
                '}';
    }
}