package com.yuehai.admin.servlet;


import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * 1、MyServlet --> /my
 * 2、DispatcherServlet --> /
 */

// (proxyBeanMethods = true)：保证依赖的组件始终是单实例的
@Configuration(proxyBeanMethods = true)
public class MyRegistConfig {

    // Servlet
    @Bean
    public ServletRegistrationBean myServlet(){
        // 实例化 Servlet
        MyServlet myServlet = new MyServlet();

        return new ServletRegistrationBean(myServlet,"/my","/my02");
    }

    // 拦截器
    @Bean
    public FilterRegistrationBean myFilter(){
        // 实例化拦截器
        MyFilter myFilter = new MyFilter();

        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(myFilter);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/my","/css/*"));
        return filterRegistrationBean;
    }

    // 监听器
    @Bean
    public ServletListenerRegistrationBean myListener(){
        // 实例化监听器
        MySwervletContextListener mySwervletContextListener = new MySwervletContextListener();

        return new ServletListenerRegistrationBean(mySwervletContextListener);
    }
}
