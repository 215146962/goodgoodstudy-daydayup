package com.example.demo.zhujie.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 * 该注解标明要执行哪个类中的哪个方法
 * @author 21514
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface InvokAnno {
	String className();
	String methodName();
}
