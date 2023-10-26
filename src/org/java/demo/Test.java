package org.java.demo;

/**
 * @Auther: Ban
 * @Date: 2023/9/17 19:44
 * @Description: <p>
 */
public class Test {
    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 5};
        int[] b = a.clone();
        System.out.println(a == b); // false
        System.out.println(a.equals(b)); // false
    }
}
