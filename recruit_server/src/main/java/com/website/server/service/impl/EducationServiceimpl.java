package com.website.server.service.impl;

import com.website.server.dao.UserEducationMapper;
import com.website.server.pojo.UserEducation;
import com.website.server.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationServiceimpl implements EducationService {
    @Autowired
    private UserEducationMapper userEducationMapper;
    @Override
    public UserEducation showUseredu(String resumeName) {//查询教育背景
        UserEducation userEducation=userEducationMapper.selectByjianliname(resumeName);
        return userEducation;
    }

    @Override
    public boolean addUseredu(UserEducation userEducation) {//修改教育背景
        int i=userEducationMapper.insertSelective(userEducation);
        if(i>0){
            return true;
        }
        return false;
    }
}
