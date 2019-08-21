package com.website.client.controller;

import com.website.client.pojo.Result;
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
public class ResetController {
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("/reset1")
    public String reset1(HttpServletRequest request,HttpSession session){
        String email = request.getParameter("email");
        System.out.println("2----"+email);
        session.setAttribute("email",email);
        return "reset02";
    }
    @RequestMapping("/reset3")
    public String reset2(HttpServletRequest request){
        String password1 = request.getParameter("password1");
        System.out.println(password1);
        String password2 = request.getParameter("password2");
        System.out.println(password2);
        String email = request.getParameter("email");
        System.out.println("6----"+email);
        if (password1.equals(password2)){
            Map map = new HashMap();
            map.put("email",email);
            map.put("password",password1);
            int i = restTemplate.getForObject("http://PROVIDER-SERVER/updatePwd?email={email}&password={password}", int.class, map);
            if (i == 1){
                return "login";
            }else {
                return "reset03";
            }
        }else {
            return "reset03";
        }
    }
    @RequestMapping("/reset2")
    public String reset3(HttpServletRequest request,HttpSession session){
        String email = request.getParameter("email");
        System.out.println("4----"+email);
        session.setAttribute("email",email);
        return "reset03";
    }
}
