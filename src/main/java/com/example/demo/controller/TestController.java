package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("test")
public class TestController {

    @RequestMapping("hello")
    @ResponseBody
    public String hello(){
        return "Do you like van♂ 游戏？";
    }

    @GetMapping("openUploadModelAndView")
    public ModelAndView openUploadModelAndView(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("fileUpload");

        return modelAndView;
    }

    @GetMapping("openUploadWeb")
    public String openUploadWeb(){
        return "fileUpload";
    }

    @PostMapping("upload")
    @ResponseBody
    public String upload(MultipartFile upload,String username){
        System.out.println("----账号：" + username);
        System.out.println("----input的name：" + upload.getName());
        System.out.println("----上传的文件名：" + upload.getOriginalFilename());
        return username;
    }
}
