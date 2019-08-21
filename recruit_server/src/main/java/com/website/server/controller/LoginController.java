package com.website.server.controller;

import com.website.server.pojo.CompanySignLogin;
import com.website.server.pojo.User;
import com.website.server.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private ILoginService loginService;
    @RequestMapping("/login")
    public User getUser(String newemail, String pwd){
        User user = new User();
        user.setEmail(newemail);
        user.setPassword(pwd);
        return loginService.queryUserByEmail(user);

    }

    @RequestMapping("/register")
    public String setUser(String newemail, String pwd){
        User user = new User();
        user.setEmail(newemail);
        user.setPassword(pwd);
        return loginService.insertUserByEmail(user);
    }
    @RequestMapping("/clogin")
    public CompanySignLogin getCUser(String newcemail, String cpwd){
        CompanySignLogin companySignLogin=new CompanySignLogin();
        companySignLogin.setcEmail(newcemail);
        companySignLogin.setcPwd(cpwd);
        return loginService.queryComByEmail(companySignLogin);

    }

    @RequestMapping("/cregister")
    public String setCUser(String newcemail,String cpwd){
        CompanySignLogin companySignLogin=new CompanySignLogin();
        companySignLogin.setcEmail(newcemail);
        companySignLogin.setcPwd(cpwd);
        return loginService.insertComByEmail(companySignLogin);
    }
}
