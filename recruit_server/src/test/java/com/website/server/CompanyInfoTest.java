//package com.website.server;
//
//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
//import com.website.server.dao.CompanyInfoMapper;
//import com.website.server.pojo.CompanyInfo;
//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//import org.junit.Test;
//
//import java.io.IOException;
//import java.util.List;
//
//public class CompanyInfoTest {
//    private CompanyInfoMapper mapper;
//    public void init() throws IOException {
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
//        SqlSession session = sqlSessionFactory.openSession();
//        mapper = session.getMapper(CompanyInfoMapper.class);
//    }
//
//    @Test
//    public void selectByCstaticTest() throws Exception {
//        CompanyInfo companyInfo = mapper.selectByCstatic("审核通过");
//        System.out.println(companyInfo);
//    }
//
//    @Test
//    public void selectAllTest() throws Exception {
//        //PageHelper.startPage(1,10);
//        List<CompanyInfo> companyInfos = mapper.selectAll();
//        //PageInfo pageInfo = new PageInfo(companyInfos);
////        System.out.println(pageInfo.getPageNum());
////        System.out.println(pageInfo.getPages());
////        List<CompanyInfo> list = pageInfo.getList();
//        System.out.println(companyInfos);
//    }
//
//    @Test
//    public void updateCompanyInfoByIdTest() throws Exception {
//        CompanyInfo companyInfo = new CompanyInfo();
//        companyInfo.setcName("腾讯");
//        companyInfo.setcCtype("中外合资");
//        companyInfo.setcMoney(100000.0);
//        //companyInfo.setcFdate(1997/07/05 15);
//        companyInfo.setcAddress("杭州");
//        companyInfo.setcPname("马化腾");
//        companyInfo.setcPhone(55555);
//        companyInfo.setcFax("555555");
//        companyInfo.setcHttp("www.alibaba.com");
//        companyInfo.setcSummary("简介");
//        companyInfo.setcLicense("地址");
//        companyInfo.setcStatic("审核通过");
//
//        mapper.updateCompanyInfoById(1);
//    }
//}
