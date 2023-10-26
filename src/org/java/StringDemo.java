package org.java;

/**
 * @Auther: Ban
 * @Date: 2023/7/27 15:16
 * @Description: <p>
 */
public class StringDemo {


    public static void main(String[] args) {
        String s1 = "abcdef"; // 字符串常量池
        String s2 = "xy"; // 字符串常量池
        String s3 = new String("abcdefxy"); // 堆
        String s4 = new String("abcdefxy"); // 堆
        System.out.println(s3 == s4); // 同一性，比较地址， false
        System.out.println(s3.equals(s4)); // 等同性，比较内容，true
    }
}
