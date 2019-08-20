package com.website.server.dao;

import com.website.server.pojo.UserEducation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserEducationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserEducation record);

    int insertSelective(UserEducation record);

    UserEducation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserEducation record);

    int updateByPrimaryKey(UserEducation record);

    UserEducation selectByjianliname(Integer resumeId);
}