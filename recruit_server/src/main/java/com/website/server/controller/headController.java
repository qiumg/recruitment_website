package com.website.server.controller;

import com.website.server.pojo.User;
import com.website.server.service.UserSimpleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user1")
public class headController {
    @Autowired
    private UserSimpleInfoService userSimpleInfoService;
    @RequestMapping("/uploadhead")
    public boolean uploadhead(Integer id, String headPortrait) {
        User user=new User();
        user.setId(id);
        user.setHeadPortrait(headPortrait);
        return userSimpleInfoService.setuserinfo(user);
    }
}
