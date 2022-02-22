package com.yuehai.sb.bean;


import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 只有在容器中的组件，才会拥有SpringBoot提供的强大功能
 */
// 将该组件加入到容器中，这样下面的注解才会生效
@Component
// 配置绑定，prefix：指配置文件中的属性的前缀
@ConfigurationProperties(prefix = "mycar")
// lombok，编译时可生成 无参构造器 方法
@NoArgsConstructor
// lombok，编译时可生成 有参构造器（有所有参数） 方法
@AllArgsConstructor
// lombok，编译时可生成 get/set 方法
@Data
// lombok，编译时可生成 toString 方法
@ToString
// lombok，编译时可生成 重写HashCode 方法
@EqualsAndHashCode
public class Car {
    private String brand;
    private Integer price;
}
