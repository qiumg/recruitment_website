package com.website.client.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.website.client.pojo.JobInfo;
import com.website.client.pojo.JobInfo2;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping(value = "/JobInfo2")
public class JobInfoController {
    int i;
    private List<JobInfo2> jobInfo2s;
    private List<JobInfo2> jobInfoHis2s;

    @Autowired
    private RestTemplate restTemplate;


    //添加职位 用公司id
    @RequestMapping(value = "/addJobInfo2",method = RequestMethod.POST)
    @ResponseBody
//    @RequestParam("id") int c_id,
    public Map<String,Object> addJobInfo(HttpServletResponse resp, @RequestParam("positionType") String positionType,
                                        @RequestParam("positionType2") String positionType2, @RequestParam("positionName") String positionName,
                                        @RequestParam("jobNature") String jobNature, @RequestParam("salaryMin") Integer salaryMin,
                                        @RequestParam("salaryMax") Integer salaryMax, @RequestParam("workAddress") String workAddress,
                                        @RequestParam("workYear") String workYear, @RequestParam("education") String education,
                                        @RequestParam("positionAdvantage") String positionAdvantage, @RequestParam("positionDetail") String positionDetail,
                                        @RequestParam("positionDemand") String positionDemand , @RequestParam("num") Integer num) throws IOException {

        org.springframework.http.HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

//        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        String url = "http://PROVIDER-SERVER/jobInfo/addJobInfo";
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();

        Date date=new Date();
        Map map = new HashMap();
        Map result = new HashMap();
        map.put("c_id",1);
        map.put("positionType2",positionType2);
        map.put("positionName",positionName);
        map.put("jobNature",jobNature);
        map.put("salaryMin",salaryMin);
        map.put("salaryMax",salaryMax);
        map.put("workAddress",workAddress);
        map.put("workYear",workYear);
        map.put("education",education);
        map.put("positionAdvantage",positionAdvantage);
        map.put("positionDetail",positionDetail);
        map.put("positionDemand",positionDemand);
        map.put("num",num);
        map.put("date",date);
        map.put("jclick",0);


//        HttpEntity<Map> request1 = new HttpEntity<>(map, headers);//包装到HttpEntit
        JSONArray jsonArray=new JSONArray();
        i=restTemplate.postForObject(url,map,Integer.class);

//        i=restTemplate.postForObject("http://PROVIDER-SERVER/jobInfo/addJobInfo?positionType2={positionType2}&positionName={positionName}&" +
//                "jobNature={jobNature}&salaryMin={salaryMin}&salaryMax={salaryMax}&workAddress={workAddress}&workYear={workYear}" +
//                "&education={education}&positionAdvantage={positionAdvantage}&positionDetail={positionDetail}&positionDemand={positionDemand}" +
//                "&num={num}&date={date}&c_id={c_id}&jclick={jclick}",map,Integer.class);
        if (i==1){
            result.put("msg","success");
        }else {
            result.put("msg","fail");
        }
        return result;

    }

    //删除 by j_id
    @RequestMapping("deleteJob2")
    public void deleteJob(Integer jId){

    }

    //企业曾发布简历（即招募人数为零）
    @RequestMapping("selectHisJob2")
    public String selectHisJobByCid(HttpServletRequest request,ModelMap map){
        Map m =restTemplate.getForObject("http://PROVIDER-SERVER/jobInfo/selectHisJob",HashMap.class);
        System.out.println(m);
        ObjectMapper mapper = new ObjectMapper();
        jobInfoHis2s=mapper.convertValue(m.get("jobInfo2s"),List.class);
        System.out.println(jobInfoHis2s);
        map.addAttribute("jobInfo2s",jobInfoHis2s);
        return "positions2";


    }
    //企业已发布职位信息
    @RequestMapping("/selectAllJob2")
    public String selectAllJobByCid(HttpServletRequest request,ModelMap map){

        Map m =restTemplate.getForObject("http://PROVIDER-SERVER/jobInfo/selectAllJob",HashMap.class);
        System.out.println(m);
        ObjectMapper mapper = new ObjectMapper();
        jobInfo2s=mapper.convertValue(m.get("jobInfo2s"),List.class);
        System.out.println(jobInfo2s);
        map.addAttribute("jobInfo2s",jobInfo2s);
        return "positions";
    }
    //企业按职位名称搜索职位信息(模糊)
    @RequestMapping("selectJobByJname2")
    public void selectJobByJnameService(String j_name, int c_id){

    }
    //企业按工作性质搜索职位信息
    @RequestMapping("selectJobByJcharacter2")
    public void selectJobByJcharacterService(String j_character,int c_id){

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
    @RequestMapping("/updateJobInfo2")
    public void updateJobInfo(){


    }


}
