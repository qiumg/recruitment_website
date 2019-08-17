package com.website.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping("/login.do")
    public  String  login(String username, Model model,String password){
        System.out.println(username+"----"+password);
        if("admin".equals(username)&&"123456".equals(password)){
            System.out.println("chenggong");
            return "home";
        }else{
            System.out.println("失败");
            model.addAttribute("msg","用户名或密码不能为空");
            return "index";
        }
    }
}
