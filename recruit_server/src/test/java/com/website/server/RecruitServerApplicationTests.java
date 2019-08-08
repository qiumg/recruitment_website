package com.website.server;

import com.website.server.dao.EmpMapper;
import com.website.server.pojo.Emp;
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
	private EmpMapper empMapper;

	@Autowired
	private DataSource dataSource;

	@Test
	public void contextLoads(){
		Emp emp = empMapper.selectByPrimaryKey(1001);
		System.out.println(emp);
	}

}
