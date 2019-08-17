package com.website.server.service.impl;

import com.website.server.dao.UserProjectexpMapper;
import com.website.server.pojo.UserProjectexp;
import com.website.server.service.ProjectexpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectexpServiceimpl implements ProjectexpService {
    @Autowired
    private UserProjectexpMapper userProjectexpMapper;
    @Override
    public UserProjectexp showProjectexp(String resumeName) {//查询项目经验
        UserProjectexp userProjectexp=userProjectexpMapper.selectByjianliname(resumeName);
        return userProjectexp;
    }

    @Override
    public boolean addProjectexp(UserProjectexp userProjectexp) {//添加项目经验
        int i=userProjectexpMapper.insertSelective(userProjectexp);
        if(i>0){
            return true;
        }
        return false;
    }
}
