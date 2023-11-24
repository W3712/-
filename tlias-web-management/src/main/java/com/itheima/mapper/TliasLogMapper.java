package com.itheima.mapper;

import com.itheima.pojo.TliasLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TliasLogMapper {
    @Insert("insert into tliaslog values (null,#{username},#{className},#{argus},#{runTime},#{methodName},#{result}) ")
    public int addTliasLog(TliasLog tliasLog);

}
