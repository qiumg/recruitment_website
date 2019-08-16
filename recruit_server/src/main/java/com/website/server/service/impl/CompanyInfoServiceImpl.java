package com.website.server.service.impl;

import com.website.server.dao.CompanyInfoMapper;
import com.website.server.pojo.CompanyInfo;
import com.website.server.service.ICompanyInfoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CompanyInfoServiceImpl implements ICompanyInfoService {
    @Autowired
    private CompanyInfoMapper companyInfoMapper;
    @Override
    public List<CompanyInfo> queryCompanyAndTicket() {
        return companyInfoMapper.selectCompanyAndTicket();
    }
}
