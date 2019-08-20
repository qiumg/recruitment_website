package com.website.server.controller;

import com.website.server.pojo.*;
import com.website.server.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class ShowUserJianliController {
    @Autowired
    private UserSimpleInfoService userSimpleInfoService;
    @Autowired
    private JobWantService jobWantService;
    @Autowired
    private JobExpService jobExpService;
    @Autowired
    private ProjectexpService projectexpService;
    @Autowired
    private EducationService educationService;
    @Autowired
    private WorksService worksService;

    @RequestMapping("/jianli1")
    public Map getinfo(Integer userId){//查询简历基本信息
        Map m=new HashMap();
        UserResume userResume=userSimpleInfoService.getresumeybyuid(1001);
        m.put("userResume",userResume);
        return m;
    }

    @RequestMapping("/jianli2")
    public Map getmoreinfo(Integer resumeId){//查询简历具体信息
        Map m=new HashMap();
        User userinfo=userSimpleInfoService.getuserinfo(1001);
        UserJobwant userJobwant =jobWantService.showJobwant(resumeId);
        UserJobexp userJobexp=jobExpService.showJobexp(resumeId);
        UserProjectexp userProjectexp=projectexpService.showProjectexp(resumeId);
        UserEducation userEducation=educationService.showUseredu(resumeId);
        UserWorks userWorks=worksService.showUserworks(resumeId);
        m.put("userinfo",userinfo);
        m.put("userJobwant",userJobwant);
        m.put("userJobexp",userJobexp);
        m.put("userProjectexp",userProjectexp);
        m.put("userEducation",userEducation);
        m.put("userWorks",userWorks);
        return m;
    }
}
