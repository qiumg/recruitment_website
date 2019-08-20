package com.website.server.dao;

import com.website.server.pojo.UserWorks;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserWorksMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserWorks record);

    int insertSelective(UserWorks record);

    UserWorks selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserWorks record);

    int updateByPrimaryKey(UserWorks record);

    UserWorks selectByjianliname(Integer resumeId);
}