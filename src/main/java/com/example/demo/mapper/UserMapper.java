package com.example.demo.mapper;

import com.example.demo.entity.User;

import java.util.List;

public interface UserMapper {
    public List<User> query(User user);

    public void insertUser(User user);
}
