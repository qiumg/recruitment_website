package com.website.server.dao;

import com.website.server.pojo.JobKind1Info;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface JobKind1InfoMapper {
    int deleteByPrimaryKey(Integer jk1Id);

    int insert(JobKind1Info record);

    int insertSelective(JobKind1Info record);

    JobKind1Info selectByPrimaryKey(Integer jk1Id);

    @Results({@Result(column="jk1_name",property="jk1Name")})
    @Select("select * from job_kind1_info")
    List<JobKind1Info> selectAllJobKind1();

    int updateByPrimaryKeySelective(JobKind1Info record);

    int updateByPrimaryKey(JobKind1Info record);
}