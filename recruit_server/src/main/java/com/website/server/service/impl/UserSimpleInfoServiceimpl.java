package com.website.server.service.impl;

import com.website.server.dao.UserMapper;
import com.website.server.dao.UserResumeMapper;
import com.website.server.pojo.User;
import com.website.server.pojo.UserResume;
import com.website.server.service.UserSimpleInfoService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserSimpleInfoServiceimpl implements UserSimpleInfoService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserResumeMapper resumeMapper;

    @Override
    public UserResume getresumeybyuid(Integer userid) {
        UserResume userResume=resumeMapper.selectResumeByUserId(userid);
        return userResume;
    }

    @Override
    public boolean setresumename(Integer userid) {
        return false;
    }

    @Override
    public User getuserinfo(Integer userid) {
        User user=userMapper.selectByPrimaryKey(userid);
        return user;
    }
}
