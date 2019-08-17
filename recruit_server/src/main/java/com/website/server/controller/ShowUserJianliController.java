package com.website.server.controller;

import com.website.server.pojo.User;
import com.website.server.pojo.UserResume;
import com.website.server.service.UserSimpleInfoService;
import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@RestController
@RequestMapping("/user")
public class ShowUserJianliController {
    @Autowired
    private UserSimpleInfoService userSimpleInfoService;

    @RequestMapping("/jianli")
    public Map getinfo(HttpSession session ){
        Map m=new HashMap();
        Integer userId= (Integer) session.getAttribute("userid");
        UserResume userResume=userSimpleInfoService.getresumeybyuid(1001);
        User userinfo=userSimpleInfoService.getuserinfo(1001);
        m.put("userResume",userResume);
        m.put("userinfo",userinfo);
        return m;
    }
}
