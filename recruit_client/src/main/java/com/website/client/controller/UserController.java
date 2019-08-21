package com.website.client.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.website.client.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;


import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.String.valueOf;

@Controller
public class UserController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/user")
    public String updateUser(HttpServletRequest request , Model model , Integer pageNum) throws Exception{
        String state = valueOf(request.getParameter("state"));
        Integer id = Integer.valueOf(request.getParameter("id"));
        Map m = new HashMap();
        m.put("state",state);
        m.put("id",id);
        m.put("pageNum",pageNum);
        PageInfo<User> user = restTemplate.getForObject("http://PROVIDER-SERVER/user?state={state}&id={id}",PageInfo.class,m);
        model.addAttribute("page",user);
        return "usertab";
    }

    @GetMapping("/selectAll")
    public String selectAll(ModelMap model ,Integer pageNum){

        Map map1 = new HashMap();
        if(pageNum == null){
            pageNum=1;
        }
        map1.put("pageNum",pageNum);
        System.out.println(map1);
        PageInfo<User> userPageInfo = restTemplate.getForObject("http://PROVIDER-SERVER/selectAll?pageNum={pageNum}",PageInfo.class,map1);
//        Map map=null;
//        map = restTemplate.getForObject("http://PROVIDER-SERVER/selectAll",Map.class);
//        Integer PageNum = mapper.convertValue(model.get("pageNum"), Integer.class);
        //ObjectMapper mapper = new ObjectMapper();
//       List<User> userList=mapper.convertValue(map.get("userList"),List.class);
        model.addAttribute("page",userPageInfo);
//        model.addAttribute("user",userList);
        return  "usertab";
    }
    @RequestMapping("/select")
    public String selectUsers(HttpServletRequest request,ModelMap model,Integer pageNum) throws ParseException {
        String name = valueOf(request.getParameter("name"));
        String sex = valueOf(request.getParameter("sex"));
        Integer beginAge=null;
        Integer endAge = null;
        Integer beginWorkingYears = null;
        Integer endWorkingYears = null;
        if ( !("".equals(request.getParameter("beginAge")))&&request.getParameter("beginAge") != null){
             beginAge = Integer.valueOf(request.getParameter("beginAge"));
        }
        if ( !("".equals(request.getParameter("endAge")))&& request.getParameter("endAge") !=null){
            endAge = Integer.valueOf(request.getParameter("endAge"));
        }
        if ( !("".equals(request.getParameter("beginWorkingYears")))&& request.getParameter("beginWorkingYears") != null){
            System.out.println(request.getParameter("beginWorkingYears"));
             beginWorkingYears = Integer.valueOf(request.getParameter("beginWorkingYears"));
        }else {
            beginWorkingYears = null;
        }

        if ( !("".equals(request.getParameter("endWorkingYears")))&&request.getParameter("endWorkingYears")!=null){

            endWorkingYears = Integer.valueOf(request.getParameter("endWorkingYears"));
        }else {
            endWorkingYears = null;
        }
        //Integer beginAge = Integer.valueOf(request.getParameter("beginAge"));
//        Integer endAge = Integer.valueOf(request.getParameter("endAge"));
//        Integer beginWorkingYears = Integer.valueOf(request.getParameter("beginWorkingYears"));
//        Integer endWorkingYears = Integer.valueOf(request.getParameter("endWorkingYears"));
        String state = valueOf(request.getParameter("state"));
        Map m =new HashMap();
        m.put("name",name);
        m.put("sex",sex);
        m.put("beginAge",beginAge);
        m.put("endAge",endAge);
        m.put("beginWorkingYears",beginWorkingYears);
        m.put("endWorkingYears",endWorkingYears);
        m.put("state",state);
        m.put("pageNum",pageNum);
        System.out.println(m+"88888888888888888888888888888888888888888");
        PageInfo<User> users = restTemplate.getForObject("http://PROVIDER-SERVER/select?name={name}&sex={sex}&beginAge={beginAge}&endAge={endAge}&beginWorkingYears={beginWorkingYears}&endWorkingYears={endWorkingYears}&state={state}",PageInfo.class,m);
        model.addAttribute("page",users);

        return "usertab";
    }


}
