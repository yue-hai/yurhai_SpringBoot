package com.yuehai.admin.controller;

import com.yuehai.admin.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

/**
 * @author 月海
 * @create 2022/2/11 15:03
 */

// 控制页面跳转
// 表明是控制层
@Controller
public class IndexController {

    // 去登录页
    @GetMapping({"/","/login"})
    public String loginPage(){
        // 跳转到类路径下的 templates 文件夹下的 login.html 页面
        return "login";
    }

    // 为防止表单的重复提交，登录成功后重定向到 /main.html 请求
    @PostMapping("/login")
    // 形参位置的形参要与请求参数的名称相同
    // 将登录成功的信息放在 session 域中
    // 将登录失败的信息放在 Model 中，向 request 域对象共享数据
    public String main(User user, HttpSession session, Model model){
        // 判断 传入的用户名 和（&&：与） 密码 是否为空
        if( StringUtils.hasLength(user.getUserName()) && StringUtils.hasLength(user.getPassword()) ){
            // 若不为空，则为登录成功，则将传入（登录成功）的 user 对象放入 session 域中
            session.setAttribute("loginUser",user);
            // 重定向到 /main.html 请求
            return "redirect:/main.html";
        }else{
            // 返回用户名 和（&&：与） 密码 是否为空的消息
            model.addAttribute("msg","请输入账号密码");
            // 若为空，则为登录失败，返回登录页面
            return "login";
        }
    }
    // 跳转到主页
    @GetMapping("/main.html")
    // 将登录成功的信息放在 session 域中
    // 将登录失败的信息放在 Model 中，向 request 域对象共享数据
    public String mainPage(HttpSession session, Model model){
        // 跳转到类路径下的 templates 文件夹下的 main.html 页面
        return "main";
    }
}
