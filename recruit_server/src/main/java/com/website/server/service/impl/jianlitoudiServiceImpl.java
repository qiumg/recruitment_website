package com.website.server.service.impl;

import com.website.server.dao.Resume1InfoMapper;
import com.website.server.pojo.Resume1Info;
import com.website.server.service.jianlitoudiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class jianlitoudiServiceImpl implements jianlitoudiService {
    @Autowired
    private Resume1InfoMapper resume1InfoMapper;
    @Override
    public boolean toudi(Resume1Info resume1Info) {
        int i=resume1InfoMapper.insertSelective(resume1Info);
        if(i>0){
            return true;
        }
        return false;
    }
}
