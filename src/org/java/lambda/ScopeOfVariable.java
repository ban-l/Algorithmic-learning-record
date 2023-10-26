package org.java.lambda;

/**
 * @Auther: Ban
 * @Date: 2023/7/5 14:30
 * @Description:lambda表达式
 * 变量作用域
 */
public class ScopeOfVariable {

    // final 外层局部变量
    public final static String s1 = "lbb";

    public static void main(String[] args) {
        // final 外层局部变量
        final String s2 = "ban";
        // 函数式接口，生成接口对象
        TestInterface t1 = message -> System.out.println(message + "," + s1);
        TestInterface t2 = message -> System.out.println(message + "," + s2);
        t1.sayMessage("hello");
        t2.sayMessage("ban");
    }

    interface TestInterface {
        void sayMessage(String message);
    }

}