package com.website.server.controller;

import com.website.server.pojo.JobInfo;
import com.website.server.pojo.UserResume;
import com.website.server.pojo.justforeasy.JobInfo2;
import com.website.server.service.impl.JobInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/jobInfo")
public class JobInfoController {
    int i;
    private List<JobInfo2> jobInfo2s;
    @Autowired
    private JobInfoService jobInfoService;

    private RestTemplate restTemplate;

    //添加职位 用公司id
    @RequestMapping("/addJobInfo.do")
    public void addJobInfo(@RequestParam("id")int c_id, @RequestParam("positionType") String positionType,
                           @RequestParam("positionType2") String positionType2,@RequestParam("positionName") String positionName,
                           @RequestParam("jobNature") String jobNature,@RequestParam("salaryMin") Integer salaryMin,
                           @RequestParam("salaryMax") Integer salaryMax,@RequestParam("workAddress") String workAddress,
                           @RequestParam("workYear") String workYear,@RequestParam("education") String education,
                           @RequestParam("positionAdvantage") String positionAdvantage,@RequestParam("positionDetail") String positionDetail,
                           @RequestParam("positionDemand") String positionDemand ,@RequestParam("num") Integer num,
                           HttpServletRequest req,HttpServletResponse resp) throws IOException {
        JobInfo jobInfo=new JobInfo();
        Date date=new Date();
        jobInfo.setcId(1);
        jobInfo.setjBenefit(positionAdvantage);
        jobInfo.setjCharacter(jobNature);
        jobInfo.setJClick(0);
        jobInfo.setjDate(date);
        jobInfo.setJEducation(education);
        jobInfo.setjExperience(workYear);
        jobInfo.setjDes(positionDetail);
        jobInfo.setJk2Name(positionType2);
        jobInfo.setjLoc(workAddress);
        jobInfo.setjMhigh(salaryMax);
        jobInfo.setjMlow(salaryMin);
        jobInfo.setjReq(positionDemand);
        jobInfo.setjName(positionName);
        jobInfo.setjNum(num);



        i=jobInfoService.addJobInfoService(jobInfo,1);

        if (i==1){
            PrintWriter out=resp.getWriter();
            out.print("<script>alert('添加成功!');window.location.href='create.html'</script>");
        }else {
            PrintWriter out=resp.getWriter();
            out.print("<script>alert('添加失败!');window.location.href='create.html'</script>");
        }



    }

    //删除 by j_id
    @RequestMapping("delete.do")
    public void deleteJob(Integer jId){
        i=jobInfoService.deleteByPrimaryKeyService(jId);

    }
    @RequestMapping("selectHisJob.do")
    //企业曾发布简历（即招募人数为零）
    public void selectHisJobByCid(int c_id){
        jobInfo2s=jobInfoService.selectHisJobByCidService(c_id);

    }
    //企业已发布职位信息
    @RequestMapping("/selectAllJob")
    public Map selectAllJobByCid(HttpSession session){
        Map m=new HashMap();
        Integer cID= (Integer) session.getAttribute("c_id");
        jobInfo2s=jobInfoService.selectAllJobByCidService(2);
        System.out.println("ssssss"+jobInfo2s);
        m.put("jobInfo2s",jobInfo2s);
        System.out.println("asd"+m);
        return m;

    }
    //企业按职位名称搜索职位信息(模糊)
    @RequestMapping("selectJobByJname.do")
    public void selectJobByJnameService(String j_name, int c_id){
        jobInfo2s=jobInfoService.selectJobByJnameService(j_name, c_id);

    }
    //企业按工作性质搜索职位信息
    @RequestMapping("selectJobByJcharacter.do")
    public void selectJobByJcharacterService(String j_character,int c_id){
        jobInfo2s=jobInfoService.selectJobByJcharacterService(j_character, c_id);

    }
    //企业按职位类别2搜索职位信息

    //企业按职位类别1搜索职位信息

    //企业按职位类别搜索职位信息

    //企业按职位名称搜索职位信息（曾发布职位查询）

    //企业按工作性质搜索职位信息（曾发布职位查询）

    //企业按职位类别2搜索职位信息（曾发布职位查询）

    //企业按职位类别1搜索职位信息（曾发布职位查询）

    //企业按职位类别搜索职位信息（曾发布职位查询）

    //更改职位信息 by j_id



}
