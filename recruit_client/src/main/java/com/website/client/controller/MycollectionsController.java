package com.website.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class MycollectionsController {
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("/collections")
    public String getinfo(HttpSession session, ModelMap mm){//显示简历信息
        //Integer userId= (Integer) session.getAttribute("userId");
        Map mapInfo0 = new HashMap();
        mapInfo0.put("userId",1001);
        List<Integer> m =restTemplate.getForObject("http://PROVIDER-SERVER/user/collections?userId={userId}", List.class,mapInfo0);//得到收藏的jobid


        return "collections";
//        mm.addAttribute("m",m);
//        return "test";
    }
}
