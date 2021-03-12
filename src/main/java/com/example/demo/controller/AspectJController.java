package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.IAspectJService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用于测试AOP接口
 */
@Controller("aspectJ")
public class AspectJController {

    @Autowired
    private IAspectJService aspectJService;

    @GetMapping("fun1")
    @ResponseBody
    public void fun1(){
        aspectJService.fun1();
    }

    @GetMapping("fun2")
    @ResponseBody
    public void fun2(){
        aspectJService.fun2();
    }

    @GetMapping("fun3")
    @ResponseBody
    public String fun3(String username){
        return aspectJService.fun3(username);
    }

    @GetMapping("fun4")
    @ResponseBody
    public String fun4(){
        return aspectJService.fun4(new User());
    }

    @GetMapping("fun5")
    @ResponseBody
    public String fun5(){
        return aspectJService.fun5(new User(),"fun5");
    }

    @GetMapping("fun6")
    @ResponseBody
    public String fun6(String str){
        return aspectJService.fun6(str);
    }
}
