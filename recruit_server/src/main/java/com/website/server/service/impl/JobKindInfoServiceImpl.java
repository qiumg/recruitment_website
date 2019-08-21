package com.website.server.service.impl;

import com.website.server.dao.JobInfoMapper;
import com.website.server.dao.JobKind2InfoMapper;
import com.website.server.dao.JobKindInfoMapper;
import com.website.server.dao.TicketInfoMapper;
import com.website.server.pojo.*;
import com.website.server.service.IJobKindInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobKindInfoServiceImpl implements IJobKindInfoService {
    @Autowired
    private TicketInfoMapper ticketInfoMapper;
    @Autowired
    private JobInfoMapper jobInfoMapper;
    @Autowired
    private JobKindInfoMapper jobKindInfoMapper;
    @Autowired
    private JobKind2InfoMapper jobKind2InfoMapper;

    @Override
    public List<JobKindInfo> queryAllJobKindInfo() {
        List<JobKindInfo> jobKindInfos = jobKindInfoMapper.selectAll();
        List<JobKindInfo> jobKinds = new ArrayList<>();
        for (int i = 0; i < jobKindInfos.size(); i++) {
            JobKindInfo jobKindInfo = jobKindInfoMapper.selectJobKindAndKind1ById(jobKindInfos.get(i).getJkId());
            List<JobKind1Info> jobKind1Infos = jobKindInfo.getJobKind1Infos();
            for (int j = 0; j < jobKind1Infos.size(); j++) {
                List<JobKind2Info> jobKind2Infos = jobKind2InfoMapper.selectByJK1Id(jobKind1Infos.get(j).getJk1Id());
                jobKind1Infos.get(j).setJobKind2Infos(jobKind2Infos);
            }
            jobKinds.add(jobKindInfo);
        }
        return jobKinds;
    }

    @Override
    public List<JobInfo> queryHotJobInfo() {
        List<JobInfo> jobInfos = jobInfoMapper.selectJobInfoByClick();
        for (int i = 0; i < jobInfos.size(); i++) {
            List<TicketInfo> ticketInfos = ticketInfoMapper.selectTicketInfoBycId(jobInfos.get(i).getcId());
            jobInfos.get(i).getCompanyInfo().setTicketInfos(ticketInfos);
        }
        return jobInfos;
    }

    @Override
    public List<JobInfo> queryNewJobInfo() {
        List<JobInfo> jobInfos = jobInfoMapper.selectJobInfoByDate();
        for (int i = 0; i < jobInfos.size(); i++) {
            List<TicketInfo> ticketInfos = ticketInfoMapper.selectTicketInfoBycId(jobInfos.get(i).getcId());
            jobInfos.get(i).getCompanyInfo().setTicketInfos(ticketInfos);
        }
        return jobInfos;
    }

    @Override
    public List<JobInfo> queryJobInfoLiKeName(String jobName) {
        List<JobInfo> jobInfos = jobInfoMapper.selectJobInfoLikeName(jobName);
        for (int i = 0; i < jobInfos.size(); i++) {
            List<TicketInfo> ticketInfos = ticketInfoMapper.selectTicketInfoBycId(jobInfos.get(i).getcId());
            jobInfos.get(i).getCompanyInfo().setTicketInfos(ticketInfos);
        }
        return jobInfos;
    }

    @Override
    public List<JobInfo> queryJobInfoLikeCompany(String companyName) {
        List<JobInfo> jobInfos = jobInfoMapper.selectJobInfoLikeCompanyName(companyName);
        for (int i = 0; i < jobInfos.size(); i++) {
            List<TicketInfo> ticketInfos = ticketInfoMapper.selectTicketInfoBycId(jobInfos.get(i).getcId());
            jobInfos.get(i).getCompanyInfo().setTicketInfos(ticketInfos);
        }
        return jobInfos;
    }

    @Override
    public List<JobInfo> queryJobInfoByCondition(String companyName,String jobName,String addr, Integer low, Integer high, String exp, String education, String nature, Integer date) {
        List<JobInfo> jobInfos = jobInfoMapper.selectJobInfoByCondition(companyName,jobName,addr, low, high, exp, education, nature, date);
        System.out.println(jobInfos);
        if (jobInfos != null) {
            for (int i = 0; i < jobInfos.size(); i++) {
                List<TicketInfo> ticketInfos = ticketInfoMapper.selectTicketInfoBycId(jobInfos.get(i).getcId());
                jobInfos.get(i).getCompanyInfo().setTicketInfos(ticketInfos);
            }
        }
        return jobInfos;
    }
}
