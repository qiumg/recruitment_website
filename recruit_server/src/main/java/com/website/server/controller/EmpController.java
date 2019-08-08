package com.website.server.controller;


import com.website.server.pojo.Emp;
import com.website.server.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {
    @Autowired
    private IEmpService empService;
    @RequestMapping("/emp")
    public Emp getEmp(Integer id){
        Emp emp = empService.queryEmpById(id);
        return emp;
    }
}
