package com.website.server.dao;

import com.website.server.pojo.CompanyInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CompanyInfoMapper {
    int deleteByPrimaryKey(Integer cId);

    int insert(CompanyInfo record);

    int insertSelective(CompanyInfo record);


    CompanyInfo selectByPrimaryKey(Integer cId);


    List<CompanyInfo> selectAllByStatic(String c_static);


    int updateByPrimaryKeySelective(CompanyInfo record);

    int updateByPrimaryKey(CompanyInfo record);
}