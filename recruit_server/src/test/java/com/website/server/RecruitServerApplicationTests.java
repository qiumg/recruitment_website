package com.website.server;


import com.website.server.controller.JobInfoController;
import com.website.server.dao.JobInfoMapper;
import com.website.server.dao.JobKindInfoMapper;
import com.website.server.pojo.JobInfo;
import com.website.server.pojo.justforeasy.JobInfo2;
import com.website.server.service.impl.JobInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecruitServerApplicationTests {
//	@Autowired
//	private JobInfoMapper mapper;

	@Autowired
	private JobKindInfoMapper jobKindInfoMapper;

	@Autowired
	private JobInfoController jobInfoController;

	@Autowired
	JobInfoService jobInfoService;

	@Autowired
	private DataSource dataSource;

	@Test
	public void contextLoads() throws ParseException {
		Date date=new Date();

		JobInfo jobInfo=new JobInfo(2,"c++工程师","全职","C++",
									7,11,"1-3年",date,1,"杭州",
								"会很多东西","干很多活","五险一金,职工宿舍",1);
//		jobInfoController.addJobInfo(jobInfo,2);
	}
	@Test
	public void test1(){
		List<JobInfo2> jobInfos;

		jobInfos=jobInfoService.selectAllJobByCidService(1);
		System.out.println(jobInfos);
//		jobInfos=mapper.selectAllJobByCid(1);
//		System.out.println(jobInfos);
	}

	@Test
	public void test2(){
//		Map map=jobInfoController.selectAllJobByCid();
//		System.out.println(map);

//		List<JobInfo2> jobInfo2s=jobInfoService.selectAllJobByCidService(1);
//		System.out.println(jobInfo2s);
	}
	@Test
	public void test3(){
//		List<JobInfo2> jobInfos;
//		JobInfoService jobInfoService=new JobInfoService();
//		jobInfos=jobInfoService.selectJobByJnameService("工程师",1);
//		System.out.println(jobInfos);

	}
	@Test
	public void test4(){

//		Map map=new HashMap();
//		map=jobInfoController.selectHisJobByCid();
//		System.out.println(map);
//		List<JobInfo2> jobInfo2s;
//		jobInfo2s=jobInfoService.selectHisJobByCidService(1);
//		System.out.println(jobInfo2s);
	}

	@Test
	public void test5(){
		String[] arr = new String[25];
		System.out.println("asdfasdfasdfasdf"+arr);
	}

}
