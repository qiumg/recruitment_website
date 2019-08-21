package com.website.client.controller;

import com.website.client.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController{
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("/login")
    public String getUser(HttpServletRequest request, HttpSession session) throws IOException {
        String type = request.getParameter("type");
        System.out.println(type);
        if (type.equals("0")) {
            String newemail = request.getParameter("email");
            System.out.println(newemail);
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
            return null;
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
            return null;
        }
    }
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        return "login";
    }

    @RequestMapping("/update")
    public String updatePwd(){
        return "login";
    }
}
