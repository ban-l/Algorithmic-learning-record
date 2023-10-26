package org.java.general;

/**
 * @Auther: Ban
 * @Date: 2023/7/4 15:20
 * @Description: 接口
 */
public interface InterfaceTest {
    int TEST = 1; // 常量
    void test2(); // 方法
    default void test1() { // 默认方法
        System.out.println("test1");
        // 默认方法可以调用其它方法
        test2();
        test3();
    }
    static void test3() { // 静态方法
        System.out.println("test3");
    }
}
