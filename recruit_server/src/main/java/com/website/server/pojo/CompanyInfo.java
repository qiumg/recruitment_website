package com.website.server.pojo;

import java.util.Date;

public class CompanyInfo {
    private Integer cId;

    private String cName;

    private String cCtype;

    private Double cMoney;

    private Date cFdate;

    private String cAddress;

    private String cPname;

    private Integer cPhone;

    private String cFax;

    private String cHttp;

    private String cSummary;

    private String cLicense;

    private String cStatic;

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

    public String getcCtype() {
        return cCtype;
    }

    public void setcCtype(String cCtype) {
        this.cCtype = cCtype == null ? null : cCtype.trim();
    }

    public Double getcMoney() {
        return cMoney;
    }

    public void setcMoney(Double cMoney) {
        this.cMoney = cMoney;
    }

    public Date getcFdate() {
        return cFdate;
    }

    public void setcFdate(Date cFdate) {
        this.cFdate = cFdate;
    }

    public String getcAddress() {
        return cAddress;
    }

    public void setcAddress(String cAddress) {
        this.cAddress = cAddress == null ? null : cAddress.trim();
    }

    public String getcPname() {
        return cPname;
    }

    public void setcPname(String cPname) {
        this.cPname = cPname == null ? null : cPname.trim();
    }

    public Integer getcPhone() {
        return cPhone;
    }

    public void setcPhone(Integer cPhone) {
        this.cPhone = cPhone;
    }

    public String getcFax() {
        return cFax;
    }

    public void setcFax(String cFax) {
        this.cFax = cFax == null ? null : cFax.trim();
    }

    public String getcHttp() {
        return cHttp;
    }

    public void setcHttp(String cHttp) {
        this.cHttp = cHttp == null ? null : cHttp.trim();
    }

    public String getcSummary() {
        return cSummary;
    }

    public void setcSummary(String cSummary) {
        this.cSummary = cSummary == null ? null : cSummary.trim();
    }

    public String getcLicense() {
        return cLicense;
    }

    public void setcLicense(String cLicense) {
        this.cLicense = cLicense == null ? null : cLicense.trim();
    }

    public String getcStatic() {
        return cStatic;
    }

    public void setcStatic(String cStatic) {
        this.cStatic = cStatic == null ? null : cStatic.trim();
    }
}