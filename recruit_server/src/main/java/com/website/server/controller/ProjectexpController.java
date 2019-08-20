package com.website.server.controller;

import com.website.server.pojo.UserProjectexp;
import com.website.server.service.ProjectexpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/jianli")
public class ProjectexpController {
    @Autowired
    private ProjectexpService projectexpService;
    @RequestMapping("/addProjectexp")
    public boolean addProjectexp(Integer resumeId, String projectName, String postName, String describe1, Date stratTime, Date stopTime) {
        UserProjectexp userProjectexp=new UserProjectexp();
        userProjectexp.setResumeId(resumeId);
        userProjectexp.setProjectName(projectName);
        userProjectexp.setPostName(postName);
        userProjectexp.setDescribe1(describe1);
        userProjectexp.setStratTime(stratTime);
        userProjectexp.setStopTime(stopTime);
        return projectexpService.addProjectexp(userProjectexp);
    }

    @RequestMapping("/alterProjectexp")
    public boolean alterProjectexp(Integer resumeId, String projectName, String postName, String describe1, Date stratTime, Date stopTime) {
        UserProjectexp userProjectexp=new UserProjectexp();
        userProjectexp.setResumeId(resumeId);
        userProjectexp.setProjectName(projectName);
        userProjectexp.setPostName(postName);
        userProjectexp.setDescribe1(describe1);
        userProjectexp.setStratTime(stratTime);
        userProjectexp.setStopTime(stopTime);
        return projectexpService.alterProjectexp(userProjectexp);
    }
}
