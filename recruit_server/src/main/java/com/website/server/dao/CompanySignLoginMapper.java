package com.website.server.dao;

import com.website.server.pojo.CompanySignLogin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CompanySignLoginMapper {
    int deleteByPrimaryKey(Integer cId);

    int insert(CompanySignLogin record);

    int insertSelective(CompanySignLogin record);

    CompanySignLogin selectByPrimaryKey(Integer cId);

    int updateByPrimaryKeySelective(CompanySignLogin record);

    int updateByPrimaryKey(CompanySignLogin record);
}