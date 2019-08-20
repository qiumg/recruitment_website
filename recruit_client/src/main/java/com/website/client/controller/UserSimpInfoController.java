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
import java.text.SimpleDateFormat;
import java.util.Date;
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
        UserResume userResume  = mapper.convertValue(m.get("userResume"),UserResume.class);//简历
        if(null!=userResume) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String lasttime = format.format(userResume.getModifyTime());
            session.setAttribute("resumeId", userResume.getId());
            if(null!=userResume.getSelfIntroduction()&&!userResume.getSelfIntroduction().equals("")) {
            String selfIntroduction = userResume.getSelfIntroduction();
            selfIntroduction = selfIntroduction.substring(0, 10);
            session.setAttribute("selfIntroduction", selfIntroduction);
            mm.addAttribute("selfIntroduction", selfIntroduction);
            }
            mm.addAttribute("userResume", userResume);
            mm.addAttribute("lasttime", lasttime);

            Map mapInfo = new HashMap();
            mapInfo.put("resumeId", userResume.getId());
            Map m1 = restTemplate.getForObject("http://PROVIDER-SERVER/user/jianli2?resumeId={resumeId}", HashMap.class, mapInfo);
            User userinfo = mapper.convertValue(m1.get("userinfo"), User.class);//基本
            session.setAttribute("userinfo", userinfo);
            mm.addAttribute("userinfo", userinfo);
            if (null != userinfo.getHeadPortrait()&&!userinfo.getHeadPortrait().equals("")) {
            String showurl="/style/images/"+userinfo.getHeadPortrait();
            mm.addAttribute("showurl", showurl);
            }
            UserJobwant userJobwant = mapper.convertValue(m1.get("userJobwant"), UserJobwant.class);//2期望
            session.setAttribute("userJobwant", userJobwant);
            mm.addAttribute("userJobwant", userJobwant);
            UserJobexp userJobexp = mapper.convertValue(m1.get("userJobexp"), UserJobexp.class);//工作经验
            if (null != userJobexp) {
                session.setAttribute("userJobexp", userJobexp);
                mm.addAttribute("userJobexp", userJobexp);
                String jobstarttime = format.format(userJobexp.getStratTime());
                String jobstoptime = format.format(userJobexp.getStopTime());
                mm.addAttribute("jobstarttime", jobstarttime);
                mm.addAttribute("jobstoptime", jobstoptime);
            }
            UserProjectexp userProjectexp = mapper.convertValue(m1.get("userProjectexp"), UserProjectexp.class);//项目
            if (null != userProjectexp) {
                session.setAttribute("userProjectexp", userProjectexp);
                mm.addAttribute("userProjectexp", userProjectexp);
                String Projectstarttime = format.format(userProjectexp.getStratTime());
                String Projectstoptime = format.format(userProjectexp.getStopTime());
                mm.addAttribute("Projectstarttime", Projectstarttime);
                mm.addAttribute("Projectstoptime", Projectstoptime);
            }
            UserEducation userEducation = mapper.convertValue(m1.get("userEducation"), UserEducation.class);//教育
            if (null != userEducation) {
                session.setAttribute("userEducation", userEducation);
                mm.addAttribute("userEducation", userEducation);
            }
            UserWorks userWorks = mapper.convertValue(m1.get("userWorks"), UserWorks.class);//作品
            if (null != userWorks) {
                session.setAttribute("userWorks", userWorks);
                mm.addAttribute("userWorks", userWorks);
            }
            return "jianli";
        }else
        return "jianli";
    }

    @RequestMapping("/altername")
    public String altername(HttpServletRequest request,HttpSession session){//修改简历名
        // Integer userId= (Integer) session.getAttribute("userid");
        Integer resumeId= (Integer) session.getAttribute("resumeId");
        String newname=request.getParameter("resumeName");
        Map mapInfo=new HashMap();
        mapInfo.put("newname",newname);
        mapInfo.put("userid",1001);
        if(resumeId!=null){
        Boolean s =restTemplate.getForObject("http://PROVIDER-SERVER/user/altername?newname={newname}&userid={userid}",Boolean.class,mapInfo);
        if(s){
            return "redirect:/user/jianli";
        }else return "/index";
        } else {
            Boolean s =restTemplate.getForObject("http://PROVIDER-SERVER/user/addname?newname={newname}&userid={userid}",Boolean.class,mapInfo);
            if(s){
                return "redirect:/user/jianli";
            }else return "/index";
        }
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

    @RequestMapping("/alterintroduction")
    public String alterIntroduction(HttpServletRequest request,HttpSession session){//修改自我介绍
        String selfIntroduction= (String) session.getAttribute("selfIntroduction");
        Integer id = (Integer) session.getAttribute("resumeId");
        String Introduction = request.getParameter("selfIntroduction");
        Map mapInfo = new HashMap();
        mapInfo.put("id", id);
        mapInfo.put("selfIntroduction", Introduction);
        if(selfIntroduction==null) {
            Boolean s = restTemplate.getForObject("http://PROVIDER-SERVER/user/addintroduction?id={id}&selfIntroduction={selfIntroduction}", Boolean.class, mapInfo);
            if (s) {
                return "redirect:/user/jianli";
            } else return "/index";
        }else {
            Boolean s = restTemplate.getForObject("http://PROVIDER-SERVER/user/alterintroduction?id={id}&selfIntroduction={selfIntroduction}", Boolean.class, mapInfo);
            if (s) {
                return "redirect:/user/jianli";
            } else return "/index";
        }
    }
}
