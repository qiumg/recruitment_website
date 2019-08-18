package com.website.server.service.impl;

import com.website.server.dao.UserJobwantMapper;
import com.website.server.pojo.UserJobwant;
import com.website.server.service.JobWantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobWantServiceimpl implements JobWantService {
    @Autowired
    private UserJobwantMapper userJobwantMapper;
    @Override
    public UserJobwant showJobwant(String resumeName) {//根据简历名获取期望表信息
        UserJobwant userJobwant=userJobwantMapper.selectByjianliname(resumeName);
        return userJobwant;
    }

    @Override
    public boolean addJobwant(UserJobwant userJobwant) {//插入简历信息
        int i=userJobwantMapper.insertSelective(userJobwant);
        if(i>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean alterJobwant(UserJobwant userJobwant) {//修改简历信息
        int i=userJobwantMapper.updateByPrimaryKeySelective(userJobwant);
        if(i>0){
            return true;
        }
        return false;
    }
}
