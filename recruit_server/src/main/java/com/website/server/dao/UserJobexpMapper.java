package com.website.server.dao;

import com.website.server.pojo.UserJobexp;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserJobexpMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserJobexp record);

    int insertSelective(UserJobexp record);

    UserJobexp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserJobexp record);

    int updateByPrimaryKey(UserJobexp record);

    UserJobexp selectByjianliname(Integer resumeId);
}