package com.example.demo.globalExceptionHandler;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 方式二
 * 自定义的全局异常
 * 只要实现一个接口方法即可
 */
@Component
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) {
        System.out.println("全局的自定义异常处理触发了------------");

        ModelAndView modelAndView = new ModelAndView();
        if (e instanceof NullPointerException){
            modelAndView.setViewName("error");
            modelAndView.addObject("msg","自定义全局的异常触发:" + e.toString());
        }else if (e instanceof Exception){
            modelAndView.setViewName("error");
            modelAndView.addObject("msg","自定义全局的异常触发:" + e.toString());
        }

        return modelAndView;
    }
}
