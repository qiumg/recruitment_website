package com.website.client.controller;

import com.website.client.pojo.UserJobwant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/jianli")
public class JobWantController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/jobwantcontrol")
    public String alterjobwant(HttpServletRequest request, HttpSession session){
        UserJobwant userJobwant= (UserJobwant) session.getAttribute("userJobwant");
            Integer resumeId = (Integer) session.getAttribute("resumeId");
            String placeWant = request.getParameter("placeWant");
            String workTypes = request.getParameter("workTypes");
            String postWant = request.getParameter("postWant");
            String salaryWant = request.getParameter("salaryWant");
            Map mapInfo = new HashMap();
            mapInfo.put("resumeId", resumeId);
            mapInfo.put("placeWant", placeWant);
            mapInfo.put("workTypes", workTypes);
            mapInfo.put("postWant", postWant);
            mapInfo.put("salaryWant", salaryWant);
        if(userJobwant==null) {
            Boolean s = restTemplate.getForObject("http://PROVIDER-SERVER/jianli/addjobwant?resumeId={resumeId}&placeWant={placeWant}&workTypes={workTypes}&postWant={postWant}&salaryWant={salaryWant}", Boolean.class, mapInfo);
            if (s) {
                return "redirect:/user/jianli";
            } else return "/index";
        }else {
            Boolean s = restTemplate.getForObject("http://PROVIDER-SERVER/jianli/alterjobwant?resumeId={resumeId}&placeWant={placeWant}&workTypes={workTypes}&postWant={postWant}&salaryWant={salaryWant}", Boolean.class, mapInfo);
            if (s) {
                return "redirect:/user/jianli";
            } else return "/index";
        }
    }
}
