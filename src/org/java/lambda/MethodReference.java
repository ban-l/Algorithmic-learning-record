package org.java.lambda;

import java.util.Arrays;

/**
 * @Auther: Ban
 * @Date: 2023/8/6 08:29
 * @Description: <p>
 * 方法引用
 */
public class MethodReference {

    private String value;

    public MethodReference() {
    }

    public MethodReference(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "MethodReference{" +
                "value='" + value + '\'' +
                '}';
    }

    // 静态方法
    public static int cmp1(String s1, String s2) {
        return s1.compareTo(s2);
    }


    // 实例方法
    public int cmp2(String s1, String s2) {
        return s1.compareTo(s2);
    }

    public static MethodReference newMR(Supplier<String, MethodReference> supplier, String value) {
        return supplier.get(value);
    }


    public static void main(String[] args) {
        /*
        如果某个方法除了方法名外，方法参数，返回类型和接口抽象方法恰好一致，就可以直接传入方法引用,覆盖这个接口的抽象方法,来调用给定的方法
         */

        String[] array = new String[]{"Apple", "Orange", "Banana", "Lemon"};
        // 类::静态方法
        Arrays.sort(array, MethodReference::cmp1);
        // 对象 :: 实例方法
        MethodReference m = new MethodReference();
        Arrays.sort(array, m::cmp2); // 对象引用，对象为null ，会抛出异常
        Arrays.sort(array, (s1, s2) -> s1.compareTo(s2)); // 在调用时才会抛出异常
        // 类 :: 实例方法
        Arrays.sort(array, String::compareTo);
        // 类 :: new，构造器引用
        // Supplier<String, MethodReference> supplier = MethodReference::new;
        // MethodReference mr = supplier.get("方法引用");
        MethodReference mr = newMR(MethodReference::new, "方法引用");
        System.out.println(mr.toString());
    }


}

