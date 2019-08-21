package com.website.server.service.impl;

import com.website.server.dao.UserMapper;
import com.website.server.pojo.User;
import com.website.server.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public void modifyStatic(User user , String state , Integer id) throws Exception {
        userMapper.updateUserStaticById(user,state,id);
    }

    @Override
    public List<User> selectAll() throws Exception {
        List<User> userList = userMapper.selectAll();
        return userList;
    }

    @Override
    public List<User> findUsers(String name,Integer sex, Integer age, Integer beginAge, Integer endAge, Integer workingYears, Integer beginWorkingYears, Integer endWorkdingYears, String state) throws Exception {
        List<User> userList = userMapper.selectUsers(name, sex,  age, beginAge,endAge, workingYears, beginWorkingYears,endWorkdingYears, state);
        System.out.println(userList+"666666666666666666666666666666");
        return userList;
    }
}
