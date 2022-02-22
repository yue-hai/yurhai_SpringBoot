package com.yuehai.sql.controller;

import com.yuehai.sql.bean.Emp;
import com.yuehai.sql.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 月海
 * @create 2022/2/12 19:15
 */

/**
 * 用于标识一个控制器方法，
 * 并表示这个类中的所有方法的返回值都直接作为响应报文的响应体响应到浏览器
 */
@RestController
public class SqlController {

    // 自动注入，根据类型注入
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    EmpService empService;

    @GetMapping("/sql")
    public String queryFromDb(){
        Long aLong = jdbcTemplate.queryForObject("select count(*) from `tbl_emp`", Long.class);
        return "总记录数：" + aLong.toString();
    }

    @GetMapping("/emp")
    public Emp getEmpById(Long id){
        return empService.getEmp(id);
    }

}
