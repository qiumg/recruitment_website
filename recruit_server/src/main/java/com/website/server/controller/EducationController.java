package com.website.server.controller;


import com.website.server.pojo.UserEducation;
import com.website.server.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/jianli")
public class EducationController {
    @Autowired
    private EducationService educationService;
    @RequestMapping("/addEducation")
    public boolean addEducation(Integer resumeId, String university, String education, String major, Date stratTime, Date stopTime) {
        UserEducation userEducation=new UserEducation();
        userEducation.setResumeId(resumeId);
        userEducation.setUniversity(university);
        userEducation.setEducation(education);
        userEducation.setMajor(major);
        userEducation.setStratTime(stratTime);
        userEducation.setStopTime(stopTime);
        return educationService.addUseredu(userEducation);
    }

    @RequestMapping("/alterEducation")
    public boolean alterEducation(Integer resumeId, String university, String education, String major, Date stratTime, Date stopTime) {
        UserEducation userEducation=new UserEducation();
        userEducation.setResumeId(resumeId);
        userEducation.setUniversity(university);
        userEducation.setEducation(education);
        userEducation.setMajor(major);
        userEducation.setStratTime(stratTime);
        userEducation.setStopTime(stopTime);
        return educationService.alterUseredu(userEducation);
    }
}
