package com.website.server.service;

import com.website.server.pojo.CompanyInfo;

import java.util.List;

public interface ICompanyService {
    public CompanyInfo selectCompanyInfoByCstatic(String cStatic) throws Exception;

    public List<CompanyInfo> selectAll() throws Exception;

    public void modifyCompanyInfo(Integer cId) throws Exception;


}
