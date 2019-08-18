package com.website.server.controller;

import com.website.server.pojo.UserJobwant;
import com.website.server.service.JobWantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jianli")
public class JobWantConctroller {
    @Autowired
    private JobWantService jobWantService;

    @RequestMapping("/addjobwant")
    public boolean addjobwant(Integer resumeId,String salaryWant,String placeWant,String postWant, String workTypes) {
        UserJobwant userJobwant=new UserJobwant();
        userJobwant.setResumeId(resumeId);
        userJobwant.setSalaryWant(salaryWant);
        userJobwant.setPlaceWant(placeWant);
        userJobwant.setPostWant(postWant);
        userJobwant.setWorkTypes(workTypes);
        return jobWantService.addJobwant(userJobwant);
    }

    @RequestMapping("/alterjobwant")
    public boolean alterjobwant(Integer resumeId,String salaryWant,String placeWant,String postWant, String workTypes) {
        UserJobwant userJobwant=new UserJobwant();
        userJobwant.setResumeId(resumeId);
        userJobwant.setSalaryWant(salaryWant);
        userJobwant.setPlaceWant(placeWant);
        userJobwant.setPostWant(postWant);
        userJobwant.setWorkTypes(workTypes);
        return jobWantService.alterJobwant(userJobwant);
    }
}
