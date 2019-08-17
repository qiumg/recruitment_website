package com.website.client.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.website.client.pojo.JobInfo;
import com.website.client.pojo.JobInfo2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/JobInfo2")
public class JobInfoController {
    int i;
    private List<JobInfo2> jobInfo2s;

    @Autowired
    private RestTemplate restTemplate;


    //添加职位 用公司id
    @RequestMapping("/addJobInfo2")
    public void addJobInfo() throws IOException {
        restTemplate.getForObject("http://PROVIDER-SERVER/jobInfo/addJobInfo.do",JobInfo.class);

    }

    //删除 by j_id
    @RequestMapping("deleteJob2")
    public void deleteJob(Integer jId){

    }
    @RequestMapping("selectHisJob2")
    //企业曾发布简历（即招募人数为零）
    public void selectHisJobByCid(int c_id){

    }
    //企业已发布职位信息
    @RequestMapping("/selectAllJob2")
    public String selectAllJobByCid(HttpServletRequest request,ModelMap map){

        Map m =restTemplate.getForObject("http://PROVIDER-SERVER/jobInfo/selectAllJob",HashMap.class);
        System.out.println(m);
        ObjectMapper mapper = new ObjectMapper();
        jobInfo2s=mapper.convertValue(m.get("jobInfo2s"),List.class);
        System.out.println(jobInfo2s);
        map.addAttribute("jobInfo2s",jobInfo2s);
        return "positions";
    }
    //企业按职位名称搜索职位信息(模糊)
    @RequestMapping("selectJobByJname2")
    public void selectJobByJnameService(String j_name, int c_id){

    }
    //企业按工作性质搜索职位信息
    @RequestMapping("selectJobByJcharacter2")
    public void selectJobByJcharacterService(String j_character,int c_id){

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
