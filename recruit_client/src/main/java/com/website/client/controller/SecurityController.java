package com.website.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
    @GetMapping("/")
    public String index() {
        return "register";
    }

//    @GetMapping("/person/login")
////    public String loginPage() {
////        return "login";
////    }
}
