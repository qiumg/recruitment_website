package com.website.server.dao;

import com.website.server.pojo.JobKindInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface JobKindInfoMapper {
    int deleteByPrimaryKey(Integer jkId);

    int insert(JobKindInfo record);

    int insertSelective(JobKindInfo record);

    JobKindInfo selectByPrimaryKey(Integer jkId);
    //查询所有的工作分类
    List<JobKindInfo> selectAll();

    JobKindInfo selectJobKindAndKind1ById(Integer kindId);


    @Select("select jk_id,jk_name from job_kind_info")
    @Results({
            @Result(column="jk_name",property="jkName",jdbcType = JdbcType.VARCHAR)
    })
    List<JobKindInfo> selectAllJobKind();

    int updateByPrimaryKeySelective(JobKindInfo record);

    int updateByPrimaryKey(JobKindInfo record);
}