package org.java.general;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Ban
 * @Date: 2023/7/6 14:51
 * @Description:
 * 泛型方法
 *  方法特定参数 T
 *  方法任意参数 ?
 */
public class Generic {
    public <T> void test(List<T> list) { // 泛型方法，方法参数特定
        list.forEach(i -> System.out.println(i));
    }

    public <T> void test2(List<?> list) { // 泛型方法，通配符类型参数，可以接受任意类型的参数
        list.forEach(i -> System.out.println(i));
    }

    public static void main(String[] args) {
        Generic test = new Generic();
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        // 显式指定类型参数为String
        test.<String>test(list);
        // 自动类型推断，根据参数类型推断类型参数为String
        test.test(list);

        // 通配符类型参数，可以接受任意类型的参数
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        // 可以接受任意类型的参数
        // 方法参数类型（Integer） 不是 泛型方法的类型参数（String）
        test.<String>test2(list2);
    }
}
