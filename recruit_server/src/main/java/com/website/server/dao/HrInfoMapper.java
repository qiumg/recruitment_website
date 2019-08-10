package com.website.server.dao;

import com.website.server.pojo.HrInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface HrInfoMapper {
    int deleteByPrimaryKey(Integer hrId);

    int insert(HrInfo record);

    int insertSelective(HrInfo record);

    HrInfo selectByPrimaryKey(Integer hrId);

    int updateByPrimaryKeySelective(HrInfo record);

    int updateByPrimaryKey(HrInfo record);
}