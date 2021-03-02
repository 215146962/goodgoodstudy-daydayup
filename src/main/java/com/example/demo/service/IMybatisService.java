package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

public interface IMybatisService {
    public List<User> getUserListByUser(User user);
}
