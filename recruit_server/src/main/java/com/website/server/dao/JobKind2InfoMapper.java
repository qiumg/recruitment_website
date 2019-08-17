package com.website.server.dao;

import com.website.server.pojo.JobKind1Info;
import com.website.server.pojo.JobKind2Info;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface JobKind2InfoMapper {
    int deleteByPrimaryKey(Integer jk2Id);

    int insert(JobKind2Info record);

    int insertSelective(JobKind2Info record);

    JobKind2Info selectByPrimaryKey(Integer jk2Id);

    @Results({
            @Result(column="jk2_name",property="jk2Name")
    })
    @Select("select * from job_kind2_info")
    List<JobKind2Info> selectAllJobKind2();

    int updateByPrimaryKeySelective(JobKind2Info record);

    int updateByPrimaryKey(JobKind2Info record);
}