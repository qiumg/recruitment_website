package com.website.server.pojo;

public class HrInfo {
    private Integer hrId;

    private String hrName;

    private String hrStatic;

    private Integer cId;

    public Integer getHrId() {
        return hrId;
    }

    public void setHrId(Integer hrId) {
        this.hrId = hrId;
    }

    public String getHrName() {
        return hrName;
    }

    public void setHrName(String hrName) {
        this.hrName = hrName == null ? null : hrName.trim();
    }

    public String getHrStatic() {
        return hrStatic;
    }

    public void setHrStatic(String hrStatic) {
        this.hrStatic = hrStatic == null ? null : hrStatic.trim();
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }
}