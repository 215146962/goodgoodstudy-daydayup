package com.example.demo.AspectJ;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspectJ2 {

    @Pointcut("execution(* com.example.demo.service.impl.AspectJServiceImpl.*(..))")
    public void pointcut(){

    }

    /**
     * 前置通知
     */
    @Before("pointcut()")
    public void before(){
        System.out.println("MyAspectJ2-----执行before方法------前置通知");
    }

    /**
     * 后置通知 获取返回结果
     */
    @AfterReturning(value = "pointcut()",returning = "res")
    public void afterReturning(Object res){
        System.out.println("MyAspectJ2-----执行AfterReturning方法------后置通知-----返回结果：" + res);

    }

    /**
     * 环绕通知
     * proceedingJoinPoint 就是目标方法
     * proceedingJoinPoint.getArgs() 就是获取目标参数
     * proceedingJoinPoint.proceed() 就是目标的执行(如果环绕通知中没有写这一句，那么目标就不会执行)
     * res 就是目标的返回值
     *
     * 注意，如果环绕通知和后置通知同时切入同一个方法，那么环绕通知先获取到返回值，如果不return，那么后置通知就无法获取到返回值
     * @param proceedingJoinPoint
     */
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint){
        Object[] args = proceedingJoinPoint.getArgs();
        System.out.println("MyAspectJ2-----执行around方法------环绕通知------目标执行前-----获取目标对象形参：" + args.toString());
        Object res = null;
        try {
            res = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("MyAspectJ2-----执行around方法------环绕通知------目标执行后-----返回结果：" + res);

        return "环绕通知around的返回值";
    }

    /**
     * 异常通知(好像不太行)
     */
    @AfterThrowing(value = "pointcut()",throwing = "ex")
    public void afterThrowing(Exception ex){
        System.out.println("MyAspectJ2-----执行afterThrowing方法------异常通知-----产生的异常结果：" + ex);

    }

    /**
     * 最终通知(即便是抛异常也会执行)
     */
    @After(value = "pointcut()")
    public void after(){
        System.out.println("MyAspectJ2-----执行after方法------最终通知");

    }
}
