package com.website.client.controller;

import com.website.client.pojo.CompanyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/company")
public class CompanyInfoController {
    @Autowired
    private RestTemplate restTemplate;
    private String companyUrl;

    @RequestMapping("/insertcinfo")
    public String addcinfo(HttpServletRequest request, HttpSession session) {

        String mapCInfo1 = request.getParameter("name");
        String mapCInfo2 = request.getParameter("website");
        String mapCInfo3 = request.getParameter("city");
        Long mapCInfo4 = Long.valueOf(request.getParameter("phone"));
        String mapCInfo5 = request.getParameter("email");
        String mapCInfo6 = request.getParameter("fax");
        String mapCInfo7 = request.getParameter("type");
        String mapCInfo8 = request.getParameter("scale");
        Double mapCInfo9 = Double.valueOf((request.getParameter("money")));
        String mapCInfo10 = request.getParameter("leaderInfos[0].name");
        String mapCInfo11 = request.getParameter("leaderInfos[0].position");
        String mapCInfo12 = request.getParameter("s_radio_hidden");
        String mapCInfo13 = request.getParameter("companyProfile");

        //String mapCInfo9=request.getParameter("s_radio_hidden");

        Map mapCInfo = new HashMap();

        mapCInfo.put("cName", mapCInfo1);
        mapCInfo.put("cHttp", mapCInfo2);
        mapCInfo.put("cAddress", mapCInfo3);
        mapCInfo.put("cPhone", mapCInfo4);
        mapCInfo.put("cEmail", mapCInfo5);
        mapCInfo.put("cFax", mapCInfo6);
        mapCInfo.put("cCtype", mapCInfo7);
        mapCInfo.put("cScale", mapCInfo8);
        mapCInfo.put("cMoney", mapCInfo9);
        mapCInfo.put("cPname", mapCInfo10);
        mapCInfo.put("cPpost", mapCInfo11);
        mapCInfo.put("cStage", mapCInfo12);
        mapCInfo.put("cSummary", mapCInfo13);
        mapCInfo.put("cStatic","审核中");

        //mapCInfo.put("mapCInfo6",mapCInfo9);
        System.out.println(mapCInfo);
        Integer c = restTemplate.getForObject("http://PROVIDER-SERVER/companyInfo/addcinfo?cName={cName}&cHttp={cHttp}&cAddress={cAddress}&cPhone={cPhone}&cEmail={cEmail}&cFax={cFax}&cCtype={cCtype}&cScale={cScale}&cMoney={cMoney}&cPname={cPname}&cPpost={cPpost}&cStage={cStage}&cSummary={cSummary}&cStatic={cStatic}", Integer.class, mapCInfo);
        if (c != 0) {
            session.setAttribute("cid", c);
            session.setAttribute("cname",mapCInfo1);
            return "redirect:/company/selectCompanyInfo";
            /* return "myhome";*/
        } else return "index01";
    }

    @RequestMapping("/selectCompanyInfo")
    public String getinfo(HttpServletRequest request, ModelMap mm, HttpSession session) {
        Integer cid = (Integer) session.getAttribute("cid");
        Map m = restTemplate.getForObject("http://PROVIDER-SERVER/companyInfo/selectbycid?cid=" + cid, HashMap.class);
        ObjectMapper mapper = new ObjectMapper();
        CompanyInfo companyInfo = mapper.convertValue(m.get("CompanyInfo"), CompanyInfo.class);
        System.out.println(companyInfo);
        mm.addAttribute("companyInfo", companyInfo);

        return "myhome";
    }

    @RequestMapping("/updatecominfo")
    public String updatecinfo(HttpServletRequest request, HttpSession session) {
        Integer cid = (Integer) session.getAttribute("cid");
        /* String mapCInfo1=request.getParameter("name");*/
        String mapCInfo2 = request.getParameter("companyUrl");
        String mapCInfo3 = request.getParameter("city");
        System.out.println(request.getParameter("cphone"));
        Long mapCInfo4 = null;
        if (request.getParameter("cphone") != null) {
            mapCInfo4 = Long.valueOf(request.getParameter("cphone"));
        }
        String mapCInfo5 = request.getParameter("cemail");
        String mapCInfo6 = request.getParameter("comfax");
        String mapCInfo7 = request.getParameter("ctyle");
        String mapCInfo8 = request.getParameter("companySize");

        Double mapCInfo9=null;
        if (request.getParameter("money")!=null){
            mapCInfo9 = Double.valueOf(request.getParameter("money"));
        }

        /*String mapCInfo10=request.getParameter("leaderInfos[0].name");
        String mapCInfo11 =request.getParameter("leaderInfos[0].position");*/
        String mapCInfo12 = request.getParameter("s_radio_hidden");
        String mapCInfo13 = request.getParameter("companyProfile");

        //String mapCInfo9=request.getParameter("s_radio_hidden");

        Map mapCInfo = new HashMap();
        mapCInfo.put("cId", cid);
/*
        mapCInfo.put("cName",mapCInfo1);
*/
        mapCInfo.put("cHttp", mapCInfo2);
        mapCInfo.put("cAddress", mapCInfo3);
        mapCInfo.put("cPhone", mapCInfo4);
        mapCInfo.put("cEmail", mapCInfo5);
        mapCInfo.put("cFax", mapCInfo6);
        mapCInfo.put("cCtype", mapCInfo7);
        mapCInfo.put("cScale", mapCInfo8);
        mapCInfo.put("cMoney", mapCInfo9);
      /*  mapCInfo.put("cPname",mapCInfo10);
        mapCInfo.put("cPpost",mapCInfo11);*/
        mapCInfo.put("cStage", mapCInfo12);
        mapCInfo.put("cSummary", mapCInfo13);

        //mapCInfo.put("mapCInfo6",mapCInfo9);
        System.out.println(mapCInfo);
        Boolean c = restTemplate.getForObject("http://PROVIDER-SERVER/companyInfo/updatecinfo?cId={cId}&cHttp={cHttp}&cAddress={cAddress}&cPhone={cPhone}&cEmail={cEmail}&cFax={cFax}&cCtype={cCtype}&cScale={cScale}&cMoney={cMoney}&cStage={cStage}&cSummary={cSummary}", Boolean.class, mapCInfo);
        if (c) {
            return "redirect:/company/selectCompanyInfo";
            /* return "index01";*/
        } else return "index01";
    }
}
