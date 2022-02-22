package com.yuehai.profile.controller;

import com.yuehai.profile.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 月海
 * @create 2022/2/14 16:25
 */

/**
 * 用于标识一个控制器方法，
 * 并表示这个类中的所有方法的返回值都直接作为响应报文的响应体响应到浏览器
 */
@RestController
public class HelloController {

    // 自定注入，按类型注入
    @Autowired
    private Person person;

//    @GetMapping("/")
//    public String hello(){
//        // 以字符串的形式返回 person 对象的 class 都对象
//        return person.getClass().toString();
//    }

    @GetMapping("/person")
    public Person Person(){
        // 以字符串的形式返回 person 对象的 class 都对象
        return person;
    }
}
