package com.example.demo.globalExceptionHandler;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 方式一
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 专门捕获当前Controller的空指针异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = {NullPointerException.class})
    public String nullPointerException(Exception e, Model model){
        System.out.println("---------" + e.toString());
        model.addAttribute("msg",e.toString());
        return "error";
    }

    @ExceptionHandler(value = {Throwable.class})
    public String throwable(Throwable e, Model model){
        System.out.println("---------" + e.toString());
        model.addAttribute("msg",e.toString());
        return "error";
    }
}
