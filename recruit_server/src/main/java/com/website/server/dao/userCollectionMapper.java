package com.website.server.dao;

import com.website.server.pojo.userCollection;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface userCollectionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(userCollection record);

    int insertSelective(userCollection record);

    userCollection selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(userCollection record);

    int updateByPrimaryKey(userCollection record);

    List<Integer> selectByuserid(Integer userId);
}