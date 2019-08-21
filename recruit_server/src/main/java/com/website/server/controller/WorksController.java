package com.website.server.controller;

import com.website.server.pojo.UserWorks;
import com.website.server.service.WorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jianli")
public class WorksController {
    @Autowired
    private WorksService worksService;
    @RequestMapping("/addWorks")
    public boolean addProjectexp(Integer resumeId, String link, String describe1) {
        UserWorks userWorks=new UserWorks();
        userWorks.setResumeId(resumeId);
        userWorks.setLink(link);
        userWorks.setDescribe1(describe1);
        return worksService.addUserworks(userWorks);
    }

    @RequestMapping("/alterWorks")
    public boolean alterProjectexp(Integer resumeId, String link, String describe1) {
        UserWorks userWorks=new UserWorks();
        userWorks.setResumeId(resumeId);
        userWorks.setLink(link);
        userWorks.setDescribe1(describe1);
        return worksService.alterUserworks(userWorks);
    }
}
