package com.yuehai.admin.config;

import com.yuehai.admin.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 月海
 * @create 2022/2/11 17:49
 */

/**
 * 1、编写一个拦截器实现HandlerInterceptor接口
 * 2、拦截器注册到容器中（配置类实现 WebMvcConfigurer 接口的 addInterceptors 方法）
 * 3、指定拦截规则【如果是拦截所有，静态资源也会被拦截】
 */
// 告诉 springBoot 这是一个配置类 == 配置文件
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 辨明此为配置 LoginInterceptor 这个拦截器
        registry.addInterceptor(new LoginInterceptor())
                // 所有请求都被拦截包括静态资源
                .addPathPatterns("/**")
                // 放行的请求
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**");
    }
}
