package com.itheima.service;

import com.itheima.pojo.DeptLog;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRES_NEW)
public interface DeptLogService {
    int addLog(DeptLog deptLog);
}
