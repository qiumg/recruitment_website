package com.website.server.service.impl;

import com.website.server.dao.userCollectionMapper;
import com.website.server.service.CollectionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionsServiceImpl implements CollectionsService {
    @Autowired
    private userCollectionMapper usercollectionmapper;
    @Override
    public List selectjid(Integer userId) {
        List<Integer> jids=usercollectionmapper.selectByuserid(userId);
        return jids;
    }
}
