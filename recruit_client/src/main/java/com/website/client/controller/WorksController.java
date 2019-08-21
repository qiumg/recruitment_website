package com.website.client.controller;

import com.website.client.pojo.UserWorks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/jianli")
public class WorksController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/Workscontrol")
    public String alterProjectexp(HttpServletRequest request, HttpSession session) throws ParseException {
        UserWorks userWorks= (UserWorks) session.getAttribute("userWorks");
        Integer resumeId = (Integer) session.getAttribute("resumeId");
        String link = request.getParameter("link");
        String describe1 = request.getParameter("describe1");
        Map mapInfo = new HashMap();
        mapInfo.put("resumeId", resumeId);
        mapInfo.put("link", link);
        mapInfo.put("describe1", describe1);
        if(userWorks==null) {
            Boolean s = restTemplate.getForObject("http://PROVIDER-SERVER/jianli/addWorks?resumeId={resumeId}&link={link}&describe1={describe1}", Boolean.class, mapInfo);
            if (s) {
                return "redirect:/user/jianli";
            } else return "/index";
        }else {
            Boolean s = restTemplate.getForObject("http://PROVIDER-SERVER/jianli/alterWorks?resumeId={resumeId}&link={link}&describe1={describe1}", Boolean.class, mapInfo);
            if (s) {
                return "redirect:/user/jianli";
            } else return "/index";
        }
    }
}
