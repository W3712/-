package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
/**
 * 员工管理Controller
 */
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;

//    @GetMapping("{id}")
//    public String getEmpById(@PathVariable Integer id){
//        Emp emp = empService.getEmpById(id);
//        return emp.toString();
//    }

//    @GetMapping
//    public Result getPageEmp(@RequestParam(defaultValue = "1") Integer page,
//                             @RequestParam(defaultValue = "10") Integer pageSize){
//        PageBean pageBean = empService.getAllEmp(page, pageSize);
//        return Result.success(pageBean);
//    }

    @GetMapping
    public Result getPageByCond(String name, Short gender,
                                @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDateTime begin,
                                @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDateTime end,
                                @RequestParam(defaultValue = "1") Integer page,
                                @RequestParam(defaultValue = "10") Integer pageSize) {
        PageBean pageBean = empService.getEmpByCondation(page, pageSize, name, gender, begin, end);
        return Result.success(pageBean);
    }

//    @DeleteMapping("/{id}")
//    public Result delEmpById(@PathVariable Integer id) {
//        int row = empService.delEmpById(id);
//        if (row > 0) {
//            return Result.success();
//        } else {
//            return Result.error("删除失败！");
//        }
//    }

    @PostMapping
    public Result addEmp(@RequestBody Emp emp) {
        int row = empService.addEmp(emp);
        if (row > 0) {
            return Result.success();
        } else {
            return Result.error("添加失败！");
        }
    }

    @GetMapping("/{id}")
    public Result getEmpById(@PathVariable Integer id) {
        return Result.success(empService.getEmpById(id));
    }

    @PutMapping
    public Result changeEmp(@RequestBody Emp emp) {
        int row = empService.updateEmp(emp);
        if (row > 0) {
            return Result.success();
        } else {
            return Result.error("修改失败！");
        }
    }

    @DeleteMapping("/{ids}")
    public Result delMoreEmpById(@PathVariable("ids") Integer[] arr){
        int row = empService.delMoreEmpById(arr);
        if (row!=arr.length){
            return Result.error("有"+ Integer.toString(arr.length-row) +"条删除失败！");
        }else {
            return Result.success();
        }
    }
}
