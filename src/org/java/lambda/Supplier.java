package org.java.lambda;

/**
 * @Auther: Ban
 * @Date: 2023/8/6 09:49
 * @Description: <p>
 * 函数式接口
 */
@java.lang.FunctionalInterface
public interface Supplier<T, R> {
    // 如果某个方法除了方法名外，方法参数，返回类型和接口抽象方法恰好一致，就可以直接传入方法引用,覆盖这个接口的抽象方法来调用,给定的方法
    R get(T t);
}
