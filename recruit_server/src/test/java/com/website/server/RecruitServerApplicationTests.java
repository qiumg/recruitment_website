package com.website.server;


import com.website.server.controller.CompanyInfoController;
import com.website.server.pojo.CompanyInfo;
import com.website.server.pojo.CompanySignLogin;

import com.website.server.service.ICompanyInfoService;
import com.website.server.service.ILoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecruitServerApplicationTests {
	@Autowired
	private ILoginService loginService;
	@Autowired
	private ICompanyInfoService iCompanyInfoService;
	@Autowired
	private DataSource dataSource;

	@Test
	public void contextLoads(){
		CompanySignLogin companySignLogin = new CompanySignLogin("34977146@qq.com","123456");
		loginService.insertComByEmail(companySignLogin);

	}
	@Test
	public void contextLoads1(){
		CompanyInfo companyInfo = new CompanyInfo("张三","中外合资",333.55,"北京","zhangsan",12345678912L,"888888","www.zhangsan.com","啊啊","8888人","CEO","A轮","942557853@qq.com");
	iCompanyInfoService.addCompanyInfo(companyInfo);

	}
	@Test
	public void contextLoads2() {

	}
}
