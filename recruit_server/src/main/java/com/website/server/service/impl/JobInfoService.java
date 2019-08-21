package com.website.server.service.impl;

import com.website.server.dao.CompanyInfoMapper;
import com.website.server.dao.JobInfoMapper;
import com.website.server.pojo.CompanyInfo;
import com.website.server.pojo.JobInfo;
import com.website.server.pojo.justforeasy.JobInfo2;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobInfoService {
    @Autowired
    private JobInfoMapper jobInfoMapper;
    @Autowired
    private CompanyInfoMapper companyInfoMapper;

    //添加职位 用公司id
    public Integer addJobInfoService(JobInfo record,int c_id){
        record.setcId(c_id);
        jobInfoMapper.insertSelective(record);
        return 1;
    }

    //删除 by j_id
    public int deleteByPrimaryKeyService(Integer jId){
        jobInfoMapper.deleteByPrimaryKey(jId);
        return 1;
    }

    //企业曾发布简历（即招募人数为零）
    public List<JobInfo2> selectHisJobByCidService(int c_id){
        List<JobInfo2> jobInfo2s=jobInfoMapper.selectHisJobByCid(c_id);
        return jobInfo2s;
    }

    //企业已发布职位信息
    public List<JobInfo2> selectAllJobByCidService(int c_id){
        List<JobInfo2> jobInfo2s=jobInfoMapper.selectAllJobByCid(c_id);
        return jobInfo2s;
    }
    //企业按职位名称搜索职位信息(模糊)
    public List<JobInfo2> selectJobByJnameService(String j_name, int c_id){
        List<JobInfo2> jobInfo2s=jobInfoMapper.selectJobByJname(j_name,c_id);
        return jobInfo2s;
    }
    //企业按工作性质搜索职位信息
    public List<JobInfo2> selectJobByJcharacterService(String j_character,int c_id){
        List<JobInfo2> jobInfo2s=jobInfoMapper.selectJobByJcharacter(j_character,c_id);
        return jobInfo2s;
    }
    //企业按职位类别2搜索职位信息
    public List<JobInfo2> selectJobByJk2nameService(String jk2_name,int c_id){
        List<JobInfo2> jobInfo2s=jobInfoMapper.selectJobByJk2name(jk2_name,c_id);
        return jobInfo2s;
    }
    //企业按职位类别1搜索职位信息
    public List<JobInfo2> selectJobByJk1nameService(String jk1_name,int c_id){
        List<JobInfo2> jobInfo2s=jobInfoMapper.selectJobByJk1name(jk1_name,c_id);
        return jobInfo2s;
    }
    //企业按职位类别搜索职位信息
    public List<JobInfo2> selectJobByJknameService(String jk_name,int c_id){
        List<JobInfo2> jobInfo2s=jobInfoMapper.selectJobByJkname(jk_name,c_id);
        return jobInfo2s;
    }
    //企业按职位名称搜索职位信息（曾发布职位查询）
    public List<JobInfo2> selectJobHisByJnameService(String j_name,int c_id){
        List<JobInfo2> jobInfo2s=jobInfoMapper.selectJobHisByJname(j_name,c_id);
        return jobInfo2s;
    }
    //企业按工作性质搜索职位信息（曾发布职位查询）
    public List<JobInfo2> selectJobHisByJcharacterService(String j_character,int c_id){
        List<JobInfo2> jobInfo2s=jobInfoMapper.selectJobHisByJcharacter(j_character,c_id);
        return jobInfo2s;
    }
    //企业按职位类别2搜索职位信息（曾发布职位查询）
    public List<JobInfo2> selectJobHisByJk2nameService(String jk2_name,int c_id){
        List<JobInfo2> jobInfo2s=jobInfoMapper.selectJobHisByJk2name(jk2_name, c_id);
        return jobInfo2s;
    }
    //企业按职位类别1搜索职位信息（曾发布职位查询）
    public List<JobInfo2> selectJobHisByJk1nameService(String jk1_name,int c_id){
        List<JobInfo2> jobInfo2s=jobInfoMapper.selectJobByJk1name(jk1_name, c_id);
        return jobInfo2s;
    }
    //企业按职位类别搜索职位信息（曾发布职位查询）
    public List<JobInfo2> selectJobHisByJknameService(String jk_name,int c_id){
        List<JobInfo2> jobInfo2s=jobInfoMapper.selectJobHisByJkname(jk_name, c_id);
        return jobInfo2s;
    }
    //更改职位信息 by j_id
    public int updateByPrimaryKeySelectiveService(JobInfo record){
        jobInfoMapper.updateByPrimaryKeySelective(record);
        return 1;
    }

    //下线职位（将招募人数设为0）

    public int downJobInfo(int j_id){
        jobInfoMapper.downJobInfo(j_id);
        return 1;
    }

    //下线职位（将招募人数设为0）

    public int upJobInfo(int j_id){
        jobInfoMapper.upJobInfo(j_id);
        return 1;
    }

    //更新职位
    public  int updateJobInfo(JobInfo jobInfo){
        jobInfoMapper.updateByPrimaryKeySelective(jobInfo);
        return 1;
    }

    //检索职位信息（所有） 按j_id
    public  JobInfo2 selectAllByJId(int j_id){
        JobInfo2 jobInfo2 = new JobInfo2();
        jobInfo2=jobInfoMapper.selectByJId(j_id);
        return jobInfo2;
    }

    //查询职位所属企业id
    public int selectCIdByJIdService(int j_id){
        int c_id=jobInfoMapper.selectCIdByJId(j_id);
        return c_id;
    }
    //根据c_id查询c_static
    public String selectCStaticByCIdService(int c_id){
        String c_static=jobInfoMapper.selectCStaticByCId(c_id);
        return c_static;
    }

    //查询所有审核通过企业信息
    public List<CompanyInfo> selectAllByStaticService(String c_static){
        List<CompanyInfo> companyInfos;
        companyInfos=companyInfoMapper.selectAllByStatic(c_static);
        return companyInfos;
    }



}
