package com.website.server.service.impl;

import com.website.server.dao.UserMapper;
import com.website.server.dao.UserResumeMapper;
import com.website.server.pojo.User;
import com.website.server.pojo.UserResume;
import com.website.server.service.UserSimpleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserSimpleInfoServiceimpl implements UserSimpleInfoService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserResumeMapper resumeMapper;

    @Override
    public UserResume getresumeybyuid(Integer userid) {//根据userid查询简历主表信息
        UserResume userResume=resumeMapper.selectResumeByUserId(userid);
        return userResume;
    }

    @Override
    public boolean setresumename(UserResume userResume) {//修改简历名
        Date date=new Date();
        userResume.setModifyTime(date);//更改最后修改时间
        int i=resumeMapper.updateByUserId(userResume);
        if(i>0){
            return true;
        }
        return false;
    }

    @Override
    public User getuserinfo(Integer userid) {//根据userid查询用户信息
        User user=userMapper.selectByPrimaryKey(userid);
        return user;
    }

    @Override
    public boolean setuserinfo(User user) {//修改user的基本信息
        int i=userMapper.updateByPrimaryKeySelective(user);
        if(i>0){
            UserResume userResume=new UserResume();
            Date date=new Date();
            userResume.setModifyTime(date);
            resumeMapper.updateByUserId(userResume);//更改最后修改时间
            return true;
        }
        return false;
    }
}
