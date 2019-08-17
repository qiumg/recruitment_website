package com.website.server;

import com.website.server.dao.CompanyInfoMapper;

import com.website.server.dao.UserMapper;
import com.website.server.pojo.CompanyInfo;

import com.website.server.pojo.User;
import com.website.server.service.impl.CompanyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecruitServerApplicationTests {

	@Autowired
	private CompanyInfoMapper companyInfoMapper;
	@Autowired
	private DataSource dataSource;
	@Autowired
	private UserMapper userMapper;
	@Test
	public void contextLoads() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date a = sdf.parse("1994-07-05 15:27:02");
		Date b = sdf.parse("1996-07-05 15:27:02");
		//int companyInfo = companyInfoMapper.updateByCid(1,"审核通过");
		//List<CompanyInfo> list = companyInfoMapper.selectAll();
		CompanyInfo companyInfo1 = new CompanyInfo("阿里","中外","","马云",a,b);
		List<CompanyInfo> list1 = companyInfoMapper.selectCompany(companyInfo1);

		System.out.println("-------------");
	//	System.out.println(companyInfo);
		for (CompanyInfo c:list1){
			System.out.println(c);
		}
	}
	@Test
	public void test(){
		User user = new User();
		user.setId(1);
		user.setState("违规");
		userMapper.updatebyId(1,"违规");
	}
	@Autowired
	private CompanyService companyService;
	@Test
	public void test1(){
		List<CompanyInfo> list = companyService.show();
		for (CompanyInfo c:list){
			System.out.println(c);
		}
	}

}
