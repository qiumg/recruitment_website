package com.website.client.controller;

import com.website.client.pojo.UserProjectexp;
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
public class ProjectexpController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/Projectexpcontrol")
    public String alterProjectexp(HttpServletRequest request, HttpSession session) throws ParseException {
        UserProjectexp userProjectexp= (UserProjectexp) session.getAttribute("userProjectexp");
        Integer resumeId = (Integer) session.getAttribute("resumeId");
        String projectName = request.getParameter("projectName");
        String postName = request.getParameter("postName");
        String describe1 = request.getParameter("describe1");
        String strat = request.getParameter("stratTime");
        String stop = request.getParameter("stopTime");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟
        Date stratTime=sdf.parse(strat);
        Date stopTime=sdf.parse(stop);
        Map mapInfo = new HashMap();
        mapInfo.put("resumeId", resumeId);
        mapInfo.put("projectName", projectName);
        mapInfo.put("postName", postName);
        mapInfo.put("describe1", describe1);
        mapInfo.put("stratTime", stratTime);
        mapInfo.put("stopTime", stopTime);
        if(userProjectexp==null) {
            Boolean s = restTemplate.getForObject("http://PROVIDER-SERVER/jianli/addProjectexp?resumeId={resumeId}&projectName={projectName}&postName={postName}&describe1={describe1}&stratTime={stratTime}&stopTime={stopTime}", Boolean.class, mapInfo);
            if (s) {
                return "redirect:/user/jianli";
            } else return "/index";
        }else {
            Boolean s = restTemplate.getForObject("http://PROVIDER-SERVER/jianli/alterProjectexp?resumeId={resumeId}&projectName={projectName}&postName={postName}&describe1={describe1}&stratTime={stratTime}&stopTime={stopTime}", Boolean.class, mapInfo);
            if (s) {
                return "redirect:/user/jianli";
            } else return "/index";
        }
    }
}
