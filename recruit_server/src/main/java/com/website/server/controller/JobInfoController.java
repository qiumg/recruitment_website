package com.website.server.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.website.server.pojo.JobInfo;
import com.website.server.pojo.UserResume;
import com.website.server.pojo.justforeasy.JobInfo2;
import com.website.server.service.impl.JobInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
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
    @RequestMapping("/addJobInfo")
//    HttpSession session,  String positionType,
//    String positionType2,String positionName,
//    String jobNature, Integer salaryMin,
//    Integer salaryMax, String workAddress,
//    String workYear, String education,
//    String positionAdvantage,String positionDetail,
//    String positionDemand , Integer num,Date date, Integer c_id
    public Integer addJobInfo(@RequestBody  ModelMap map ) throws IOException {
        JobInfo jobInfo=new JobInfo();


//        map.put("c_id",1);
//        map.put("positionType2",positionType2);
//        map.put("positionName",positionName);
//        map.put("jobNature",jobNature);
//        map.put("salaryMin",salaryMin);
//        map.put("salaryMax",salaryMax);
//        map.put("workAddress",workAddress);
//        map.put("workYear",workYear);
//        map.put("education",education);
//        map.put("positionAdvantage",positionAdvantage);
//        map.put("positionDetail",positionDetail);
//        map.put("positionDemand",positionDemand);
//        map.put("num",num);
//        map.put("date",date);
//        map.put("jclick",0);

        ObjectMapper mapper = new ObjectMapper();

        jobInfo.setcId(mapper.convertValue(map.get("c_id"),Integer.class));
        jobInfo.setjBenefit(mapper.convertValue(map.get("positionAdvantage"),String.class));
        jobInfo.setjCharacter(mapper.convertValue(map.get("jobNature"),String.class));
        jobInfo.setJClick(mapper.convertValue(map.get("jclick"),Integer.class));
        jobInfo.setjDate(mapper.convertValue(map.get("date"),Date.class));
        jobInfo.setJEducation(mapper.convertValue(map.get("education"),String.class));
        jobInfo.setjExperience(mapper.convertValue(map.get("workYear"),String.class));
        jobInfo.setjDes(mapper.convertValue(map.get("positionDetail"),String.class));
        jobInfo.setJk2Name(mapper.convertValue(map.get("positionType2"),String.class));
        jobInfo.setjLoc(mapper.convertValue(map.get("workAddress"),String.class));
        jobInfo.setjMhigh(mapper.convertValue(map.get("salaryMax"),Integer.class));
        jobInfo.setjMlow(mapper.convertValue(map.get("salaryMin"),Integer.class));
        jobInfo.setjReq(mapper.convertValue(map.get("positionDemand"),String.class));
        jobInfo.setjName(mapper.convertValue(map.get("positionName"),String.class));
        jobInfo.setjNum(mapper.convertValue(map.get("num"),Integer.class));

        i=jobInfoService.addJobInfoService(jobInfo,jobInfo.getcId());
        return i;

    }

    //删除 by j_id
    @RequestMapping("/delete.do")
    public void deleteJob(Integer jId){
        i=jobInfoService.deleteByPrimaryKeyService(jId);

    }
    @RequestMapping("/selectHisJob")
    //企业曾发布简历（即招募人数为零）
    public Map selectHisJobByCid(HttpSession session){
        Map m=new HashMap();
        Integer cID= (Integer) session.getAttribute("c_id");
        jobInfo2s=jobInfoService.selectHisJobByCidService(1);
        m.put("jobInfo2s",jobInfo2s);
        return m;
    }
    //企业已发布职位信息
    @RequestMapping("/selectAllJob")
    public Map selectAllJobByCid(HttpSession session){
        Map m=new HashMap();
        Integer cID= (Integer) session.getAttribute("c_id");
        jobInfo2s=jobInfoService.selectAllJobByCidService(1);

        m.put("jobInfo2s",jobInfo2s);
//        System.out.println("asd"+m);
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
//    @RequestMapping("/updateJobInfo2/{jid}")


}
