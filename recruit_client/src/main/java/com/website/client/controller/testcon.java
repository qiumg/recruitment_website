package com.website.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class testcon {
    @RequestMapping("/test")
    public String test11(HttpServletRequest request, ModelMap mm){
        String s=request.getParameter("selfDescription");
        mm.addAttribute("s",s);
        return "test";
    }
}
