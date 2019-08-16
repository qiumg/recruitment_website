package com.website.server.pojo;

public class TicketInfo {
    private Integer ticId;

    private String ticKind;

    private String ticName;

    public Integer getTicId() {
        return ticId;
    }

    public void setTicId(Integer ticId) {
        this.ticId = ticId;
    }

    public String getTicKind() {
        return ticKind;
    }

    public void setTicKind(String ticKind) {
        this.ticKind = ticKind == null ? null : ticKind.trim();
    }

    public String getTicName() {
        return ticName;
    }

    public void setTicName(String ticName) {
        this.ticName = ticName == null ? null : ticName.trim();
    }

    @Override
    public String toString() {
        return "TicketInfo{" +
                "ticId=" + ticId +
                ", ticKind='" + ticKind + '\'' +
                ", ticName='" + ticName + '\'' +
                '}';
    }
}