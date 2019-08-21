package com.website.server.dao;

import com.website.server.pojo.Resume1Info;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface Resume1InfoMapper {
    int deleteByPrimaryKey(Integer r1Id);

    int insert(Resume1Info record);

    int insertSelective(Resume1Info record);

    Resume1Info selectByPrimaryKey(Integer r1Id);

    int updateByPrimaryKeySelective(Resume1Info record);

    int updateByPrimaryKey(Resume1Info record);
}