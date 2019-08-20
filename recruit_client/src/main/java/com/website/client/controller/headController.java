package com.website.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class headController {
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("/uploadhead")
    public String singleFileUpload(MultipartFile headPortrait, HttpSession session) throws IOException {
        //Integer id= (Integer) session.getAttribute("userid");
        if(!headPortrait.isEmpty()){
            String name = headPortrait.getName();//表单属性名
            String originalFilename = headPortrait.getOriginalFilename();//实际名
            String contentType =  headPortrait.getContentType();//类型
  //          String showurl="/style/images/"+originalFilename;
//            long size =  headPortrait.getSize();//大小
//            String uploadPath = "/uploadfile";//确定文件保存目录
//            String realPath = session.getServletContext().getRealPath(uploadPath);
            File uploadDir = new File("D:\\IntelliJ IDEA 2019.1\\IdeaWork\\recruitment_website1\\recruit_client\\src\\main\\resources\\static\\style\\images\\");
            if(!uploadDir.exists()){
                uploadDir.mkdirs();
            }
            File newFile = new File(uploadDir,originalFilename); //上传文件到指定目录
            headPortrait.transferTo(newFile);
            Map mapInfo = new HashMap();
            mapInfo.put("id", 1001);
            mapInfo.put("headPortrait", originalFilename);
            Boolean s =restTemplate.getForObject("http://PROVIDER-SERVER/user1/uploadhead?id={id}&headPortrait={headPortrait}", Boolean.class, mapInfo);
            if (s) {
                return "redirect:/user/jianli";
            } else return "/index";
        }else{
            return  "index";
        }
    }
}
