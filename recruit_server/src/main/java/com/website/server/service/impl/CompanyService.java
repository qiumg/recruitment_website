package com.website.server.service.impl;

import com.website.server.dao.CompanyInfoMapper;
import com.website.server.pojo.CompanyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyInfoMapper companyInfoMapper;
    //显示待审核的公司
    public List<CompanyInfo> show(){
        return (List<CompanyInfo>) companyInfoMapper.selectByStatu("待审核");

    }
    //审核通过
    public void updateStatu(Integer cid){
        companyInfoMapper.updateByCid(cid,"审核通过");
    }
    //审核未通过
    public void updateStatu2(Integer cid){
        companyInfoMapper.updateByCid(cid,"审核未通过");
    }
}
