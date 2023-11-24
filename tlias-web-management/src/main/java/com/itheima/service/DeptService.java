package com.itheima.service;

import com.itheima.pojo.Dept;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 部门管理
 */
@Transactional(rollbackFor = Exception.class)
public interface DeptService {
    List<Dept> getAllDept();

    int delDeptById(Integer id);

    int addDept(Dept dept);

    Dept getDeptById(Integer id);

    int updateDept(Dept dept);
}
