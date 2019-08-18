package com.website.client.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.website.client.pojo.User;
import com.website.client.pojo.UserResume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("/jianli")
    public String getinfo(HttpServletRequest request,ModelMap mm){
        Map m =restTemplate.getForObject("http://PROVIDER-SERVER/user/jianli", HashMap.class);
        ObjectMapper mapper = new ObjectMapper();
        UserResume userResume  = mapper.convertValue(m.get("userResume"),UserResume.class);
        User userinfo=mapper.convertValue(m.get("userinfo"),User.class);
        mm.addAttribute("userResume",userResume);
        mm.addAttribute("userinfo",userinfo);
        return "jianli";
    }

    @RequestMapping("/altername")
    public String altername(HttpServletRequest request){
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
    public String altersimpinfo(HttpServletRequest request){
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
