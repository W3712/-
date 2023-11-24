package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 员工管理
 */
@Mapper
public interface EmpMapper {
    @Select("select * from emp where id = #{id}")
    Emp getEmpById(Integer id);

    @Select("select * from emp")
    List<Emp> getAllEmp();

    @Delete("delete from emp where  id = #{id}")
    int delEmpById(Integer id);

    int addEmp(Emp emp);

    int updateEmp(Emp emp);


    List<Emp> getEmpByCondation(String name, Short gender, LocalDateTime begin,LocalDateTime end);

    int delMoreEmpById(Integer[] arr);

    @Select("select * from emp where username=#{username} and `password` = #{password}")
    Emp getEmpByUNAndPW(Emp emp);

    @Delete("delete from emp where dept_id = #{id}")
    int delEmpByDepId(Integer id);
}
