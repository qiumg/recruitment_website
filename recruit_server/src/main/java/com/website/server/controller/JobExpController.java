package com.website.server.controller;

import com.website.server.pojo.UserJobexp;
import com.website.server.service.JobExpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/jianli")
public class JobExpController {
    @Autowired
    private JobExpService jobExpService;

    @RequestMapping("/addjobexp")
    public boolean addjobexp(Integer resumeId, String companyName, String postName, Date stratTime, Date stopTime) {
        UserJobexp userJobexp=new UserJobexp();
        userJobexp.setResumeId(resumeId);
        userJobexp.setCompanyName(companyName);
        userJobexp.setPostName(postName);
        userJobexp.setStratTime(stratTime);
        userJobexp.setStopTime(stopTime);
        System.out.println(userJobexp);
        return jobExpService.addJobexp(userJobexp);
    }

    @RequestMapping("/alterjobexp")
    public boolean alterjobexp(Integer resumeId, String companyName, String postName, Date stratTime, Date stopTime) {
        UserJobexp userJobexp=new UserJobexp();
        userJobexp.setResumeId(resumeId);
        userJobexp.setCompanyName(companyName);
        userJobexp.setPostName(postName);
        userJobexp.setStratTime(stratTime);
        userJobexp.setStopTime(stopTime);
        return jobExpService.alterJobexp(userJobexp);
    }
}
