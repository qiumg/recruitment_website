package com.website.server;


import com.website.server.pojo.User;

import com.website.server.service.ILoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RecruitServerApplicationTests {

	@Autowired
	private ILoginService loginService;

	@Test
	public void contextLoads(){
		String s = "yanhuan@qq.com";
		int length = s.length();
		s = s.substring(0,length-7);
		System.out.println(s);

	}

}
