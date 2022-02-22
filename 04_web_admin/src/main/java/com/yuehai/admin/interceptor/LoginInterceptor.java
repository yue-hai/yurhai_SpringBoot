package com.yuehai.admin.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author 月海
 * @create 2022/2/11 17:40
 */

/**
 * 拦截器，实现登录检查
 */
// 注入日志类，以后不用在控制台 打印
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 目标方法执行之前执行
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取请求路径，并在控制台打印
        String requestURI = request.getRequestURI();
        log.info("preHandle拦截的请求路径是{}",requestURI);

        // 登录检查逻辑
        // 获取 session 域中的数据
        HttpSession session = request.getSession();
        Object loginUser = session.getAttribute("loginUser");
        // 根据 session 域中的数据判断是否登录
        if(loginUser != null){
            // // 有数据，则为已登陆，放行
            return true;
        }

        // 没有数据，则为未登陆，拦截住。跳转到登录页
        // 返回提示未登录的消息
        request.setAttribute("msg","请先登录");
        // 请求转发到登录页
        request.getRequestDispatcher("/").forward(request,response);
        // 拦截住
        return false;
    }

    /**
     * 目标方法执行完成以后执行
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle执行{}",modelAndView);
    }

    /**
     * 页面渲染以后执行
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion执行异常{}",ex);
    }
}