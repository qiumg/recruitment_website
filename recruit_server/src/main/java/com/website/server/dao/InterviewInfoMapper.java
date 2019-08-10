package com.website.server.dao;

import com.website.server.pojo.InterviewInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface InterviewInfoMapper {
    int deleteByPrimaryKey(Integer iId);

    int insert(InterviewInfo record);

    int insertSelective(InterviewInfo record);

    InterviewInfo selectByPrimaryKey(Integer iId);

    int updateByPrimaryKeySelective(InterviewInfo record);

    int updateByPrimaryKey(InterviewInfo record);
}