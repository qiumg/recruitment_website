package com.website.server.controller;

import com.website.server.pojo.UserResume;
import com.website.server.service.UserSimpleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class alterjianlinamecontroller {
    @Autowired
    private UserSimpleInfoService userSimpleInfoService;

    @RequestMapping("/altername")
    public boolean altername(String newname,Integer userid) {
        UserResume userResume=new UserResume();
        userResume.setUserId(userid);
        userResume.setResumeName(newname);
        return userSimpleInfoService.setresumename(userResume);
    }
}
