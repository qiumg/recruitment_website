package com.website.server.controller;

import com.website.server.pojo.User;
import com.website.server.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @RequestMapping("/login")
    public String getUser(User record){
        String user = userService.queryUserByEmail(record);
        return user;
    }

    @RequestMapping("/register")
    public String setUser(User record){
        String user = userService.insertUserByEmail(record);
        return user;
    }
}
