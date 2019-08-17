package com.website.server.dao;

import com.website.server.pojo.UserResumeUpload;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserResumeUploadMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserResumeUpload record);

    int insertSelective(UserResumeUpload record);

    UserResumeUpload selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserResumeUpload record);

    int updateByPrimaryKey(UserResumeUpload record);
}