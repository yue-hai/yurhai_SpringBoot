package com.yuehai.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

// spring 提供的注解，可以将自己写的 servlet 扫描进来
// 可以配置扫描的包，不配置的话默认为主程序类下面的所有包
@ServletComponentScan(basePackages = "com.yuehai.admin.servlet")
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
