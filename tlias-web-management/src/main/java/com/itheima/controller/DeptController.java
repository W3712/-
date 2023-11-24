package com.itheima.controller;

import com.itheima.mapper.DeptMapper;
import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 部门管理Controller
 */
@RestController
@RequestMapping("/depts")
public class DeptController {

    @Autowired
    private DeptService deptService;
    @GetMapping
    public Result getAllDept(){
        List<Dept> depts = deptService.getAllDept();
//        int i = 1/0;
        return Result.success(depts);
    }

    @DeleteMapping("/{id}")
    public Result delDeptById(@PathVariable Integer id){
        int i = deptService.delDeptById(id);

        if (i>0){
            return Result.success();
        }else {
            return Result.error("删除失败！");
        }
    }

    @PostMapping
    public Result addDept(@RequestBody Dept dept){
        int row = deptService.addDept(dept);
        if (row>0){
            return Result.success();
        }else {
            return Result.error("添加部门失败！");
        }
    }

    @GetMapping("/{id}")
    public Result getDeptById(@PathVariable Integer id){
        return Result.success(deptService.getDeptById(id));
    }

    @PutMapping
    public Result changeDept(@RequestBody Dept dept){
        int row = deptService.updateDept(dept);
        if (row>0){
            return  Result.success();
        }else {
            return Result.error("修改失败！");
        }
    }
}
