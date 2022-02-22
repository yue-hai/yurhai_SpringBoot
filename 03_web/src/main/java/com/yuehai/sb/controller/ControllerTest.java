package com.yuehai.sb.controller;

/**
 * @author 月海
 * @create 2022/2/10 19:17
 */

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用于标识一个控制器方法，
 * 并表示这个类中的所有方法的返回值都直接作为响应报文的响应体响应到浏览器
 */
@RestController
public class ControllerTest {

    // 请求地址，处理用户的 /hello 请求
    @RequestMapping("/hello")
    // 使用 Model 向 request 域对象共享数据
    public String hello(Model model){
        return "hello";
    }
}
