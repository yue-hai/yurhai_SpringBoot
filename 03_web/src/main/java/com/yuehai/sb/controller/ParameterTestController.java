package com.yuehai.sb.controller;

/**
 * @author 月海
 * @create 2022/2/10 19:48
 */

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用于标识一个控制器方法，
 * 并表示这个类中的所有方法的返回值都直接作为响应报文的响应体响应到浏览器
 */
@RestController
public class ParameterTestController {

    // RESTful 风格的 URI，请求方式为：GET，查询
    @GetMapping("/getTest/{id}/{name}")
    // @PathVariable：路径变量：将请求参数中 id 的值赋值给定义的参数 id
    public Map<String,Object> getTest(@PathVariable("id") Integer id,
           @PathVariable("name") String name,
           // 若是 map 集合，则会将所有数据封装到键值对中
           @PathVariable Map<String,String> pv){
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("name",name);
        map.put("pv",pv);

        // 结果：{"pv":{"name":"yuehai","id":"1"},"name":"yuehai","id":1}
        return map;
    }

    // RESTful 风格的 URI，请求方式为：GET，查询
    @GetMapping("/getTest2/{id}/{name}")
    // @RequestHeader("User-Agent")：获取名为 User-Agent 的请求头：将值赋值给定义的参数 userAgent
    // @RequestHeader：获取所有请求头，以键值对的方式方式赋值给集合
    public Map<String,Object> getTest2(@RequestHeader("User-Agent") String userAgent,
                       @RequestHeader Map<String,String> header){
        Map<String,Object> map = new HashMap<>();
        map.put("userAgent",userAgent);
        map.put("header",header);

        // 结果：{"header":{"host":"localhost:8080","connection":"keep-alive","sec-ch-ua":"\" Not A;Brand\";v=\"99\", \"Chromium\";v=\"96\", \"Microsoft Edge\";v=\"96\"","sec-ch-ua-mobile":"?0","sec-ch-ua-platform":"\"Windows\"","upgrade-insecure-requests":"1","user-agent":"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36 Edg/96.0.1054.62","accept":"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9","sec-fetch-site":"same-origin","sec-fetch-mode":"navigate","sec-fetch-user":"?1","sec-fetch-dest":"document","referer":"http://localhost:8080/","accept-encoding":"gzip, deflate, br","accept-language":"zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6","cookie":"Idea-184fc5d2=59f0c5fd-3b4e-417f-82cc-0daaabb2d12c"},"userAgent":"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36 Edg/96.0.1054.62"}
        return map;
    }

    // RESTful 风格的 URI，请求方式为：GET，查询
    @GetMapping("/getTest3")
    // @RequestParam("id")：获取名为 id 的请求参数，并赋值给后面定义的参数
    // @RequestParam：获取所有请求参数，以键值对的方式方式赋值给集合
    public Map<String,Object> getTest3(@RequestParam("id") Integer id,
                                       @RequestParam("name") String name,
                                       @RequestParam Map<String,String> param){
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("name",name);
        map.put("param",param);

        // 结果：{"param":{"id":"1","name":"yuehai"},"name":"yuehai","id":1}
        return map;
    }

    // RESTful 风格的 URI，请求方式为：GET，查询
    @GetMapping("/getTest4")
    // @CookieValue("Idea-184fc5d2")：获取指定名称的 cookie 值
    // @CookieValue("Idea-184fc5d2") Cookie cookie：获取指定名称的 cookie 的全部信息
    public Map<String,Object> getTest4(@CookieValue("Idea-184fc5d2") String idea,
                                       @CookieValue("Idea-184fc5d2") Cookie cookie){
        Map<String,Object> map = new HashMap<>();
        map.put("idea",idea);
        map.put("cookie",cookie);
        // 获取 cookie 的名称：Idea-184fc5d2
        System.out.println(cookie.getName());
        // 获取 cookie 的值：59f0c5fd-3b4e-417f-82cc-0daaabb2d12c
        System.out.println(cookie.getValue());

        // 结果：{"cookie":{"name":"Idea-184fc5d2","value":"59f0c5fd-3b4e-417f-82cc-0daaabb2d12c","version":0,"comment":null,"domain":null,"maxAge":-1,"path":null,"secure":false,"httpOnly":false},"idea":"59f0c5fd-3b4e-417f-82cc-0daaabb2d12c"}
        return map;
    }

    // RESTful 风格的 URI，请求方式为：Post，添加
    @PostMapping("/getTest5")
    // @RequestBody：获取请求体（需请求方式为POST），即表单内容
    public Map<String,Object> getTest5(@RequestBody String content){
        Map<String,Object> map = new HashMap<>();
        map.put("content",content);

        // 结果：{"content":"userName=yuehai&email=123"}
        return map;
    }

    // 矩阵变量链接：/cars/sell;low=34;brand=byd,audi,yd
    // 1、springBoot 默认禁用掉了矩阵变量的功能
    //    手动开启：原理，对于路径的处理，使用 UrlPathHelper 进行解析。
    //    UrlPathHelper 中的属性 removeSemicolonContent（功能：移除分号里的内容）就是来支持矩阵变量的
    //    不能让他移除，所以我们要自定义该属性
    // 2、矩阵变量必须有 url 路径变量才能被解析
    // 3、请求路径需写成：/care/{path}
    @GetMapping("/cars/{path}")
    // @MatrixVariable("low")：取出矩阵变量中指定的值
    public Map careSell(@MatrixVariable("low") Integer low,
                        @MatrixVariable("brand")List<String> brand,
                        // 获取真正的路径
                        @PathVariable("path") String path){
        Map<String,Object> map = new HashMap<>();
        map.put("low",low);
        map.put("brand",brand);
        map.put("path",path);

        // 结果：{"path":"sell","low":34,"brand":["byd","audi","yd"]}
        return map;
    }

    // /boss/1;age=20/2;age=10
    @GetMapping("/boss/{bossId}/{empId}")
    // @MatrixVariable(value = "age",pathVar = "bossId")：获取对应请求地址中 bossId 的 age 的值，并赋值
    // @MatrixVariable(value = "age",pathVar = "empId"：获取对应请求地址中 empId 的 age 的值，并赋值
    public Map boss(@MatrixVariable(value = "age",pathVar = "bossId") Integer bossAge,
                    @MatrixVariable(value = "age",pathVar = "empId") Integer empAge){
        Map<String,Object> map = new HashMap<>();
        map.put("bossAge",bossAge);
        map.put("empAge",empAge);

        // 结果：{"bossAge":20,"empAge":10}
        return map;

    }

}
