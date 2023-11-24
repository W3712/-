package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    @Override
    public Emp getEmpById(Integer id) {
        return empMapper.getEmpById(id);
    }

    @Override
    public PageBean getAllEmp(Integer pageNumber,Integer pageSize) {

//        开启pageHelper分页，并告诉他你想要查询的页数以及每页显示的数量
        PageHelper.startPage(pageNumber,pageSize);

//        查询所有的员工
        List<Emp> empList = empMapper.getAllEmp();

//        把这个集合转为Page<Emp>集合
        Page<Emp> empPage = (Page<Emp>) empList;

//         直接从page对象中获取原始的总数量及集合即可
        long total = empPage.getTotal();
        List<Emp> rows = empPage.getResult();
        PageBean pageBean = new PageBean(total,rows);
        return pageBean;
    }

    @Override
    public int delEmpById(Integer id) {
       return empMapper.delEmpById(id);
    }

    @Override
    public int addEmp(Emp emp) {
        return empMapper.addEmp(emp);
    }

    @Override
    public int updateEmp(Emp emp) {
        return empMapper.updateEmp(emp);
    }

    @Override
    public PageBean getEmpByCondation(Integer page, Integer size, String name, Short gender, LocalDateTime begin, LocalDateTime end) {
//        开启pageHelper分页
        PageHelper.startPage(page,size);
//        把符合条件的集合转为Page集合
        Page p = (Page) empMapper.getEmpByCondation(name,gender,begin,end);
//        封装PageNean对象
        PageBean pb = new PageBean(p.getTotal(),p.getResult());
        return pb;
    }

    @Override
    public int delMoreEmpById(Integer[] arr) {
        return empMapper.delMoreEmpById(arr);
    }

    @Override
    public Emp getEmpByUNAndPW(Emp emp) {
        return empMapper.getEmpByUNAndPW(emp);
    }
}
