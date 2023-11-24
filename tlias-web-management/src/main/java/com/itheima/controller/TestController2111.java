package com.itheima.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test1")
public class TestController2111 {
    @GetMapping("{id}")
    public String getById(@PathVariable Integer id){
        System.out.println("拿到了！！！");
        return "ok";
    }
}
