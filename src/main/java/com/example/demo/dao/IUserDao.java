package com.example.demo.dao;

import com.example.demo.entity.User;

import java.util.List;

public interface IUserDao {

    public Integer addUser(User user);
    public Integer addErrorUser(User user);
    public List<User> findAll();
}
