package com.yuehai.sb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 月海
 * @create 2022/2/10 21:17
 */

// 表明是控制器
@Controller
public class RequestController {

    // 模拟请求转发
    // RESTful 风格的 URI，请求方式为：GET，查询
    @GetMapping("/goto")
    // 使用 servletAPI 向 request 域对象共享数据
    public String gotoPage(HttpServletRequest request){
        // 设置 request 域的内容，参数1为名称，参数2为值
        request.setAttribute("msg","成功");
        request.setAttribute("name","月海");

        // 请求转发到 success 请求
        return "forward:success";
    }

    // RESTful 风格的 URI，请求方式为：GET，查询
    @GetMapping("/success")
    // @ResponseBody用于标识一个控制器方法，
    // 可以将该方法的返回值直接作为响应报文的响应体响应到浏览器
    @ResponseBody
    // @RequestAttribute：获取 request 域属性，获取指定的域对象
    // HttpServletRequest：使用原生 request 获取 request 域属性
    public Map success(@RequestAttribute("msg") String msg,
                       @RequestAttribute("name") String name,
                       HttpServletRequest request){
        // 使用原生 request 获取 request 域指定的属性
        Object msg1 = request.getAttribute("msg");
        Object name1 = request.getAttribute("name");

        Map<String,Object> map = new HashMap<>();
        map.put("annotation_msg",msg);
        map.put("annotation_name",name);
        map.put("reqMethod_msg1",msg1);
        map.put("reqMethod_name1",name1);

        return map;
    }
}
