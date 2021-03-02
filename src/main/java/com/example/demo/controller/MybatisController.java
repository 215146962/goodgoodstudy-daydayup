package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.IMybatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("mybatis")
public class MybatisController {

    @Autowired
    private IMybatisService mybatisService;

    @GetMapping("getUserListByUser")
    @ResponseBody
    public List<User> getUserListByUser(){
        User user = new User();
        user.setName("李四");
        return mybatisService.getUserListByUser(user);
    }



}
