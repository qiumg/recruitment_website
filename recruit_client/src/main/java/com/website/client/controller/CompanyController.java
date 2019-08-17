package com.website.client.controller;



import com.website.client.pojo.CompanyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Controller
public class CompanyController {
    @Autowired
    RestTemplate  restTemplate;
    @RequestMapping("/show.do")
    public String show(Model model){

        List forObject = restTemplate.getForObject(
                "http://PROVIDER-SERVER/company/compShow", List.class);
        System.out.println(forObject);
        model.addAttribute("list",forObject);
       return "tab";

    }
}
