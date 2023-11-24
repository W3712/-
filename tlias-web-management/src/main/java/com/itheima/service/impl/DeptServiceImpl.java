package com.itheima.service.impl;

import com.itheima.mapper.DeptLogMapper;
import com.itheima.mapper.DeptMapper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Dept;
import com.itheima.pojo.DeptLog;
import com.itheima.service.DeptLogService;
import com.itheima.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private DeptLogService deptLogService;
    @Override
    public List<Dept> getAllDept() {
        return deptMapper.getAllDept();
    }

    @Override
    public int delDeptById(Integer id) {
        Boolean flag = false;
        try {
            int i = deptMapper.delDeptById(id);
//            int a=1;
//            if(a>0){
//                throw new Exception();
//            }
            int j = empMapper.delEmpByDepId(id);
            flag = true;
            return i;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            DeptLog deptLog = new DeptLog();
            deptLog.setCreateTime(LocalDateTime.now());
            deptLog.setDescription("删除了id是"+id+"的部门，执行结果是："+flag);
            deptLogService.addLog(deptLog);
        }
    }

    @Override
    public int addDept(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        return deptMapper.addDept(dept);
    }

    @Override
    public Dept getDeptById(Integer id) {
        return  deptMapper.getDeptById(id);
    }

    @Override
    public int updateDept(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        return deptMapper.updateDept(dept);
    }
}
