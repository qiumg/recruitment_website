package com.website.server.pojo;

import lombok.Data;

@Data
public class CompanySignLogin {
    private Integer cId;

    private String cName;

    private String cPwd;

    private String cEmail;

    private String cState;

    public CompanySignLogin() {
    }

    public CompanySignLogin(String cPwd, String cEmail) {
        this.cPwd = cPwd;
        this.cEmail = cEmail;
    }

    public String getcState() {
        return cState;
    }

    public void setcState(String cState) {
        this.cState = cState;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public String getcPwd() {
        return cPwd;
    }

    public void setcPwd(String cPwd) {
        this.cPwd = cPwd == null ? null : cPwd.trim();
    }

    public String getcEmail() {
        return cEmail;
    }

    public void setcEmail(String cEmail) {
        this.cEmail = cEmail == null ? null : cEmail.trim();
    }
}