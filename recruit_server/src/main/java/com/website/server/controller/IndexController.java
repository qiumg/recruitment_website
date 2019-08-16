package com.website.server.controller;

import com.website.server.pojo.JobKindInfo;
import com.website.server.service.IJobKindInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private IJobKindInfoService jobKindInfoService;
    @RequestMapping("/jobkind.do")
    public List<JobKindInfo> getJobKind(){
        List<JobKindInfo> jobKindInfos = jobKindInfoService.queryAlJobKindInfo();
        return jobKindInfos;
    }
}
