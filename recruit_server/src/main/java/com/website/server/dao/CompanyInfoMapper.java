package com.website.server.dao;

import com.website.server.pojo.CompanyInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
@Mapper
public interface CompanyInfoMapper {
    int deleteByPrimaryKey(Integer cId);

    int insert(CompanyInfo record);

    int insertSelective(CompanyInfo record);

    CompanyInfo selectByPrimaryKey(Integer cId);

    int updateByPrimaryKeySelective(CompanyInfo record);

    int updateByPrimaryKey(CompanyInfo record);
    //通过状态查询企业

    List<CompanyInfo> selectByStatu(String cStatu);
    //通过企业id修改企业状态
    int updateByCid(Integer cId,String newStatu);
    //查询所有企业
    public List<CompanyInfo> selectAll();
    //多条件查询
    public List<CompanyInfo> selectCompany(CompanyInfo record);
}