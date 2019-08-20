package com.website.client.controller;

import com.github.pagehelper.PageInfo;
import com.website.client.pojo.JobInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


@Controller
public class SearchController {
    @Autowired
    private RestTemplate restTemplate;
    private String jobName;
    private String companyName;
    private String addr;
    private Integer low =0;
    private Integer high =100;
    private String exp;
    private String education;
    private String nature;
    private Integer date = 365;
    @RequestMapping("/search")
    public String searchJobInfo(String kd, Integer choose, Integer pageNum,ModelMap map){
        PageInfo<JobInfo> page = null;
        if (pageNum == null){
            pageNum=1;
        }
        if(choose ==1){
            jobName=kd;
            page = restTemplate.getForObject("http://PROVIDER-SERVER/search/jobname?jobName="+this.jobName+"pageNum="+pageNum, PageInfo.class);
        }else{
            companyName=kd;
            page = restTemplate.getForObject("http://PROVIDER-SERVER/search/companyName?companyName="+this.companyName+"pageNum="+pageNum, PageInfo.class);
        }
        map.addAttribute("kd",kd);
        map.addAttribute("choose",choose);
        map.addAttribute("page",page);
        return "list";
    }
    @ResponseBody
    @RequestMapping("/condition")
    public PageInfo<JobInfo> conditionSearch(String addr, Integer low, Integer high, String exp, String education, String nature, Integer date,Integer pageNum){
        if (pageNum == null){pageNum=1;}
        Map<String,Object> map = new HashMap<>();
        if(this.addr!=addr&&addr!=null){this.addr=addr;};
        if(this.low!=low&&low!=null){this.low=low;}
        if(this.high!=high&&high!=null){this.high=high;}
        if(this.exp!=exp&&exp!=null){this.exp=exp;}
        if(this.education!=education&&education!=null){this.education=education;}
        if(this.nature!=nature&&nature!=null){this.nature=nature;}
        if(this.date!=date&&date!=null){this.date=date;}
        map.put("companyName",this.companyName);
        map.put("jobName",this.jobName);
        map.put("addr",this.addr);
        map.put("low",this.low);
        map.put("high",this.high);
        map.put("exp",this.exp);
        map.put("education",this.education);
        map.put("nature",this.nature);
        map.put("date",this.date);
        map.put("pageNum",pageNum);
        PageInfo<JobInfo> page = restTemplate.getForObject("http://PROVIDER-SERVER/search/condition?companyName={companyName}&jobName={jobName}&addr={addr}&low={low}&high={high}&exp={exp}" +
                "&education={education}&nature={nature}&date={date}&pageNum={pageNum}", PageInfo.class, map);
        return page;
    }
    @RequestMapping("/jump")
    public String jump(Integer id){
        return null;
    }
}
