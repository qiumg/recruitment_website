package com.website.server;

import com.website.server.pojo.UserEducation;
import com.website.server.pojo.UserJobexp;
import com.website.server.pojo.UserProjectexp;
import com.website.server.pojo.UserWorks;
import com.website.server.service.EducationService;
import com.website.server.service.JobExpService;
import com.website.server.service.ProjectexpService;
import com.website.server.service.WorksService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecruitServerApplicationTests {

	@Autowired
	private WorksService worksService;

	@Autowired
	private DataSource dataSource;

	@Test
	public void contextLoads(){
		UserWorks userWorks=worksService.showUserworks("我的简历");
		System.out.println(userWorks);
	}

}
