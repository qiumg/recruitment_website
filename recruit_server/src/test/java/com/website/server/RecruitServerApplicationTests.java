package com.website.server;

import com.website.server.dao.CompanyInfoMapper;
import com.website.server.dao.EmpMapper;
import com.website.server.dao.JobKindInfoMapper;
import com.website.server.dao.UserMapper;
import com.website.server.pojo.*;
import com.website.server.service.IJobKindInfoService;
import com.website.server.utils.MD5Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecruitServerApplicationTests {
	@Autowired
	private IJobKindInfoService jobKindInfoService;


	@Test
	public void contextLoads(){
		List<JobInfo> jobInfos = jobKindInfoService.queryJobInfoByCondition(null,7,9,null,null,null,null);
		System.out.println(jobInfos);
	}

}
