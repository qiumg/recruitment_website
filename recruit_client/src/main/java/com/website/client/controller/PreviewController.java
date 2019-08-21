package com.website.client.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.website.client.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/view")
public class PreviewController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/jianli")
    public String getinfo(HttpSession session, ModelMap mm) {//显示简历信息
        //Integer userId= (Integer) session.getAttribute("userId");
        Integer resumeId = (Integer) session.getAttribute("resumeId");
        Map mapInfo = new HashMap();
        mapInfo.put("resumeId", resumeId);
        mapInfo.put("userId", 1001);
        Map m1 = restTemplate.getForObject("http://PROVIDER-SERVER/user/jianli2?resumeId={resumeId}&userId={userId}", HashMap.class, mapInfo);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        ObjectMapper mapper = new ObjectMapper();
        User userinfo = mapper.convertValue(m1.get("userinfo"), User.class);//基本
        mm.addAttribute("userinfo", userinfo);
        if (null != userinfo.getHeadPortrait() && !userinfo.getHeadPortrait().equals("")) {
            String showurl = "/style/images/" + userinfo.getHeadPortrait();
            mm.addAttribute("showurl", showurl);
        }
        UserJobwant userJobwant = mapper.convertValue(m1.get("userJobwant"), UserJobwant.class);//2期望
        if (null != userJobwant) {
            mm.addAttribute("userJobwant", userJobwant);
        }
        UserJobexp userJobexp = mapper.convertValue(m1.get("userJobexp"), UserJobexp.class);//工作经验
        if (null != userJobexp) {
            mm.addAttribute("userJobexp", userJobexp);
            String jobstarttime = format.format(userJobexp.getStratTime());
            String jobstoptime = format.format(userJobexp.getStopTime());
            mm.addAttribute("jobstarttime", jobstarttime);
            mm.addAttribute("jobstoptime", jobstoptime);
        }
        UserProjectexp userProjectexp = mapper.convertValue(m1.get("userProjectexp"), UserProjectexp.class);//项目
        if (null != userProjectexp) {
            mm.addAttribute("userProjectexp", userProjectexp);
            String Projectstarttime = format.format(userProjectexp.getStratTime());
            String Projectstoptime = format.format(userProjectexp.getStopTime());
            mm.addAttribute("Projectstarttime", Projectstarttime);
            mm.addAttribute("Projectstoptime", Projectstoptime);
        }
        UserEducation userEducation = mapper.convertValue(m1.get("userEducation"), UserEducation.class);//教育
        if (null != userEducation) {
            mm.addAttribute("userEducation", userEducation);
        }
        UserWorks userWorks = mapper.convertValue(m1.get("userWorks"), UserWorks.class);//作品
        if (null != userWorks) {
            mm.addAttribute("userWorks", userWorks);
        }
        UserResume userResume = mapper.convertValue(m1.get("userResume"), UserResume.class);//简历
        if (null != userResume.getSelfIntroduction()&&!userResume.getSelfIntroduction().equals("")) {
            mm.addAttribute("SelfIntroduction", userResume.getSelfIntroduction());
        }
        return "preview";
    }
}
