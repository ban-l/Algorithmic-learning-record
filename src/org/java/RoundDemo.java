package org.java;

/**
 * @Auther: Ban
 * @Date: 2023/7/27 15:16
 * @Description: <p>
 */
public class RoundDemo {
    public static void main(String[] args) {
        // 正数，四舍五入（等于5，向上取整）
        System.out.println(Math.round(1.4)); // 1
        System.out.println(Math.round(1.5)); // 2
        // 负数，四舍五入（等于5，向上取整）
        System.out.println(Math.round(-1.5)); // -1
        System.out.println(Math.round(-1.51)); // -2
    }
}
