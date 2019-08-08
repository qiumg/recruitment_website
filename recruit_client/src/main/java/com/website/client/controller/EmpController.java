package com.website.client.controller;

import com.website.client.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EmpController {
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("/emp")
    public Emp getEmp(Integer id){
        Emp emp = restTemplate.getForObject("http://PROVIDER-SERVER/emp?id=" + id, Emp.class);
        return emp;
    }
}
