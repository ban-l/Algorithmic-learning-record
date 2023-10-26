package org.algorithm.common;

import java.util.Scanner;

public class 辗转相除法 {
    /**
     *
     * 辗转相除法
     *
     * 以除数和余数反复做除法运算，当余数为 0 时，取当前算式除数为最大公约数。
     */
    public static void name() {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        in.close();
        while (b != 0) {
            int temp = a % b;
            a = b; // 除数
            b = temp; // 余数
        }
        System.out.println(a);
    }

    public static void main(String[] args) {
        name();
    }
}
