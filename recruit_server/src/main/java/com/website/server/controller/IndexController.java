package com.website.server.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.website.server.pojo.JobInfo;
import com.website.server.pojo.JobKindInfo;
import com.website.server.service.IJobKindInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IndexController {
    @Autowired
    private IJobKindInfoService jobKindInfoService;
    @RequestMapping("/jobkind.do")
    public List<JobKindInfo> getJobKind(){
        List<JobKindInfo> jobKindInfos = jobKindInfoService.queryAllJobKindInfo();
        return jobKindInfos;
    }
    @RequestMapping("/hotjob.do")
    public PageInfo<JobInfo> getHotJob(){
        PageHelper.startPage(1,10);
        List<JobInfo> jobInfos = jobKindInfoService.queryHotJobInfo();
        PageInfo<JobInfo> page = new PageInfo<>(jobInfos);
        return page;
    }
    @RequestMapping("/newjob.do")
    public PageInfo<JobInfo> getNewJob(){
        PageHelper.startPage(1,10);
        List<JobInfo> jobInfos = jobKindInfoService.queryNewJobInfo();
        PageInfo<JobInfo> page = new PageInfo<>(jobInfos);
        return page;
    }

}
