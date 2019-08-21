package com.website.server.service;

import com.website.server.pojo.JobInfo;
import com.website.server.pojo.JobKindInfo;

import java.util.List;

public interface IJobKindInfoService {
    //查询所有的工作种类
    List<JobKindInfo>queryAllJobKindInfo();
    //查询热门职位及公司信息
    List<JobInfo> queryHotJobInfo();
    //查询最新职位及公司信息
    List<JobInfo> queryNewJobInfo();
    //根据职位名进行模糊查询
    List<JobInfo> queryJobInfoLiKeName(String jobName);
    //根据公司名进行模糊查询
    List<JobInfo> queryJobInfoLikeCompany(String companyName);
    //根据工作地点、月薪范围、工作经验、最低学历、工作性质、发布时间进行多条件查询
    List<JobInfo> queryJobInfoByCondition(String companyName,String jobName,String addr,Integer low,Integer high,String exp,String education,String nature,Integer date);
}
