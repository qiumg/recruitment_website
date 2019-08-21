package com.website.client.controller;

import com.website.client.pojo.UserEducation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/jianli")
public class EducationController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/Educationcontrol")
    public String alterProjectexp(HttpServletRequest request, HttpSession session) throws ParseException {
        UserEducation userEducation= (UserEducation) session.getAttribute("userEducation");
        Integer resumeId = (Integer) session.getAttribute("resumeId");
        String university = request.getParameter("university");
        String education = request.getParameter("education");
        String major = request.getParameter("major");
        String strat = request.getParameter("stratTime");
        String stop = request.getParameter("stopTime");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟
        Date stratTime=sdf.parse(strat);
        Date stopTime=sdf.parse(stop);
        Map mapInfo = new HashMap();
        mapInfo.put("resumeId", resumeId);
        mapInfo.put("university", university);
        mapInfo.put("education", education);
        mapInfo.put("major", major);
        mapInfo.put("stratTime", stratTime);
        mapInfo.put("stopTime", stopTime);
        if(userEducation==null) {
            Boolean s = restTemplate.getForObject("http://PROVIDER-SERVER/jianli/addEducation?resumeId={resumeId}&university={university}&education={education}&major={major}&stratTime={stratTime}&stopTime={stopTime}", Boolean.class, mapInfo);
            if (s) {
                return "redirect:/user/jianli";
            } else return "/index";
        }else {
            Boolean s = restTemplate.getForObject("http://PROVIDER-SERVER/jianli/alterEducation?resumeId={resumeId}&university={university}&education={education}&major={major}&stratTime={stratTime}&stopTime={stopTime}", Boolean.class, mapInfo);
            if (s) {
                return "redirect:/user/jianli";
            } else return "/index";
        }
    }
}
