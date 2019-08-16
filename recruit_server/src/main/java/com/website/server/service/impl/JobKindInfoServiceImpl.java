package com.website.server.service.impl;

import com.website.server.dao.JobKind2InfoMapper;
import com.website.server.dao.JobKindInfoMapper;
import com.website.server.pojo.JobKind1Info;
import com.website.server.pojo.JobKind2Info;
import com.website.server.pojo.JobKindInfo;
import com.website.server.service.IJobKindInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobKindInfoServiceImpl implements IJobKindInfoService {

    @Autowired
    private JobKindInfoMapper jobKindInfoMapper;
    @Autowired
    private JobKind2InfoMapper jobKind2InfoMapper;
    @Override
    public List<JobKindInfo> queryAlJobKindInfo() {
        List<JobKindInfo> jobKindInfos = jobKindInfoMapper.selectAll();
        List<JobKindInfo> jobKinds = new ArrayList<>();
        for(int i=0;i<jobKindInfos.size();i++){
            JobKindInfo jobKindInfo = jobKindInfoMapper.selectJobKindAndKind1ById(jobKindInfos.get(i).getJkId());
            List<JobKind1Info> jobKind1Infos = jobKindInfo.getJobKind1Infos();
            for (int j=0;j<jobKind1Infos.size();j++){
                List<JobKind2Info> jobKind2Infos = jobKind2InfoMapper.selectByJK1Id(jobKind1Infos.get(j).getJk1Id());
                jobKind1Infos.get(j).setJobKind2Infos(jobKind2Infos);
            }
            jobKinds.add(jobKindInfo);
        }
        return jobKinds;
    }
}
