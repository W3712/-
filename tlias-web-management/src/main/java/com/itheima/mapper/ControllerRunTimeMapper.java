package com.itheima.mapper;

import com.itheima.pojo.ControllerRunTime;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ControllerRunTimeMapper {
    @Insert("insert into controller_run_time values (null,#{RunTime})")
    int addControllerRunTime(ControllerRunTime controllerRunTime);
}
