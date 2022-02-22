package com.yuehai.sql;


import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

/**
 * @author 月海
 * @create 2022/2/13 17:18
 */

// 给这个测试类起一个别名
@DisplayName("Junit5 功能测试类")
public class Junit5Test {

    // 在所有单元测试之前执行，必须为静态方法
    @BeforeAll
    public static void testBeforeAll(){
        System.out.println("所有测试开始----------------");
    }

    // 在每个单元测试之前执行
    @BeforeEach
    public void testBeforeEach(){
        System.out.println("测试开始----------------");
    }

    // 给这个测试方法起一个别名
    @DisplayName("测试 displayName 注解 1")
    @Test
    public void testDisplayName(){
        System.out.println("测试1");
    }

    // 表示方法可重复执行，参数即为重复执行多少次
    @RepeatedTest(5)
    // 表示测试方法运行如果超过了指定时间将会返回错误
    // 参数1：超时时间；参数2：超时时间单位（MILLISECONDS：毫秒）
    // @Timeout(value = 500,unit = TimeUnit.MILLISECONDS)
    // 表示测试类或测试方法不执行
    // @Disabled
    // 给这个测试方法起一个别名
    @DisplayName("测试 displayName 注解 2")
    @Test
    public void testDisplayName2() throws InterruptedException {
        // 睡眠 500 毫秒
        // Thread.sleep(1000);
        System.out.println("测试2");
    }

    // 在每个单元测试之后执行
    @AfterEach
    public void testAfterEach(){
        System.out.println("测试结束----------------");
    }

    // 在所有单元测试之后执行，必须为静态方法
    @AfterAll
    public static void testAfterAll(){
        System.out.println("所有测试结束----------------");
    }

}
