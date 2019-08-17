package com.website.server.controller;

import com.website.server.service.impl.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("/login.do")
    public String  login(String username, Model model,String password){
        System.out.println(username+"----"+password);
        if(username=="admin"&&password=="123456"){
            return "home";
        }else{
            model.addAttribute("msg","用户名或密码不能为空");
            return "index";
        }
    }
}
