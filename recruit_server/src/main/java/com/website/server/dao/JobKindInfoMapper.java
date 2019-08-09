package com.website.server.dao;

import com.website.server.pojo.JobKindInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface JobKindInfoMapper {
    int deleteByPrimaryKey(Integer jkId);

    int insert(JobKindInfo record);

    int insertSelective(JobKindInfo record);

    JobKindInfo selectByPrimaryKey(Integer jkId);

    int updateByPrimaryKeySelective(JobKindInfo record);

    int updateByPrimaryKey(JobKindInfo record);
}