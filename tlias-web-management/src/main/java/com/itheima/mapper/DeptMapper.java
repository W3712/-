package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 部门管理
 */
@Mapper
public interface DeptMapper {
    @Select("select * from dept")
    List<Dept> getAllDept();
    @Delete("delete from dept where id = #{id}")
    int delDeptById(Integer id);

    int addDept(@Param("dept") Dept dept);
    @Select("select * from dept where id = #{id}")
    Dept getDeptById(Integer id);

    int updateDept(Dept dept);
}
