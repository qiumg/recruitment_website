package com.website.client.controller;


import com.website.client.pojo.JobKindInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/index")
public class IndexController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/jobkind.do")
    public List<JobKindInfo> getJobKind() {
        List<JobKindInfo> object = restTemplate.getForObject("http://PROVIDER-SERVER/index/jobkind.do", List.class);
        return object;
    }

    @RequestMapping("/hotjob.do")
    public String getHotJob() {

        return null;
    }

    @RequestMapping("/newjob.do")
    public String getNewJob() {

        return null;
    }
}
