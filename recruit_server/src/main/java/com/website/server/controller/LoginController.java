package com.website.server.controller;

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
        int length = newemail.length();
        String name = newemail.substring(0,length-7);
        user.setEmail(newemail);
        user.setPassword(pwd);
        user.setName(name);
        return loginService.insertUserByEmail(user);
    }
    @RequestMapping("/updatePwd")
    public int updateUser(String email,String password){
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        loginService.updatePassword(user);
        return 1;
    }
    @RequestMapping("/updatePassword")
    public int updatePassword(String email,String oldpassword,String newpassword){
        User user = new User();
        user.setEmail(email);
        user.setPassword(oldpassword);
        user.setNewPassword(newpassword);
        return loginService.updatePwd(user);
    }
}
