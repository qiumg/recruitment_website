package com.website.client.controller;

import com.github.pagehelper.PageInfo;
import com.website.client.pojo.JobInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Controller
public class SearchController {
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("/search")
    public String searchJobInfo(String kd, Integer choose, ModelMap map){
        PageInfo<JobInfo> page = null;
        if(choose ==1){
            page = restTemplate.getForObject("http://PROVIDER-SERVER/search/jobname?jobName="+kd, PageInfo.class);
        }else{
            page = restTemplate.getForObject("http://PROVIDER-SERVER/search/companyName?companyName="+kd, PageInfo.class);
        }
        map.addAttribute("page",page);
        return "list";
    }
}
