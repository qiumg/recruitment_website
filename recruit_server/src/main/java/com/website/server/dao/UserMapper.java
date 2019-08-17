package com.website.server.dao;

import com.website.server.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    User selectByEmail(User record);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}