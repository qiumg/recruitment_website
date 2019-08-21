package com.website.client.controller;

import com.website.client.pojo.UserJobexp;
import com.website.client.pojo.UserJobwant;
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
public class JobExpController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/jobexpcontrol")
    public String alterjobexp(HttpServletRequest request, HttpSession session) throws ParseException {
        UserJobexp userJobexp= (UserJobexp) session.getAttribute("userJobexp");
        Integer resumeId = (Integer) session.getAttribute("resumeId");
        String companyName = request.getParameter("companyName");
        String postName = request.getParameter("postName");
        String strat = request.getParameter("stratTime");
        String stop = request.getParameter("stopTime");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟
        Date stratTime=sdf.parse(strat);
        Date stopTime=sdf.parse(stop);
        Map mapInfo = new HashMap();
        mapInfo.put("resumeId", resumeId);
        mapInfo.put("companyName", companyName);
        mapInfo.put("postName", postName);
        mapInfo.put("stratTime", stratTime);
        mapInfo.put("stopTime", stopTime);
        if(userJobexp==null) {
            System.out.println(mapInfo);
            Boolean s = restTemplate.getForObject("http://PROVIDER-SERVER/jianli/addjobexp?resumeId={resumeId}&companyName={companyName}&postName={postName}&stratTime={stratTime}&stopTime={stopTime}", Boolean.class, mapInfo);
            if (s) {
                return "redirect:/user/jianli";
            } else return "/index";
        }else {
            Boolean s = restTemplate.getForObject("http://PROVIDER-SERVER/jianli/alterjobexp?resumeId={resumeId}&companyName={companyName}&postName={postName}&stratTime={stratTime}&stopTime={stopTime}", Boolean.class, mapInfo);
            if (s) {
                return "redirect:/user/jianli";
            } else return "/index";
        }
    }
}
