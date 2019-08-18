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
public class AlterSimpInfoController {//修改简历名
    @Autowired
    private UserSimpleInfoService userSimpleInfoService;

    @RequestMapping("/altername")
    public boolean altername(String newname,Integer userid) {
        UserResume userResume=new UserResume();
        userResume.setUserId(userid);
        userResume.setResumeName(newname);
        return userSimpleInfoService.setresumename(userResume);
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
}
