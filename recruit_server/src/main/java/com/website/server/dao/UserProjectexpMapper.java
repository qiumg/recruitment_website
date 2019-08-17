package com.website.server.dao;

import com.website.server.pojo.UserProjectexp;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserProjectexpMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserProjectexp record);

    int insertSelective(UserProjectexp record);

    UserProjectexp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserProjectexp record);

    int updateByPrimaryKey(UserProjectexp record);

    UserProjectexp selectByjianliname(String resumeName);
}