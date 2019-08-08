package com.website.server.service.impl;

import com.website.server.dao.EmpMapper;
import com.website.server.pojo.Emp;
import com.website.server.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImpl implements IEmpService {
    @Autowired
    private EmpMapper empMapper;
    @Override
    public Emp queryEmpById(Integer id) {
        Emp emp = empMapper.selectByPrimaryKey(1001);
        return emp;
    }
}
