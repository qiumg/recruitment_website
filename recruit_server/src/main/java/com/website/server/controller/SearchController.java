package com.website.server.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.website.server.pojo.JobInfo;
import com.website.server.service.IJobKindInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private IJobKindInfoService jobKindInfoService;
    @RequestMapping("/jobname")
    public PageInfo<JobInfo> searchByJobName(String jobName,Integer pageNum){
        PageHelper.startPage(pageNum,10);
        List<JobInfo> jobInfos = jobKindInfoService.queryJobInfoLiKeName(jobName);
        PageInfo<JobInfo> page = new PageInfo<>(jobInfos);
        return page;
    }
    @RequestMapping("/companyName")
    public  PageInfo<JobInfo> searchByCompanyName(String companyName,Integer pageNum){
        PageHelper.startPage(pageNum,10);
        List<JobInfo> jobInfos = jobKindInfoService.queryJobInfoLikeCompany(companyName);
        PageInfo<JobInfo> page = new PageInfo<>(jobInfos);
        return page;
    }
    @RequestMapping("/condition")
    public PageInfo<JobInfo> searchByCondition(String companyName,String jobName,String addr, Integer low, Integer high, String exp, String education, String nature, Integer date,Integer pageNum){
        PageHelper.startPage(pageNum,10);
        List<JobInfo> jobInfos = jobKindInfoService.queryJobInfoByCondition(companyName,jobName,addr, low, high, exp, education, nature, date);
        PageInfo<JobInfo> page = new PageInfo<>(jobInfos);
        return page;
    }
}
