package com.itheima.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyPointCat {
    @Pointcut("execution(* com.itheima.service.*.*(..))")
    public void mycut(){}
}
