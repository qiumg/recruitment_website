package com.website.client.controller;

import com.website.client.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class SessionController {
    @RequestMapping("/companylist")
    public String companylist(HttpSession session){
        User user = (User) session.getAttribute("user");
        return "companylist";
    }

    @RequestMapping("/accountBind")
    public String accountBind(HttpSession session){
        User user = (User) session.getAttribute("user");
        return "accountBind";
    }

    @RequestMapping("/updatePwd")
    public String updatePwd(HttpSession session){
        User user = (User) session.getAttribute("user");
        return "updatePwd";
    }

    @RequestMapping("/tojianli")
    public String jianli(HttpSession session){
        User user = (User) session.getAttribute("user");
        return "jianli";
    }
}
