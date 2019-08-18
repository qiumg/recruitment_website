package com.website.server.controller;

import com.website.server.pojo.User;
import com.website.server.service.UserSimpleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class alteruserinfocontroller {

    @Autowired
    private UserSimpleInfoService userSimpleInfoService;

    @RequestMapping("/altersimpinfo")
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
