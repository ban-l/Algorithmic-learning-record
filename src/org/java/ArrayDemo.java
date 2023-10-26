package org.java;

import java.util.Arrays;

/**
 * @Auther: Ban
 * @Date: 2023/7/27 15:16
 * @Description: <p>
 */
public class ArrayDemo {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3};
        int[] b = a;
        int[] c = Arrays.copyOf(a, a.length);
        System.out.println(a.equals(b)); // true
        System.out.println(a.equals(c)); // false

        // 正数，四舍五入（等于5，向上取整）
        System.out.println(Math.round(1.4)); // 1
        System.out.println(Math.round(1.5)); // 2
        // 负数，四舍五入（等于5，向上取整）
        System.out.println(Math.round(-1.5)); // -1
        System.out.println(Math.round(-1.51)); // -2
    }
}
