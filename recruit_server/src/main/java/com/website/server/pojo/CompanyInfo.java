package com.website.server.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompanyInfo {
    private Integer cId;

    private String cName;

    private String cCtype;

    private Double cMoney;

    private Date cFdate;

    private String cAddress;

    private String cPname;

    private Long cPhone;

    private String cFax;

    private String cHttp;

    private String cSummary;

    private String cLicense;

    private String cLogo;

    private String cScale;

    private String cPpost;

    private String cStage;

    private String cEmail;

    private String cStatic;

    private List<TicketInfo> ticketInfos = new ArrayList<>();

    public List<TicketInfo> getTicketInfos() {
        return ticketInfos;
    }

    public void setTicketInfos(List<TicketInfo> ticketInfos) {
        this.ticketInfos = ticketInfos;
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

    public Long getcPhone() {
        return cPhone;
    }

    public void setcPhone(Long cPhone) {
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

    public String getcLogo() {
        return cLogo;
    }

    public void setcLogo(String cLogo) {
        this.cLogo = cLogo == null ? null : cLogo.trim();
    }

    public String getcScale() {
        return cScale;
    }

    public void setcScale(String cScale) {
        this.cScale = cScale == null ? null : cScale.trim();
    }

    public String getcPpost() {
        return cPpost;
    }

    public void setcPpost(String cPpost) {
        this.cPpost = cPpost == null ? null : cPpost.trim();
    }

    public String getcStage() {
        return cStage;
    }

    public void setcStage(String cStage) {
        this.cStage = cStage == null ? null : cStage.trim();
    }

    public String getcEmail() {
        return cEmail;
    }

    public void setcEmail(String cEmail) {
        this.cEmail = cEmail == null ? null : cEmail.trim();
    }

    public String getcStatic() {
        return cStatic;
    }

    public void setcStatic(String cStatic) {
        this.cStatic = cStatic == null ? null : cStatic.trim();
    }
}