package com.website.server.controller;

import com.website.server.pojo.CompanyInfo;
import com.website.server.service.impl.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    @RequestMapping("/compShow")
    public List<CompanyInfo> show(Model model){
        List<CompanyInfo> list = companyService.show();
        return list;

    }
}
