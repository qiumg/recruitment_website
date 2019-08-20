package com.website.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/contrjianli")
public class jianlitoudiController {
    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("/toudi")
    public String singleFileUpload(HttpSession session,Integer jId) {
        Integer userid = (Integer) session.getAttribute("userid");
        Map mapInfo = new HashMap();
        mapInfo.put("r1Id", 1001);
        mapInfo.put("jId", 10);
        Boolean s = restTemplate.getForObject("http://PROVIDER-SERVER/contrjianli/toudi?r1Id={r1Id}&jId={jId}", Boolean.class, mapInfo);
        if (s) {
            return "投递成功";
        }
        return "投递失败";
    }
}
