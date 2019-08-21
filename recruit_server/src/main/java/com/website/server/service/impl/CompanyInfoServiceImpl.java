//package com.website.server.service.impl;
//
//import com.website.server.dao.CompanyInfoMapper;
//import com.website.server.pojo.CompanyInfo;
//import com.website.server.service.ICompanyService;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
//public class CompanyInfoServiceImpl implements ICompanyService {
//    @Autowired
//    private CompanyInfoMapper companyInfoMapper;
//
//    @Override
//    public CompanyInfo selectCompanyInfoByCstatic(String cStatic) throws Exception {
//        CompanyInfo companyInfo = companyInfoMapper.selectByCstatic(cStatic);
//        return companyInfo;
//    }
//
//    @Override
//    public List<CompanyInfo> selectAll() throws Exception {
//        List<CompanyInfo> companyInfoList = companyInfoMapper.selectAll();
//        return companyInfoList;
//    }
//
//    @Override
//    public void modifyCompanyInfo(Integer cId) throws Exception {
//        CompanyInfo companyInfo = companyInfoMapper.updateCompanyInfoById(cId);
//
//    }
//}
