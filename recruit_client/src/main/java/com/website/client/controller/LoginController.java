package com.website.client.controller;

import com.website.client.pojo.CompanySignLogin;
import com.website.client.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller

public class LoginController {
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("/login")
    public String getUser(HttpServletRequest request, HttpSession session) {
        String type = request.getParameter("type");

        if (type.equals("0")) {
            String newemail = request.getParameter("email");
            String pwd = request.getParameter("password");
            Map map = new HashMap();
            map.put("newemail", newemail);
            map.put("pwd", pwd);
            User s = restTemplate.getForObject("http://PROVIDER-SERVER/login?newemail={newemail}&pwd={pwd}", User.class, map);
            session.setAttribute("user", s);
            if (s != null) {
                return "index";
            } else {
                return "login";
            }
        } else {
            String newcemail=request.getParameter("email");
            String cpwd=request.getParameter("password");
            Map map=new HashMap();
            map.put("newcemail",newcemail);
            map.put("cpwd",cpwd);
            CompanySignLogin c=restTemplate.getForObject("http://PROVIDER-SERVER/clogin?newcemail={newcemail}&cpwd={cpwd}",CompanySignLogin.class,map);
            session.setAttribute("companySignLogin",c);
            if (c != null) {
                return "index01";
            } else {
                return "login";
            }
        }
    }
    @RequestMapping("/register")
    public String register(HttpServletRequest request){
        String type = request.getParameter("type");
        if (type.equals("0")){
            String newemail = request.getParameter("email");
            String pwd = request.getParameter("password");
            Map map = new HashMap();
            map.put("newemail", newemail);
            map.put("pwd", pwd);
            String s = restTemplate.getForObject("http://PROVIDER-SERVER/register?newemail={newemail}&pwd={pwd}", String.class, map);
            if (s != null) {
                return "login";
            } else {
                return "register";
            }
        }else {
            String newcemail=request.getParameter("email");
            String cpwd=request.getParameter("password");
            Map map=new HashMap();
            map.put("newcemail",newcemail);
            map.put("cpwd",cpwd);
            String c=restTemplate.getForObject("http://PROVIDER-SERVER/cregister?newcemail={newcemail}&cpwd={cpwd}",String.class,map);
            if (c != null) {
                return "login";
            } else {
                return "register";
            }
        }
    }

}
