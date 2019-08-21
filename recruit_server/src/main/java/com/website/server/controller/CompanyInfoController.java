package com.website.server.controller;

import com.website.server.pojo.CompanyInfo;

import com.website.server.service.ICompanyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/companyInfo")
public class CompanyInfoController {
    @Autowired
    private ICompanyInfoService iCompanyInfoService;
    @RequestMapping("/addcinfo")
    public int addinfo(HttpSession session, String cName, String cCtype, Double cMoney, String cAddress, String cPname, Long cPhone, String cFax, String cHttp, String cSummary, String cScale, String cPpost, String cStage, String cEmail) {

        CompanyInfo companyInfo = new CompanyInfo();

        companyInfo.setcName(cName);
        companyInfo.setcCtype(cCtype);
        companyInfo.setcMoney(cMoney);
       /* companyInfo.setcFdate(cFdate);*/
        companyInfo.setcAddress(cAddress);
        companyInfo.setcPname(cPname);
        companyInfo.setcPhone(cPhone);
        companyInfo.setcFax(cFax);
        companyInfo.setcHttp(cHttp);
        companyInfo.setcSummary(cSummary);
        companyInfo.setcScale(cScale);
        companyInfo.setcPpost(cPpost);
        companyInfo.setcStage(cStage);
        companyInfo.setcEmail(cEmail);
        System.out.println(companyInfo);
        return iCompanyInfoService.addCompanyInfo(companyInfo);
    }


    @RequestMapping("/selectbycid")
    public Map getcinfo(HttpSession session, Integer cid){
        Map map=new HashMap();
//        Integer cId= (Integer) session.getAttribute("cid");
        CompanyInfo comid=iCompanyInfoService.getCompanybycid(cid);
        System.out.println(comid);
        map.put("CompanyInfo",comid);

        return map;
    }

    @RequestMapping("/updatecinfo")
    public boolean updatecinfo(HttpSession session,Integer cId, String cCtype, Double cMoney, String cAddress, Long cPhone, String cFax, String cHttp,String cSummary, String cScale,String cStage, String cEmail) {

        CompanyInfo companyInfo = new CompanyInfo();

       /* companyInfo.setcName(cName);*/
        companyInfo.setcId(cId);
        System.out.println(cId);
        companyInfo.setcCtype(cCtype);
        companyInfo.setcMoney(cMoney);
        /* companyInfo.setcFdate(cFdate);*/
        companyInfo.setcAddress(cAddress);
       /* companyInfo.setcPname(cPname);*/
        companyInfo.setcPhone(cPhone);
        companyInfo.setcFax(cFax);
        companyInfo.setcHttp(cHttp);
        companyInfo.setcSummary(cSummary);
        companyInfo.setcScale(cScale);
        /*companyInfo.setcPpost(cPpost);*/
        companyInfo.setcStage(cStage);
        companyInfo.setcEmail(cEmail);
        System.out.println(companyInfo);
        return iCompanyInfoService.updateCompany(companyInfo);
    }
    }
