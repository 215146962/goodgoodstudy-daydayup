package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.IMybatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MybatisService implements IMybatisService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getUserListByUser(User user){
        List<User> userList = userMapper.query(user);
        return userList;
    }

}
