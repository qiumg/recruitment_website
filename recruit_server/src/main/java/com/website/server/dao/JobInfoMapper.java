package com.website.server.dao;

import com.website.server.pojo.JobInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface JobInfoMapper {
    int deleteByPrimaryKey(Integer jId);

    int insert(JobInfo record);

    int insertSelective(JobInfo record);

    JobInfo selectByPrimaryKey(Integer jId);

    int updateByPrimaryKeySelective(JobInfo record);

    int updateByPrimaryKey(JobInfo record);
    //根据点击量排序所查询到的结果
    List<JobInfo> selectJobInfoByClick();
    //根据发布日期排序所查询到的结果
    List<JobInfo> selectJobInfoByDate();
    //根据职位名模糊查询
    List<JobInfo> selectJobInfoLikeName(String jobName);
    //根据公司的名称对职位进行模糊查询
    List<JobInfo> selectJobInfoLikeCompanyName(String companyName);
    //根据条件查询对工作进行查询
    List<JobInfo> selectJobInfoByCondition(@Param("companyName") String companyName,@Param("jobName") String jobName,@Param("addr") String addr, @Param("low") Integer low, @Param("high") Integer high, @Param("exp") String exp, @Param("education") String education, @Param("nature") String nature, @Param("date") Integer date);
}