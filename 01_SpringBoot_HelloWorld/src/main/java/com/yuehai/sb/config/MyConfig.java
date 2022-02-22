package com.yuehai.sb.config;

import com.yuehai.sb.bean.Car;
import com.yuehai.sb.bean.Pet;
import com.yuehai.sb.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;

/**
 * @author 月海
 * @create 2022/2/9 18:27
 */

/**
 * 告诉 springBoot 这是一个配置类 == 配置文件
 * 1、配置类里面使用 @Bean 标注在方法上给容器注册组件，默认也是单实例的
 * 2、配置类本身也是组件
 * 3、@Configuration(proxyBeanMethods = true)（是否是代理 bean 的方法）
 *      proxyBeanMethods：代理 bean 的方法
 *          Full(proxyBeanMethods = true)、【保证每个@Bean方法被调用多少次返回的组件都是单实例的】
 *          Lite(proxyBeanMethods = false)【每个@Bean方法被调用多少次返回的组件都是新创建的】
 *      组件依赖必须使用Full模式默认。其他默认是否Lite模式
 *
 * 4、@Import({User.class})：给容器中自动创建出这个类型的组件、默认组件的名字就是全类名
 *
 * 5、@ImportResource("classpath:beans.xml")导入 Spring 的配置文件
 */
@Configuration
// 将 User 类添加到容器中
// @Import({User.class})
/**
 * 条件装配：满足 @Conditional 指定的条件，才进行组件注入，
 * 当容器中存在指定的组件（bean） tom 时，才会往容器中注册当前类中的所有组件
 * 此时容器中并没有 tom 组件，本注解的判断又是在本类注册之前，所以也不会被注册
 */
// @ConditionalOnBean(name = "tom")
// 原生配置文件引入
@ImportResource("classpath:beans.xml")
/**
 * 开启 Car 类的属性配置功能
 *  功能：1、开启 Car 配置绑定功能
 *  功能：2、把这个 Car 这个组件自动注册到容器中
 */
// @EnableConfigurationProperties(Car.class)
public class MyConfig {

    /**
     * 给容器中添加组件，以方法名作为组件的 id，
     * 返回类型就是组件类中的这个组件注册方法调用多少次获取的都是之前注册容器中的单实例对象
     */
    // 当容器中存在指定的组件（bean） tom 时才会往容器中注册下面的 user01 组件
    // @ConditionalOnBean(name = "tom")
    @Bean
    public User user01(){
        return new User("月海",14);
    }

    // @Bean("tom")：给组件（实例）设置自定义的名称
    @Bean("tom")
    public Pet tomcatPrt(){
        return new Pet("tomcat");
    }

}
