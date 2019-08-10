package com.website.server.dao;

import com.website.server.pojo.CompanyPower;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CompanyPowerMapper {
    int deleteByPrimaryKey(Integer pId);

    int insert(CompanyPower record);

    int insertSelective(CompanyPower record);

    CompanyPower selectByPrimaryKey(Integer pId);

    int updateByPrimaryKeySelective(CompanyPower record);

    int updateByPrimaryKey(CompanyPower record);
}