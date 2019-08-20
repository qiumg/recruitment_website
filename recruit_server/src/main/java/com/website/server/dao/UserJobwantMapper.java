package com.website.server.dao;

import com.website.server.pojo.UserJobwant;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserJobwantMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserJobwant record);

    int insertSelective(UserJobwant record);

    UserJobwant selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserJobwant record);

    int updateByPrimaryKey(UserJobwant record);

    UserJobwant selectByjianliname(Integer resumeId);
}