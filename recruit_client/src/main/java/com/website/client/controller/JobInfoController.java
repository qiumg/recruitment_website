package com.website.client.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.website.client.pojo.CompanyInfo;
import com.website.client.pojo.JobInfo;
import com.website.client.pojo.JobInfo2;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
    private JobInfo2 jobInfo2;
    private JobInfo jobInfo;

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

        String url = "http://PROVIDER-SERVER/jobInfo/addJobInfo";
        String url1="http://PROVIDER-SERVER/jobInfo/selectCStatic";

        Date date=new Date();
        Map map = new HashMap();
        Map result = new HashMap();
        map.put("c_id",3);
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

        Integer static1=restTemplate.postForObject(url1,map,Integer.class);
        if (static1==2){
            result.put("static","no");
        }else {
            i=restTemplate.postForObject(url,map,Integer.class);
            if (i==1){
                result.put("msg","success");
            }else {
                result.put("msg","fail");
            }
        }
        return result;
    }

    //删除 by j_id
    @RequestMapping(value = "/deleteJob2" )
    @ResponseBody
    public Map<String, Object> deleteJob(@RequestParam("jid") String jid){
        String url = "http://PROVIDER-SERVER/jobInfo/deleteJob";
        Map map = new HashMap();
        map.put("jid",jid);
        i=restTemplate.postForObject(url,map,Integer.class);

        Map<String,Object> result=new HashMap<>();
        if (i==1){
            result.put("msg","success");
        }else {
            result.put("msg","fail");
        }
        return result;

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
    @GetMapping("/selectAllJob2")
    public String selectAllJobByCid(HttpServletRequest request,ModelMap map,@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum){
        PageInfo<JobInfo2> pageInfo;
        Map map1=new HashMap();
        map1.put("pageNum",pageNum);
        PageInfo<JobInfo2> jobInfo2PageInfo =restTemplate.postForObject("http://PROVIDER-SERVER/jobInfo/selectAllJob",map1,PageInfo.class);
        ObjectMapper mapper = new ObjectMapper();
//        jobInfo2s=mapper.convertValue(m.get("jobInfo2s"),List.class);
//        pageInfo=mapper.convertValue(m.get("pageInfo"), PageInfo.class);
//        map.addAttribute("jobInfo2s",jobInfo2s);
//        System.out.println(pageInfo);
        map.addAttribute("page",jobInfo2PageInfo);
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
    @RequestMapping(value = "/updateJobInfoa" )
    public String updateJobInfoa(@RequestParam("jid") String jid,ModelMap modelMap){

        String url = "http://PROVIDER-SERVER/jobInfo/selectAllJobByJid";
        Map map = new HashMap();
        Map map1=new HashMap();
        map.put("jid",jid);
        map1=restTemplate.postForObject(url,map,Map.class);
        ObjectMapper mapper=new ObjectMapper();
        jobInfo2=mapper.convertValue(map1.get("jobInfo2"),JobInfo2.class);
        modelMap.addAttribute("jobInfo2",jobInfo2);
        return "updateJob";
    }
    @RequestMapping(value = "/updateJobInfob" )
    @ResponseBody
    public Map updateJobInfo(HttpServletResponse resp, @RequestParam("positionType") String positionType,@RequestParam("jId") String jId,
                                @RequestParam("positionType2") String positionType2, @RequestParam("positionName") String positionName,
                                @RequestParam("jobNature") String jobNature, @RequestParam("salaryMin") Integer salaryMin,
                                @RequestParam("salaryMax") Integer salaryMax, @RequestParam("workAddress") String workAddress,
                                @RequestParam("workYear") String workYear, @RequestParam("education") String education,
                                @RequestParam("positionAdvantage") String positionAdvantage, @RequestParam("positionDetail") String positionDetail,
                                @RequestParam("positionDemand") String positionDemand , @RequestParam("num") Integer num){

        String url = "http://PROVIDER-SERVER/jobInfo/updateJobInfo";
        Map map = new HashMap();
        Map map1=new HashMap();
        Map result = new HashMap();
        map.put("jid",jId);
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
        i=restTemplate.postForObject(url,map,Integer.class);
        if (i==1){
            result.put("msg","success");
        }else {
            result.put("msg","fail");
        }


        return result;
    }


    @GetMapping(value = "/jobdetail1" )
    public String jobdetail1(@RequestParam("jid") Integer j_id,ModelMap modelMap){
        String url = "http://PROVIDER-SERVER/jobInfo/selectAllJobByJid";
        Map map = new HashMap();
        Map map1=new HashMap();
        map.put("jid",j_id);
        map1=restTemplate.postForObject(url,map,Map.class);
        ObjectMapper mapper=new ObjectMapper();
        jobInfo2=mapper.convertValue(map1.get("jobInfo2"),JobInfo2.class);
        modelMap.addAttribute("jobInfo2",jobInfo2);
        return "jobdetail1";
    }





    //下线职位
    @RequestMapping(value = "/downJob2" )
    @ResponseBody
    public Map<String,Object> downJobIndo(@RequestParam("jid") String jid){
        String url = "http://PROVIDER-SERVER/jobInfo/downJob";
        Map map = new HashMap();
        map.put("jid",jid);
        i=restTemplate.postForObject(url,map,Integer.class);

        Map<String,Object> result=new HashMap<>();
        if (i==1){
            result.put("msg","success");
        }else {
            result.put("msg","fail");
        }
        return result;
    }
    //下线职位
    @RequestMapping(value = "/upJob2" )
    @ResponseBody
    public Map<String,Object> upJobIndo(@RequestParam("jid") String jid){
        String url = "http://PROVIDER-SERVER/jobInfo/upJob";
        Map map = new HashMap();
        map.put("jid",jid);
        i=restTemplate.postForObject(url,map,Integer.class);

        Map<String,Object> result=new HashMap<>();
        if (i==1){
            result.put("msg","success");
        }else {
            result.put("msg","fail");
        }
        return result;
    }

    //显示所有审核通过公司信息
    @GetMapping("/selectAllCompantInfo")
    public String selectAllByStatic(HttpServletRequest request,ModelMap map,@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum){
        PageInfo<JobInfo2> pageInfo;
        Map map1=new HashMap();
        map1.put("pageNum",pageNum);
        PageInfo<CompanyInfo> companyInfoPageInfo =restTemplate.postForObject("http://PROVIDER-SERVER/jobInfo/selectAllCompantInfo2",map1,PageInfo.class);
        map.addAttribute("page",companyInfoPageInfo);
        System.out.println(companyInfoPageInfo);
        return "companylist";
    }



}
