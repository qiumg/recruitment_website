package com.website.server.service;

import com.website.server.pojo.CompanyInfo;


public interface ICompanyInfoService {
    public int addCompanyInfo(CompanyInfo companyInfo);
    public CompanyInfo getCompanybycid(Integer cid);
    public boolean updateCompany(CompanyInfo companyInfo);
}
