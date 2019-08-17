package com.website.server.controller;

import com.website.server.dao.JobInfoMapper;
import com.website.server.pojo.JobInfo;
import com.website.server.pojo.justforeasy.JobInfo2;
import com.website.server.service.impl.JobInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/jobInfo")
public class JobInfoController {
    int i;
    private List<JobInfo2> jobInfo2s;
    @Autowired
    private JobInfoService jobInfoService;

    //添加职位 用公司id
    @RequestMapping("/addJobInfo.do")

    public void addJobInfo(@RequestParam("id") JobInfo record,int c_id){



    }

    //删除 by j_id
    @RequestMapping("delete.do")
    public void deleteJob(Integer jId){
        i=jobInfoService.deleteByPrimaryKeyService(jId);

    }
    @RequestMapping("selectHisJob.do")
    //企业曾发布简历（即招募人数为零）
    public void selectHisJobByCid(int c_id){
        jobInfo2s=jobInfoService.selectHisJobByCidService(c_id);

    }
    //企业已发布职位信息
    @RequestMapping("selectAllJob.do")
    public void selectAllJobByCid(int c_id){
        jobInfo2s=jobInfoService.selectAllJobByCidService(c_id);

    }
    //企业按职位名称搜索职位信息(模糊)
    @RequestMapping("selectJobByJname.do")
    public void selectJobByJnameService(String j_name, int c_id){
        jobInfo2s=jobInfoService.selectJobByJnameService(j_name, c_id);

    }
    //企业按工作性质搜索职位信息
    @RequestMapping("selectJobByJcharacter.do")
    public void selectJobByJcharacterService(String j_character,int c_id){
        jobInfo2s=jobInfoService.selectJobByJcharacterService(j_character, c_id);

    }
    //企业按职位类别2搜索职位信息

    //企业按职位类别1搜索职位信息

    //企业按职位类别搜索职位信息

    //企业按职位名称搜索职位信息（曾发布职位查询）

    //企业按工作性质搜索职位信息（曾发布职位查询）

    //企业按职位类别2搜索职位信息（曾发布职位查询）

    //企业按职位类别1搜索职位信息（曾发布职位查询）

    //企业按职位类别搜索职位信息（曾发布职位查询）

    //更改职位信息 by j_id



}
