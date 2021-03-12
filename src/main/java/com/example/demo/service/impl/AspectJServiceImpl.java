package com.example.demo.service.impl;

import com.example.demo.annotation.MyAnnotation2;
import com.example.demo.annotation.MyAnnotation3;
import com.example.demo.entity.User;
import com.example.demo.service.IAspectJService;
import org.springframework.stereotype.Service;

@Service
@MyAnnotation3
public class AspectJServiceImpl implements IAspectJService {

    @Override
    public void fun1() {
        System.out.println("---------执行了fun1");
    }

    @Override
    public String fun2() {
        System.out.println("---------执行了fun2");
        return "fun2";
    }

    @MyAnnotation2
    @Override
    public String fun3(String username) {
        System.out.println("---------执行了fun3 username=" + username);
        return username;
    }

    // 测试User被打上注解MyAnnotation1时，该方法是否是切点
    @Override
    public String fun4(User user) {
        System.out.println("---------执行了fun4");
        return "执行了fun4";
    }

    // 测试User被打上注解MyAnnotation1时，该方法是否是切点
    @Override
    public String fun5(User user, String str) {
        System.out.println("---------执行了fun5");
        return "执行了fun5";
    }

    // 用于测试异常通知
    @Override
    public String fun6(String str) {
        System.out.println("---------执行了fun6  str=" + str);
        int i = 1/0;
        return str;
    }


}
