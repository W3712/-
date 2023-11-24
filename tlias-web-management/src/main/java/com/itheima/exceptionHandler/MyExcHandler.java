package com.itheima.exceptionHandler;

import com.itheima.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyExcHandler {

    @ExceptionHandler(Exception.class)
    public Result myExc(Exception e){
        e.printStackTrace();
        return Result.error("出BUG了！");
    }
}
