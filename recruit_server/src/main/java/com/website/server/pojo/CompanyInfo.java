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
    private Date beginTime;
    private Date endTime;

    public CompanyInfo(String cName, String cCtype, String cAddress, String cPname, Date beginTime, Date endTime) {
        this.cName = cName;
        this.cCtype = cCtype;
        this.cAddress = cAddress;
        this.cPname = cPname;
        this.beginTime = beginTime;
        this.endTime = endTime;
    }

    public CompanyInfo() {
    }

    public CompanyInfo(Integer cId, String cName, String cCtype, Double cMoney, Date cFdate, String cAddress, String cPname, Integer cPhone, String cFax, String cHttp, String cSummary, String cLicense, String cStatic, Date beginTime, Date endTime) {
        this.cId = cId;
        this.cName = cName;
        this.cCtype = cCtype;
        this.cMoney = cMoney;
        this.cFdate = cFdate;
        this.cAddress = cAddress;
        this.cPname = cPname;
        this.cPhone = cPhone;
        this.cFax = cFax;
        this.cHttp = cHttp;
        this.cSummary = cSummary;
        this.cLicense = cLicense;
        this.cStatic = cStatic;
        this.beginTime = beginTime;
        this.endTime = endTime;
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
        this.cName = cName;
    }

    public String getcCtype() {
        return cCtype;
    }

    public void setcCtype(String cCtype) {
        this.cCtype = cCtype;
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
        this.cAddress = cAddress;
    }

    public String getcPname() {
        return cPname;
    }

    public void setcPname(String cPname) {
        this.cPname = cPname;
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
        this.cFax = cFax;
    }

    public String getcHttp() {
        return cHttp;
    }

    public void setcHttp(String cHttp) {
        this.cHttp = cHttp;
    }

    public String getcSummary() {
        return cSummary;
    }

    public void setcSummary(String cSummary) {
        this.cSummary = cSummary;
    }

    public String getcLicense() {
        return cLicense;
    }

    public void setcLicense(String cLicense) {
        this.cLicense = cLicense;
    }

    public String getcStatic() {
        return cStatic;
    }

    public void setcStatic(String cStatic) {
        this.cStatic = cStatic;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "CompanyInfo{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                ", cCtype='" + cCtype + '\'' +
                ", cMoney=" + cMoney +
                ", cFdate=" + cFdate +
                ", cAddress='" + cAddress + '\'' +
                ", cPname='" + cPname + '\'' +
                ", cPhone=" + cPhone +
                ", cFax='" + cFax + '\'' +
                ", cHttp='" + cHttp + '\'' +
                ", cSummary='" + cSummary + '\'' +
                ", cLicense='" + cLicense + '\'' +
                ", cStatic='" + cStatic + '\'' +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                '}';
    }
}