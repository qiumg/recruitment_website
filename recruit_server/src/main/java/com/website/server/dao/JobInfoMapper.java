package com.website.server.dao;

import com.website.server.pojo.JobInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface JobInfoMapper {
    int deleteByPrimaryKey(Integer jId);

    int insert(JobInfo record);

    int insertSelective(JobInfo record);

    JobInfo selectByPrimaryKey(Integer jId);

    int updateByPrimaryKeySelective(JobInfo record);

    int updateByPrimaryKey(JobInfo record);
}