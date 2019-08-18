package com.website.client.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.website.client.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserSimpInfoController {
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("/jianli")
    public String getinfo(HttpSession session, ModelMap mm){//显示简历信息
        //Integer userId= (Integer) session.getAttribute("userId");
        Map m =restTemplate.getForObject("http://PROVIDER-SERVER/user/jianli1", HashMap.class);
        ObjectMapper mapper = new ObjectMapper();
        UserResume userResume  = mapper.convertValue(m.get("userResume"),UserResume.class);
        User userinfo=mapper.convertValue(m.get("userinfo"),User.class);
        session.setAttribute("resumeId",userResume.getId());
        mm.addAttribute("userResume",userResume);
        mm.addAttribute("userinfo",userinfo);

        Map mapInfo=new HashMap();
        mapInfo.put("resumeName",userResume.getResumeName());
        Map m1 =restTemplate.getForObject("http://PROVIDER-SERVER/user/jianli2?resumeName={resumeName}", HashMap.class,mapInfo);
        UserJobwant userJobwant  = mapper.convertValue(m1.get("userJobwant"),UserJobwant.class);
        session.setAttribute("userJobwant",userJobwant);
        mm.addAttribute("userJobwant",userJobwant);
        UserJobexp userJobexp  = mapper.convertValue(m1.get("userJobexp"),UserJobexp.class);
        session.setAttribute("userJobexp",userJobexp);
        mm.addAttribute("userJobexp",userJobexp);
        UserProjectexp userProjectexp  = mapper.convertValue(m1.get("userProjectexp"),UserProjectexp.class);
        session.setAttribute("userProjectexp",userProjectexp);
        mm.addAttribute("userProjectexp",userProjectexp);
        UserEducation userEducation  = mapper.convertValue(m1.get("userEducation"),UserEducation.class);
        session.setAttribute("userEducation",userJobwant);
        mm.addAttribute("userEducation",userJobwant);
        UserWorks userWorks  = mapper.convertValue(m1.get("userWorks"),UserWorks.class);
        session.setAttribute("userWorks",userJobwant);
        mm.addAttribute("userWorks",userJobwant);
        return "jianli";
    }

    @RequestMapping("/altername")
    public String altername(HttpServletRequest request){//修改简历名
        // Integer userId= (Integer) session.getAttribute("userid");
        String newname=request.getParameter("resumeName");
        Map mapInfo=new HashMap();
        mapInfo.put("newname",newname);
        mapInfo.put("userid",1001);
        Boolean s =restTemplate.getForObject("http://PROVIDER-SERVER/user/altername?newname={newname}&userid={userid}",Boolean.class,mapInfo);
        if(s){
            return "redirect:/user/jianli";
        }else return "/index";
    }

    @RequestMapping("/altersimpinfo")
    public String altersimpinfo(HttpServletRequest request){//修改用户基本信息
        // Integer userId= (Integer) session.getAttribute("userid");
        String name=request.getParameter("name");
        Integer sex=Integer.valueOf(request.getParameter("sex"));
        Integer age=Integer.valueOf(request.getParameter("age"));
        String phone=request.getParameter("phone");
        String email=request.getParameter("email");
        Map mapInfo=new HashMap();
        mapInfo.put("name",name);
        mapInfo.put("sex",sex);
        mapInfo.put("age",age);
        mapInfo.put("phone",phone);
        mapInfo.put("email",email);
        mapInfo.put("id",1001);
        Boolean s =restTemplate.getForObject("http://PROVIDER-SERVER/user/altersimpinfo?name={name}&sex={sex}&age={age}&phone={phone}&email={email}&id={id}",Boolean.class,mapInfo);
        if(s){
            return "redirect:/user/jianli";
        }else return "/index";
    }
}
