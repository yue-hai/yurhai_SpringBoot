package com.yuehai.sb.controller;

import com.yuehai.sb.bean.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 月海
 * @create 2022/2/9 14:30
 */

// @ResponseBody 用于标识一个控制器方法，
// 可以将该方法的返回值直接作为响应报文的响应体响应到浏览器
// 写在类上，表示这个类中的所有方法上都有该注解
// @ResponseBody
// 表明是 Controller 层
// @Controller

// @RestController：上面上个注解的结合、

/**
 * 用于标识一个控制器方法，
 * 并表示这个类中的所有方法的返回值都直接作为响应报文的响应体响应到浏览器
 */
@RestController
// 注入日志类，以后不用在控制台 打印
@Slf4j
public class HelloController {

    // 自动注入，根据类型注入
    @Autowired
    Car car;

    // 请求地址，处理用户的 /hello 请求
    @RequestMapping("/hello")
    public String hello(){
        // 注入日志类 @Slf4j 的使用
        log.info("请求进来了。。。");
        return "Hello Spring Boot 2";
    }

    @RequestMapping("/car")
    public Car car(){
        return car;
    }
}
