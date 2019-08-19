package com.website.server.service.impl;

import com.website.server.dao.UserJobexpMapper;
import com.website.server.pojo.UserJobexp;
import com.website.server.service.JobExpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobExpServiceimpl implements JobExpService {
    @Autowired
    private UserJobexpMapper userJobexpMapper;
    @Override
    public UserJobexp showJobexp(String resumeName) {//查询工作经验
        UserJobexp userJobexp=userJobexpMapper.selectByjianliname(resumeName);
        return userJobexp;
    }

    @Override
    public boolean addJobexp(UserJobexp userJobexp) {//修改工作经验
        int i=userJobexpMapper.insertSelective(userJobexp);
        if(i>0){
            return true;
        }
        return false;
    }
}
