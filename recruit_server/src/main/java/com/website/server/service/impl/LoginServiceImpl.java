package com.website.server.service.impl;

import com.website.server.dao.CompanySignLoginMapper;
import com.website.server.dao.UserMapper;
import com.website.server.pojo.CompanySignLogin;
import com.website.server.pojo.User;
import com.website.server.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class LoginServiceImpl implements ILoginService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CompanySignLoginMapper companySignLoginMapper;

//   登录
    @Override
    public User queryUserByEmail(User record) {
        User user = userMapper.selectByEmail(record);
        if (user == null){
            System.out.println("用户名或密码错误");
            return null;
        }else{
            System.out.println("登录成功");
            return user;
        }

    }
//  注册
    @Override
    public String insertUserByEmail(User record) {
        User existUser = userMapper.selectUser(record);
        System.out.println(existUser);
        if (existUser != null){
//            用户名已经存在
            System.out.println("用户名已存在");
            return null;
        }else{
            userMapper.insertSelective(record);
            System.out.println("注册成功");
            return "111";
        }

    }

    @Override
    public CompanySignLogin queryComByEmail(CompanySignLogin record) {
        CompanySignLogin companySignLogin=companySignLoginMapper.selectByCEmail(record);
        String s = companySignLogin.getcState();
        if (s.equals("违规")){
            return null;
        }else {
            if (companySignLogin == null){
                System.out.println("用户名或密码错误");
                return null;
            }else{
                System.out.println("登录成功");
                return companySignLogin;
            }
        }

    }

    @Override
    public String insertComByEmail(CompanySignLogin record) {
        CompanySignLogin existCompany = companySignLoginMapper.selectCompany(record);
        System.out.println(existCompany);
        System.out.println(record);
        if (existCompany != null) {
//            用户名已经存在
            System.out.println("用户名已存在");
            return null;
        } else {
            record.setcState("审核中");
            companySignLoginMapper.insertSelective(record);
            System.out.println("注册成功");
            return "111";

        }
    }
}
