package com.itheima.aop;

import com.itheima.mapper.ControllerRunTimeMapper;
import com.itheima.pojo.ControllerRunTime;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerAop {

    @Autowired
    private ControllerRunTimeMapper controllerRunTimeMapper;

    @Around("execution(* com.itheima.controller.*Controller.*(..))")
    public Object  controllerAop(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Long start = System.currentTimeMillis();
        Object o = proceedingJoinPoint.proceed();
        Long end = System.currentTimeMillis();
        ControllerRunTime controllerRunTime = new ControllerRunTime(null,(end-start));
        int row = controllerRunTimeMapper.addControllerRunTime(controllerRunTime);
        return o;
    }
}
