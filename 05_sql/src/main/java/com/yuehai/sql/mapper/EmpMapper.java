package com.yuehai.sql.mapper;

import com.yuehai.sql.bean.Emp;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 月海
 * @create 2022/2/13 13:57
 */

public interface EmpMapper {
    // 根据 id 查询
    public Emp getEmp(Long id);

}
