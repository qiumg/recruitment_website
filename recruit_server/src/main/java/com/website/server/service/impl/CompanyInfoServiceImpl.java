package com.website.server.service.impl;

import com.website.server.dao.CompanyInfoMapper;

import com.website.server.pojo.CompanyInfo;

import com.website.server.service.ICompanyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyInfoServiceImpl implements ICompanyInfoService {


    @Autowired
    private CompanyInfoMapper companyInfoMapper;
   /* @Autowired
    private CompanySignLoginMapper companySignLoginMapper;*/
    @Override
    public int addCompanyInfo(CompanyInfo companyInfo) {
       int i=companyInfoMapper.insertSelective(companyInfo);
       return companyInfo.getcId();

    }

    @Override
    public CompanyInfo getCompanybycid(Integer cid) {
        CompanyInfo companyInfo=companyInfoMapper.selectByPrimaryKey(cid);
        return companyInfo;
    }

    @Override
    public boolean updateCompany(CompanyInfo companyInfo) {
        int i=companyInfoMapper.updateByPrimaryKeySelective(companyInfo);
        if (i>0){
            return true;
        }
        return false;
    }

}
