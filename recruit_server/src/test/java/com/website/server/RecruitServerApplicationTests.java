package com.website.server;

import com.website.server.pojo.UserEducation;
import com.website.server.pojo.UserJobexp;
import com.website.server.pojo.UserProjectexp;
import com.website.server.pojo.UserWorks;
import com.website.server.service.*;
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
	private com.website.server.service.CollectionsService collectionsService;

	@Autowired
	private DataSource dataSource;

	@Test
	public void contextLoads(){
		List<Integer> s=collectionsService.selectjid(1001);
		System.out.println(s);
	}

}
