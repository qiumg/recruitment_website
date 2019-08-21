package com.website.server.controller;

import com.website.server.pojo.Resume1Info;
import com.website.server.service.jianlitoudiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contrjianli")
public class jianlitoudiController {
    @Autowired
    private jianlitoudiService jianlitoudiservice;
    @RequestMapping("/toudi")
    public boolean addEducation(Integer r1Id, Integer jId) {
        Resume1Info resume1Info=new Resume1Info();
        resume1Info.setR1Id(r1Id);
        resume1Info.setjId(jId);
        return jianlitoudiservice.toudi(resume1Info);
    }
}
