package com.yuehai.sb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 月海
 * @create 2022/2/11 14:22
 */

// 表明是控制器
@Controller
public class ViewTestController {

    // RESTful 风格的 URI，请求方式为：GET，查询
    @GetMapping("/yuehai")
    // 使用 Model 向 request 域对象共享数据
    public String yuehai(Model model){
        // 向请求域共享数据，参数1为名称，参数2为值
        model.addAttribute("msg", "月海可爱");
        model.addAttribute("link", "https://www.baidu.com/");

        // templates 有自带的前缀 templates 和后缀 .html
        return "success";
    }
}
