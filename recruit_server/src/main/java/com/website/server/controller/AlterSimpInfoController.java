package com.website.server.controller;

import com.website.server.pojo.User;
import com.website.server.pojo.UserResume;
import com.website.server.service.UserSimpleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class AlterSimpInfoController {
    @Autowired
    private UserSimpleInfoService userSimpleInfoService;


    @RequestMapping("/altername")
    public boolean altername(String newname,Integer userid) {//修改简历名
        UserResume userResume=new UserResume();
        userResume.setUserId(userid);
        userResume.setResumeName(newname);
        return userSimpleInfoService.setresumename(userResume);
    }
    @RequestMapping("/addname")
    public boolean addname(String newname,Integer userid) {//增加简历
        UserResume userResume=new UserResume();
        userResume.setUserId(userid);
        userResume.setResumeName(newname);
        return userSimpleInfoService.addresumename(userResume);
    }
    @RequestMapping("/altersimpinfo")//修改基本信息
    public boolean altersimpinfo(String name,Integer sex,Integer age,String phone,String email,Integer id) {
        User user=new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        user.setSex(sex);
        user.setPhone(phone);
        user.setEmail(email);
        return userSimpleInfoService.setuserinfo(user);
    }

    @RequestMapping("/addintroduction")//增加自我介绍
    public boolean addintroduction(String selfIntroduction,Integer id) {
        UserResume userResume=new UserResume();
        userResume.setId(id);
        userResume.setSelfIntroduction(selfIntroduction);
        return userSimpleInfoService.addintroduction(userResume);
    }
    @RequestMapping("/alterintroduction")//修改自我介绍
    public boolean alterintroduction(String selfIntroduction,Integer id) {
        UserResume userResume=new UserResume();
        userResume.setId(id);
        userResume.setSelfIntroduction(selfIntroduction);
        return userSimpleInfoService.setintroduction(userResume);
    }
}
