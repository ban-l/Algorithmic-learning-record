package org.algorithm;

import java.util.Scanner;

/**
 * @Auther: Ban
 * @Date: 2023/8/9 10:16
 * @Description: <p>
 */
public class IODemo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 1.输入
        // 一直输入，知道遇到非数值截至
        while (in.hasNextInt()) {
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                int a = in.nextInt();
                int b = in.nextInt();
                System.out.println(a + b);
            }
        }
        in.close();
    }
}
