package com.website.server.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.website.server.dao.UserMapper;
import com.website.server.pojo.User;
import com.website.server.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private UserMapper userMapper;
    @RequestMapping("/user")
    public PageInfo<User> updateUser(User user , String state , Integer id) throws Exception {
        String state1 = null;
        if ("正常".equals(state)){
            state1 = "违规";
        }
        if ("违规".equals(state)){
            state1 = "正常";
        }

         userMapper.updateUserStaticById(user,state1,id);
        List<User> userList = userMapper.selectAll();
        PageInfo<User> pageInfo = new PageInfo(userList);
        return pageInfo;
         //userService.modifyStatic(user,state1,id);
    }
    @RequestMapping("/selectAll")
    public PageInfo<User> selectAll(Integer pageNum) throws Exception {
//        Map m =new HashMap();
        PageHelper.startPage(pageNum,10);
        List<User> userList = userMapper.selectAll();
        PageInfo<User> pageInfo = new PageInfo(userList);
//        System.out.println(userList+"-----------------------------------------");
//        m.put("userList",userList);
//        m.put("pageInfo",pageInfo);
        return pageInfo;
    }
    @RequestMapping("/select")
    public PageInfo<User> selectUsers(String name,String sex, Integer age,Integer beginAge, Integer endAge, Integer workingYears, Integer beginWorkingYears, Integer endWorkdingYears, String state ) throws Exception {
        Integer sex1 = null;
        String state1 = null;
        if(sex.equals("请选择类型")){
            sex1 = null;
        }else if (sex.equals("男")){
            sex1 = 0;
        }else {
            sex1 = 1;
        }

        if(state.equals("请选择类型")){
            state1 = null;
        }else {
            state1=state;
        }
        System.out.println(sex1+state1+"66666666666666666666666666666666666666");
        List<User> users = userMapper.selectUsers(name, sex1,  age, beginAge,endAge, workingYears, beginWorkingYears,endWorkdingYears, state1);
        System.out.println(users+"9999999999999999999999999999999999999999999999999999999999999999999999999999");
        PageInfo<User> pageInfo = new PageInfo(users);
        return pageInfo;
    }
}
