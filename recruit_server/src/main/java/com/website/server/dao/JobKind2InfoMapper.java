package com.website.server.dao;

import com.website.server.pojo.JobKind2Info;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface JobKind2InfoMapper {
    int deleteByPrimaryKey(Integer jk2Id);

    int insert(JobKind2Info record);

    int insertSelective(JobKind2Info record);

    JobKind2Info selectByPrimaryKey(Integer jk2Id);

    List<JobKind2Info> selectByJK1Id(Integer jk1Id);

    int updateByPrimaryKeySelective(JobKind2Info record);

    int updateByPrimaryKey(JobKind2Info record);
}