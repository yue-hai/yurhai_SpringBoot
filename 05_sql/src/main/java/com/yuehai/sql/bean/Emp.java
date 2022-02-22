package com.yuehai.sql.bean;

import lombok.*;

/**
 * @author 月海
 * @create 2022/2/13 13:58
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
public class Emp {
    private Long empId;
    private String empName;
    private String gender;
    private String email;
    private Long dId;
}
