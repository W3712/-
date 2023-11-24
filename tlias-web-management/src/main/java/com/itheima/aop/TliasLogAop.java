package com.itheima.aop;

import com.itheima.intercepter.MyIntercepter;
import com.itheima.pojo.TliasLog;
import com.itheima.service.TliasLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class TliasLogAop {

    @Autowired
    private TliasLogService tliasLogService;


    @Around("execution(int com.itheima.service.DeptService.*(..))||execution(int com.itheima.service.EmpService.*(..))")
    public Object getTliasLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        long start = System.currentTimeMillis();

        Object proceed = proceedingJoinPoint.proceed();

        long end = System.currentTimeMillis();
//        获取目标类的类名
        String simpleName = proceedingJoinPoint.getTarget().getClass().getSimpleName();
//        获取操作人信息
        String username = (String) MyIntercepter.threadLocal.get();
//      获取切点名称
        String name = proceedingJoinPoint.getSignature().getName();
//          获取参数数组
        Object[] args = proceedingJoinPoint.getArgs();
        TliasLog tliasLog = new TliasLog(null,username,simpleName, Arrays.toString(args),end-start,name,proceed.toString());

        int row = tliasLogService.addTliasLog(tliasLog);
        return proceed;
    }
}
