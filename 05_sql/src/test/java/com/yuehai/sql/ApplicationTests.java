package com.yuehai.sql;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class ApplicationTests {

    // 自动注入，根据类型注入
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    DataSource dataSource;

    // 测试完毕后，若是增删改，则自动回滚
    @Transactional
    @Test
    void contextLoads() {
        Long aLong = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM `tbl_emp`", Long.class);
        log.info("总记录数：" + aLong);

        // 结果：数据源类型：class com.alibaba.druid.pool.DruidDataSource
        log.info("数据源类型：" + dataSource.getClass());
    }

}
