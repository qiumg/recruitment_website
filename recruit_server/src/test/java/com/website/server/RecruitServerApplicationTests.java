package com.website.server;


import com.website.server.pojo.User;

import com.website.server.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RecruitServerApplicationTests {

	@Autowired
	private IUserService userService;

	@Test
	public void contextLoads(){
		User user = new User("34977146@qq.com","123456");
		userService.insertUserByEmail(user);

	}

}
