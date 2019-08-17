package com.website.server.service.impl;

import com.website.server.dao.UserMapper;
import com.website.server.pojo.User;
import com.website.server.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

//   登录
    @Override
    public String queryUserByEmail(User record) {
        User user = userMapper.selectByEmail(record);
        if (user.getId()== null){
            System.out.println("用户名或密码错误");
            return "login";
        }else{
            System.out.println("登录成功");
            return "index";
        }

    }
//  注册
    @Override
    public String insertUserByEmail(User record) {
        User existUser = userMapper.selectByEmail(record);
        if (existUser != null){
//            用户名已经存在
            System.out.println("用户名已存在");
            return "register";
        }else{
            userMapper.insertSelective(record);
            System.out.println("注册成功");
            return "login";
        }

    }
}
