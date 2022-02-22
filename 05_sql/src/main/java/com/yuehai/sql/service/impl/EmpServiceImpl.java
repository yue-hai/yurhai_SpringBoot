package com.yuehai.sql.service.impl;

import com.yuehai.sql.bean.Emp;
import com.yuehai.sql.mapper.EmpMapper;
import com.yuehai.sql.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 月海
 * @create 2022/2/13 14:17
 */

// 表明是 Service 服务层
@Service
public class EmpServiceImpl implements EmpService {

    // 自动注入，根据类型注入
    @Autowired
    EmpMapper empMapper;

    @Override
    public Emp getEmp(Long id) {
        // 根据 id 查询
        return empMapper.getEmp(id);
    }
}
