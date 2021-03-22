package com.example.demo.controller;

import com.example.demo.dao.IUserDao;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * config中有dJdbcTemplate的配置
 */
@Controller
@RequestMapping("/jdbcTemplate")
public class JdbcTemplateController {

    @Autowired
    private IUserDao userDao;

    @PostMapping("/addUser")
    @ResponseBody
    public Integer addUser(User user){
        return userDao.addUser(user);
    }

    @GetMapping("/addErrorUser")
    @ResponseBody
    @Transactional // 加了个注解就可以把这个方法变成事务，平时想的是对的
    public int addErrorUser(){
        User user1 = new User();
        user1.setAge(18);
        user1.setUsername("正确数据");
        user1.setName("正确数据");
        Integer num1 = userDao.addUser(user1);

        User user2 = new User();
        user1.setAge(18);
        user1.setUsername("错误数据");
        user1.setName("错误数据");
        Integer num2 = userDao.addErrorUser(user2); // 这个方法会执行错误

        int total = 0;
        if (num1 != null){
            total += num1;
        }
        if (num2 != null){
            total += num2;
        }
        return total;
    }

    @GetMapping("/findAll")
    @ResponseBody
    public List<User> findAll(){
        return userDao.findAll();
    }



}
