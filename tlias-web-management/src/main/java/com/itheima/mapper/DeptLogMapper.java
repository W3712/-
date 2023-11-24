package com.itheima.mapper;

import com.itheima.pojo.DeptLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeptLogMapper {
    @Insert("insert into deptlog values (null,#{createTime},#{description})")
    int addLog(DeptLog deptLog);
}
