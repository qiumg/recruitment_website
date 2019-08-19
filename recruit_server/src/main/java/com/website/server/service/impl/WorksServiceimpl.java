package com.website.server.service.impl;

import com.website.server.dao.UserWorksMapper;
import com.website.server.pojo.UserWorks;
import com.website.server.service.WorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorksServiceimpl implements WorksService {
    @Autowired
    private UserWorksMapper userWorksMapper;
    @Override
    public UserWorks showUserworks(String resumeName) {
        UserWorks userWorks=userWorksMapper.selectByjianliname(resumeName);
        return userWorks;
    }

    @Override
    public boolean addUserworks(UserWorks userWorks) {
        int i=userWorksMapper.insertSelective(userWorks);
        if(i>0){
            return true;
        }
        return false;
    }
}
