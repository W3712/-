package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import com.itheima.utils.MyJwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    private EmpService empService;

    @Autowired
    private MyJwt myJwt;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
       emp =  empService.getEmpByUNAndPW(emp);
        Map<String,Object> map = new HashMap<>();
        map.put("Username",emp.getUsername());
       if (emp!= null){
           String token = myJwt.createToken(map, 10L * 60 * 1000);
           return Result.success(token);
       }
       return Result.error("error");
    }
}
