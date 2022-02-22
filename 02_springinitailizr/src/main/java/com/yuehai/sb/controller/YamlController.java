package com.yuehai.sb.controller;

/**
 * @author 月海
 * @create 2022/2/10 14:25
 */

import com.yuehai.sb.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用于标识一个控制器方法，
 * 并表示这个类中的所有方法的返回值都直接作为响应报文的响应体响应到浏览器
 */
@RestController
public class YamlController {

    // 自动注入，根据类型注入
    @Autowired
    Person person;

    // 请求地址，处理用户的 /hello 请求
    @RequestMapping("/person")
    public Person person(){
        // 将 person 对象作为响应报文的响应体响应到浏览器
        return person;
    }
}
