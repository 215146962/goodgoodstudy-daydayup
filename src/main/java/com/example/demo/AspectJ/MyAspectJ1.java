package com.example.demo.AspectJ;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect // 表明当前是一个切面类
@Component
public class MyAspectJ1 {

    /**
     * 切入点表达式
     * execution 定位到目标对象的方法上
     * within 定位到具体的类型上
     * this 代理对象的类型
     * target 目标对象的类型
     * args 参数的类型
     * @args 参数修饰的注解
     * @within 类型修饰的注解
     * @annotation 方法修饰的注解
     */
    /**
     * 一些常用的切入点写法
     * execution(public * *(..))  任意公共方法
     * execution(* set *(..)) 任何一个以set开始的方法
     * execution(* com.example.demo.service.impl.*.*(..)) impl包下任意类名的任意方法
     * execution(* com.example.demo.service..*.*(..)) service包或者子包下任意类名的任意方法
     * execution(* *.service..*.*(..)) 指定只有一级包下的service子包下所有类（接口）中的所有方法为切入点
     * execution(* *..service..*.*(..)) 指定所有包下的service子包下所有类（接口）中的所有方法为切入点
     *
     */

    /**
     * 要增强目标对象的方法
     * 要指定目标对象
     * 第一个*代表所有返回值
     * 第二个*代表类下的所有方法
     * ..代表所有参数
     */
    @Before("pointcut1()") // 切入点表达式
    public void aspectMethod01(){
        System.out.println("MyAspectJ1-----在方法执行前执行-----execution方式切入");
    }

    @Before("execution(* com.example.demo.service.impl.AspectJServiceImpl.fun1(..))")
    public void aspectMethod02(){
        System.out.println("MyAspectJ1-----在方法执行前执行--只执行fun1");
    }

    /**
     * within 指定要切入的类型
     */
    @Before("within(com.example.demo.service.impl.AspectJServiceImpl)")
    public void aspectMethod03(){
        System.out.println("MyAspectJ1-----在方法执行前执行-----within方式切入");
    }

    /**
     * 在AOP中默认使用的是JDK代理模式，如果目标对象有实现代理接口
     * this就是指的是代理对象
     * 如果目标对象没有实现接口，则需要配置默认使用cglib代理对象（怎么配置百度一下）
     */
    @Before("this(com.example.demo.service.impl.AspectJServiceImpl)")
    public void aspectMethod06(){
        System.out.println("MyAspectJ1-----在方法执行前执行-----this方式切入代理对象");
    }

    @Before("target(com.example.demo.service.impl.AspectJServiceImpl)")
    public void aspectMethod07(){
        System.out.println("MyAspectJ1-----在方法执行前执行-----target方式切入目标对象");
    }

    // 会报非法反射的错
//    @Before("args(String)")
//    public void aspectMethod08(){
//        System.out.println("MyAspectJ1-----在方法执行前执行-----args方式切入参数只有String类型的方法");
//    }

    @Before("target(com.example.demo.service.impl.AspectJServiceImpl) && args(String)")
    public void aspectMethod08(){
        System.out.println("MyAspectJ1-----在方法执行前执行-----target和args方式切入参数只有String类型的方法");
    }

    /**
     * MyAnnotation1修饰了User类，那些唯一一个参数是User类的方法就是切点
     * @args 启动报错，有问题，先不研究
     */
//    @Before("@args(com.example.demo.annotation.MyAnnotation1) && within(com.example.demo..*)")
    public void aspectMethod09(){
        System.out.println("MyAspectJ1-----在方法执行前执行-----@args方式切入被MyAnnotation1注解的入参");
    }

    /**
     * 切入被MyAnnotation3注解的类里面的方法
     */
    @Before("@within(com.example.demo.annotation.MyAnnotation3)")
    public void aspectMethod10(){
        System.out.println("MyAspectJ1-----在方法执行前执行-----@within方式切入被MyAnnotation3注解的类里面的方法");
    }

    /**
     * 切入被MyAnnotation2注解的方法
     * 测试fun3
     */
    @Before("@annotation(com.example.demo.annotation.MyAnnotation2)")
    public void aspectMethod11(){
        System.out.println("MyAspectJ1-----在方法执行前执行-----@annotation方式切入被MyAnnotation2注解的方法");
    }



    /**
     * 切入点，可方便复用
     */
    @Pointcut("execution(* com.example.demo.service.impl.AspectJServiceImpl.*(..))")
    public void pointcut1(){

    }
}
