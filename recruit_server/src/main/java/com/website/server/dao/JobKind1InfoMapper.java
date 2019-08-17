package com.website.server.dao;

import com.website.server.pojo.JobKind1Info;
import org.apache.ibatis.annotations.Mapper;
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

    int updateByPrimaryKeySelective(JobKind1Info record);

    int updateByPrimaryKey(JobKind1Info record);
    //查询所有
    public List<JobKind1Info> selectAll();
}