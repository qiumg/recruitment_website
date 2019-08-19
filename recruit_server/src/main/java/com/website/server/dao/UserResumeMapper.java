package com.website.server.dao;

import com.website.server.pojo.UserResume;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserResumeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserResume record);

    int insertSelective(UserResume record);

    UserResume selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserResume record);

    int updateByPrimaryKey(UserResume record);

    UserResume selectResumeByUserId(Integer userId);

    int updatenameByUserId(UserResume record);

    int updateintroductionByUserId(UserResume record);
}