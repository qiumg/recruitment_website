package com.website.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/upload/")
public class FileUploadController {
    @RequestMapping("fileupload.do")
    public String singleFileUpload(@RequestParam MultipartFile[] imgs, HttpSession session) throws IOException {
        for (MultipartFile img: imgs) {
            if (!img.isEmpty()) {
                String originalFilename = img.getOriginalFilename();
                //确定文件上传路径
                String uploadPath = "/uploadfile";
                String realPath = session.getServletContext().getRealPath(uploadPath);
                File uploadDir = new File(realPath);
                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                }
                File newFile = new File(uploadDir, originalFilename);
                img.transferTo(newFile);
            } else {
                return "error";
            }
        }
        return "success";
    }

}
