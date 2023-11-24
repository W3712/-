package com.itheima.service;

import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 员工管理
 */
public interface EmpService {
    Emp getEmpById(Integer id);

    PageBean getAllEmp(Integer pageNumber, Integer pageSize);

    int delEmpById(Integer id);

    int addEmp(Emp emp);

    int updateEmp(Emp emp);

    PageBean getEmpByCondation(Integer page , Integer size,String name, Short gender, LocalDateTime begin, LocalDateTime end);

    int delMoreEmpById(Integer[] arr);

    Emp getEmpByUNAndPW(Emp emp);
}
