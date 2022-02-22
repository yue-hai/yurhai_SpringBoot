package com.yuehai.sql.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * @author 月海
 * @create 2022/2/12 18:16
 */

// 告诉 springBoot 这是一个配置类 == 配置文件
@Configuration
// 配置 mapper 接口文件夹，其他的 mapper 就不用再配置注解
@MapperScan("com.yuehai.sql.mapper")
public class MyDataSourceConfig {

    // 默认的自动配置是判断容器中没有才会配（@ConditionalOnMissingBean(DataSource.class)）
    // 配置绑定，prefix：指配置文件中的属性的前缀
    @ConfigurationProperties("spring.datasource")
    // 在容器中添加德鲁伊的数据源
    @Bean
    public DataSource dataSource() throws SQLException {
        // 创建德鲁伊数据源的实例
        DruidDataSource druidDataSource = new DruidDataSource();

        // 加入监控功能
        druidDataSource.setFilters("stat,wall");
        // 最大活跃线程数
        druidDataSource.setMaxActive(10);

        // 返回德鲁伊数据源的实例
        return druidDataSource;
    }

    /**
     * 配置 druid 的监控页功能
     * @return
     */
    @Bean
    public ServletRegistrationBean statViewServlet(){
        // StatViewServlet 的用途包括：提供监控信息展示的html页面，提供监控信息的JSON API
        StatViewServlet statViewServlet = new StatViewServlet();
        // 拦截的路径，即展示 druid 的监控页的路径
        ServletRegistrationBean<StatViewServlet> registrationBean = new ServletRegistrationBean<>(statViewServlet, "/druid/*");

        // 设置的监控页的账号密码
        registrationBean.addInitParameter("loginUsername","admin");
        registrationBean.addInitParameter("loginPassword","123456");

        // 返回 druid 的监控页
        return registrationBean;
    }

    /**
     * WebStatFilter 用于采集 web-jdbc 关联监控的数据。
     */
    @Bean
    public FilterRegistrationBean webStatFilter(){
        WebStatFilter webStatFilter = new WebStatFilter();

        FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<>(webStatFilter);
        // 拦截的路径，即采集 web-jdbc 关联监控数据的路径
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");

        // 返回过滤器
        return filterRegistrationBean;
    }

}
