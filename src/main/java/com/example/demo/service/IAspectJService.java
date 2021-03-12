package com.example.demo.service;

import com.example.demo.entity.User;

/**
 * 用于测试AOP切面的Service
 */
public interface IAspectJService {

    public void fun1();
    public String fun2();
    public String fun3(String username);
    public String fun4(User user);
    public String fun5(User user,String str);
    public String fun6(String str);
}
