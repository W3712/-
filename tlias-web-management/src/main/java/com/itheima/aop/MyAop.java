package com.itheima.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
@Slf4j
public class MyAop {
//    @Around("execution(* com.itheima.service.*.*(..))"
    @Around("com.itheima.aop.MyPointCat.mycut()")
    public Object myAop(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Long start = System.currentTimeMillis();
        Object o = proceedingJoinPoint.proceed();
        Long end =  System.currentTimeMillis();
        log.info(proceedingJoinPoint.getSignature()+"此方法的执行时间：{}",end-start);
        return o;
    }


}
