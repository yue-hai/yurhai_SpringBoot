package com.yuehai.sql.service;

import com.yuehai.sql.bean.Emp;

/**
 * @author 月海
 * @create 2022/2/13 14:16
 */

public interface EmpService {
    // 根据 id 查询
    public Emp getEmp(Long id);
}
