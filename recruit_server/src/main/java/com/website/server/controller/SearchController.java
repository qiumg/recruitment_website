package com.website.server.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.website.server.pojo.JobInfo;
import com.website.server.service.IJobKindInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private IJobKindInfoService jobKindInfoService;
    @RequestMapping("jobname")
    public Map<String,Object> searchByJobName(String jobName){
        PageHelper.startPage(1,10);
        List<JobInfo> jobInfos = jobKindInfoService.queryJobInfoLiKeName(jobName);
        PageInfo<JobInfo> page = new PageInfo<>(jobInfos);
        Map<String,Object> map = new HashMap<>();
        map.put("page",page);
        return map;
    }
    @RequestMapping("/companyName")
    public  Map<String,Object> searchByCompanyName(String companyName){
        PageHelper.startPage(1,10);
        List<JobInfo> jobInfos = jobKindInfoService.queryJobInfoLikeCompany(companyName);
        PageInfo<JobInfo> page = new PageInfo<>(jobInfos);
        Map<String,Object> map = new HashMap<>();
        map.put("page",page);
        return map;
    }
    @RequestMapping("/condition")
    public Map<String,Object> searchByCondition(String addr, Integer low, Integer high, String exp, String education, String nature, Integer date){
        PageHelper.startPage(1,10);
        List<JobInfo> jobInfos = jobKindInfoService.queryJobInfoByCondition(addr, low, high, exp, education, nature, date);
        PageInfo<JobInfo> page = new PageInfo<>(jobInfos);
        Map<String,Object> map = new HashMap<>();
        map.put("page",page);
        return map;
    }
}
