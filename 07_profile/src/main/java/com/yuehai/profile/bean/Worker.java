package com.yuehai.profile.bean;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

// test 测试环境时才使用这个类（default：不配置时默认使用此类）
@Profile(value = {"test","default"})
// lombok，编译时可生成 get/set 方法
@Data
// 将该组件加入到容器中，这样下面的注解才会生效
@Component
// 配置绑定，prefix：指配置文件中的属性的前缀
@ConfigurationProperties("person")
public class Worker implements Person {
    private String name;
    private Integer age;
}
