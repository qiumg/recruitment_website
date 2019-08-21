package com.website.client.controller;

import com.website.client.pojo.Result;
import com.website.client.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
@Controller
@RequestMapping("/person")
public class AjaxController{
    @Autowired
    private RestTemplate restTemplate;
    @ResponseBody
    @RequestMapping("/ajaxLogin")
    public Result getUser(HttpServletRequest request, HttpSession session) throws IOException {
        String type = request.getParameter("type");
        Result result = new Result();
        if (type.equals("0")) {
            String newemail = request.getParameter("email");
            String pwd = request.getParameter("password");
            Map map = new HashMap();
            map.put("newemail", newemail);
            map.put("pwd", pwd);
            User s = restTemplate.getForObject("http://PROVIDER-SERVER/login?newemail={newemail}&pwd={pwd}", User.class, map);
            session.setAttribute("user", s);
            if (s == null) {
                result.setMessage("用户名或密码错误，请重新登录");
                return result;
            } else {
                if(s.getState().equals("正常")){
                    result.setMessage("登录成功");
                    result.setSuccess(true);
                    return result;
                }else {
                    result.setMessage("该用户有违规，无法登录");
                    return result;
                }
            }
        } else {
            return result;
        }
    }
    @ResponseBody
    @RequestMapping("/ajaxRegister")
    public Result register(HttpServletRequest request){
        String type = request.getParameter("type");
        Result result = new Result();
        if (type.equals("0")){
            String newemail = request.getParameter("email");
            String pwd = request.getParameter("password");
            Map map = new HashMap();
            map.put("newemail", newemail);
            map.put("pwd", pwd);
            String s = restTemplate.getForObject("http://PROVIDER-SERVER/register?newemail={newemail}&pwd={pwd}", String.class, map);
            if (s != null) {
                result.setMessage("注册成功");
                result.setSuccess(true);
                return result;
            } else {
                result.setMessage("该用户名已存在");
                return result;
            }
        }else {
            return null;
        }
    }
    @ResponseBody
    @RequestMapping("/ajaxReset")
    public Result reset2(HttpServletRequest request){
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        String email = request.getParameter("email");
        System.out.println("5----"+email);
        Result result = new Result();
        result.setData(email);
        result.setPwd1(password1);
        result.setPwd2(password2);
        if (password1.equals(password2)){
            Map map = new HashMap();
            map.put("email",email);
            map.put("password",password1);
            int i = restTemplate.getForObject("http://PROVIDER-SERVER/updatePwd?email={email}&password={password}", int.class, map);
            if (i == 1){
                result.setMessage("修改成功，请登录");
                result.setSuccess(true);
                return result;
            }else {
                result.setMessage("修改出错，请重试");
                return result;
            }
        }else {
            result.setMessage("两次密码不同，请确认后重新输入");
            return result;
        }

    }
    @ResponseBody
    @RequestMapping("/ajaxReset1")
    public Result reset(HttpServletRequest request){
        String email = request.getParameter("email");
        System.out.println("1------"+email);
        Result result = new Result();
        result.setData(email);
        result.setSuccess(true);
        return result;
    }

    @ResponseBody
    @RequestMapping("/ajaxReset2")
    public Result reset1(HttpServletRequest request){
        String email = request.getParameter("email");
        System.out.println("3---"+email);
        Result result = new Result();
        result.setData(email);
        result.setSuccess(true);
        return result;
    }
    @ResponseBody
    @RequestMapping("/update")
    public Result update(HttpServletRequest request,HttpSession session){
        String oldpassword = request.getParameter("oldpassword");
        String newpassword = request.getParameter("newpassword");
        String comfirmpassword = request.getParameter("comfirmpassword");
        User user = (User) session.getAttribute("user");
        String email = user.getEmail();
        Result result = new Result();
        if (newpassword.equals(comfirmpassword)){
            Map map = new HashMap();
            map.put("email",email);
            map.put("oldpassword",oldpassword);
            map.put("newpassword",newpassword);
            int i = restTemplate.getForObject("http://PROVIDER-SERVER/updatePassword?email={email}&oldpassword={oldpassword}&newpassword={newpassword}",int.class,map);
            if (i == 1){
                result.setMessage("修改成功，请重新登录");
                result.setSuccess(true);
                return result;
            }else{
                result.setMessage("旧密码输入错误，请重试");
                return result;
            }
        }else {
            result.setMessage("两次密码输入不同，请重试");
            return result;
        }

    }
}
