package com.itheima.service.impl;

import com.itheima.mapper.TliasLogMapper;
import com.itheima.pojo.TliasLog;
import com.itheima.service.TliasLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TliasLogServiceImpl implements TliasLogService {
    @Autowired
    private TliasLogMapper tliasLogMapper;
    @Override
    public int addTliasLog(TliasLog tliasLog) {
       return tliasLogMapper.addTliasLog(tliasLog);
    }
}
