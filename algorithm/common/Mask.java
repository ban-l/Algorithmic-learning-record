package org.algorithm.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Auther: Ban
 * @Date: 2023/3/13 21:21
 * @Description: <p>
 * 进制转换
 * 位运算
 * 掩码:是一串二进制代码对目标字段进行位与运算，屏蔽当前的输入位。
 * Java中使用补码来表示负数
 */
public class Mask {

    // 短除法
    public static void solution(int n) {
        List<Integer> list = new ArrayList<>();
        while (n != 0) {
            list.add(n % 2);
            n /= 2;
        }
        Collections.reverse(list);
        list.forEach(integer -> System.out.print(integer));
        System.out.println();
    }

    // 掩码
    public static void test(int n) {
        // n = 25;
        // int fourBitFormRight = (n & 0b1000) / 0b1000;
        // int fourBitFormRight = (n & 1<<3) >>3;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            // 左移，右移，得到二进制各个位
            int temp = (n & 1 << i) >> i;
            list.add(temp);
        }
        Collections.reverse(list);
        list.forEach(integer -> System.out.print(integer));
        System.out.println();
    }

    public static void test2(int n) {
        int k = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1 << i) != 0) {
                k++;
            }
        }
        System.out.println(k);
    }


    public static void main(String[] args) {
        int n = 25; // 二进制 11001
//        solution(n);
//        test(n);

        // Integer的toBinaryString方法，十进制转二进制
        System.out.println(Integer.toBinaryString(25));// 二进制
        System.out.println(Integer.toHexString(25)); // 8进制
        System.out.println(Integer.toOctalString(25)); // 16进制

//        System.out.printf("%x \n", 25); // 按8进制输出
//        System.out.printf("%o \n", 25); // 按16进制输出

        System.out.println(Integer.toBinaryString(-1));// 负数，二进制补码表示（32位） 11111111111111111111111111111111
        System.out.println(-1 & (1 << 2));

        test2(1);
    }
}
