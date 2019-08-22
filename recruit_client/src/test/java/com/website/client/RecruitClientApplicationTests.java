package com.website.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.website.client.pojo.JobInfo2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecruitClientApplicationTests {
	@Autowired
	private RestTemplate restTemplate;

	@Test
	public void contextLoads() {
		Map m =restTemplate.getForObject("http://PROVIDER-SERVER/jobInfo/selectAllJob", HashMap.class);
		ObjectMapper mapper = new ObjectMapper();
		List<JobInfo2> jobInfo2s=mapper.convertValue(m.get("jobInfo2s"), List.class);
		System.out.println(jobInfo2s);
	}

}
