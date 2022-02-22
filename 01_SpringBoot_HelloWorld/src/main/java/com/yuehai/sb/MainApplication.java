package com.yuehai.sb;

import com.yuehai.sb.bean.Pet;
import com.yuehai.sb.bean.User;
import com.yuehai.sb.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 月海
 * @create 2022/2/9 14:25
 */

/**
 * 表明这是一个 springBoot 应用
 * 称为主程序类、主配置类
 * scanBasePackages = "com.yuehai"：规定扫描的包为：com.yuehai
 */
// @SpringBootApplication(scanBasePackages = "com.yuehai")

// 下面三个注解与上面一个注解的功能相同
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan("com.yuehai")
public class MainApplication {

    // main 方法，启动 springBoot 应用
    public static void main(String[] args) {
        // 参数1：传入主程序类的 class 对象；参数2：main 方法的 args 参数
        // 1、返回我们IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class,args);

        // 2、查看容器里面的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        // 3、从容器中获取组件
//        Pet tom01 = run.getBean("tom", Pet.class);
//        Pet tom02 = run.getBean("tom", Pet.class);
//        // 组件：true
//        System.out.println("组件：" + (tom01 == tom02));
//
//        // 4、获取配置类的实例
//        MyConfig bean = run.getBean(MyConfig.class);
//        // com.yuehai.sb.config.MyConfig$$EnhancerBySpringCGLIB$$2b5bbc@437ebf59
//        System.out.println(bean);
//
//        /**
//         * 如果 @Configuration(proxyBeanMethods = true) 代理对象调用方法。
//         * SpringBoot 总会检查这个组件是否在容器中有。
//         * 保持组件单实例
//         */
//        User user = bean.user01();
//        User user1 = bean.user01();
//        // true
//        System.out.println(user == user1);

        /**
         * 1、注释掉 @Bean("tom")时，测试容器中是否有 tom 对象
         *      false
         * 2、注释掉 @Bean("tom")，在方法上添加 @ConditionalOnBean(name = "tom") 注解时
         *      false
         * 3、不注释 @Bean("tom")，添加 @ConditionalOnBean(name = "tom") 注解时，
         *      false
         */
        boolean tom = run.containsBean("tom");
        System.out.println(tom);
        /**
         * 1、测试容器中是否有 user01 对象
         *      true
         * 2、测试容器中是否有 user01 对象
         *      false
         * 3、测试容器中是否有 user01 对象
         *      true
         */
        boolean user01 = run.containsBean("user01");
        System.out.println(user01);

        // 测试原生配置文件引入
        boolean user02 = run.containsBean("user02");
        // true
        System.out.println(user02);
        boolean pet02 = run.containsBean("pet02");
        // true
        System.out.println(pet02);

    }
}





















