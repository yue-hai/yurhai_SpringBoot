package com.yuehai.sb.bean;

import lombok.*;

/**
 * @author 月海
 * @create 2022/2/10 13:57
 */

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
public class Pet {
    private String name;
    private Double weight;
}