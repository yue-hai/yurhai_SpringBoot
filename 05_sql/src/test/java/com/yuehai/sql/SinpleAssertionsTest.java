package com.yuehai.sql;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;

import java.time.Duration;
import java.util.Objects;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author 月海
 * @create 2022/2/13 19:36
 */

// 给这个测试类起一个别名
@DisplayName("Junit5 断言测试类")
public class SinpleAssertionsTest {

    // cal 方法
    public int cal(int i,int j){
        return i + j;
    }

    // 给这个测试方法起一个别名
    @DisplayName("测试简单断言")
    @Test
    public void testSinpleAssertions(){
        // 调用 cal 方法
        int cal = cal(2, 3);
        // 断言，若前面的断言失败，则后面的代码都不会执行

        // assertEquals：判断两个对象或两个原始类型是否相等
        // 参数1：期望的值；参数2：真实测试的值；参数3：错误提示信息（非必须）
        Assertions.assertEquals(6,cal,"业务逻辑计算失败");

        // assertNull：判断给定的对象引用是否为 null
        Assertions.assertNull(cal,"cal 不为空");
    }

    // 给这个测试方法起一个别名
    @DisplayName("测试数组断言")
    @Test
    public void testArray(){
        int[] arr = {1,2};
        int[] arr2 = {2,1};

        // 通过 assertArrayEquals 方法来判断两个对象或原始类型的数组是否相等
        Assertions.assertArrayEquals(arr,arr2,"数组内容不同");
    }

    // 给这个测试方法起一个别名
    @DisplayName("测试组合断言")
    @Test
    public void testAssertAll(){
        // assertAll 方法接受多个函数式接口的实例作为要验证的断言，
        // 可以通过 lambda 表达式很容易的提供这些断言
        // 断言全部成功才会判定为成功
        // 参数1：给这组断言起一个名字；后面的参数：断言的判定项
        Assertions.assertAll("Math",
                // assertEquals：判断两个对象或两个原始类型是否相等
                () -> assertEquals(2, 1 + 2,"不相等"),
                // assertTrue：判断给定的布尔值是否为 true
                () -> assertTrue(1 > 1,"不为 true")
        );
    }

    // 给这个测试方法起一个别名
    @DisplayName("测试异常断言")
    @Test
    public void testException(){
        ArithmeticException exception = Assertions.assertThrows(
            // 断定后面的 lambda 表达式一定会抛出前面的异常
            ArithmeticException.class, () -> System.out.println(1 % 0));
    }

    // 给这个测试方法起一个别名
    @DisplayName("测试超时断言")
    @Test
    public void testTimeout(){
        // 如果测试方法时间超过1s将会异常
        Assertions.assertTimeout(Duration.ofMillis(1000), () -> Thread.sleep(2000));
    }

    // 给这个测试方法起一个别名
    @DisplayName("测试快速失败")
    @Test
    public void shouldFail(){
        // 通过 fail 方法直接使得测试失败
        Assertions.fail("快速失败");
    }

    // 给这个测试方法起一个别名
    @DisplayName("测试前置条件")
    @Test
    public void testAssumptions() {
        Boolean bl = true;

        // 前置条件可以看成是测试方法执行的前提，当该前提不满足时，就没有继续执行的必要
        // assumeTrue：判断给定的布尔值是否为 true
        Assumptions.assumeTrue(bl, "不为 true");
        System.out.println("为 true");

        // assumeFalse：判断给定的布尔值是否为 false
        Assumptions.assumeFalse(bl, "不为 false");
        System.out.println("为 false");
    }

    // 代表本方法不是普通的测试方法，而是一个参数化测试方法
    @ParameterizedTest
    // 为参数化测试指定入参来源，支持八大基础类以及 String 类型，Class 类型
    @ValueSource(strings = {"one", "two", "three"})
    // 给这个测试方法起一个别名
    @DisplayName("参数化测试")
    // String string：接收每次传递过来的 String 类型的参数并赋值
    public void parameterizedTest1(String string) {
        System.out.println(string);
        Assertions.assertTrue(StringUtils.isNotBlank(string));
    }

    // 代表本方法不是普通的测试方法，而是一个参数化测试方法
    @ParameterizedTest
    // 表示读取指定方法的返回值作为参数化测试入参(注意方法返回需要是一个流)
    @MethodSource("method")
    // 给这个测试方法起一个别名
    @DisplayName("方法来源参数化测试")
    public void testWithExplicitLocalMethodSource(String name) {
        System.out.println(name);
        Assertions.assertNotNull(name);
    }

    static Stream<String> method() {
        return Stream.of("apple", "banana");
    }


}
