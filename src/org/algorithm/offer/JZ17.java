package org.algorithm.offer;

import java.util.Arrays;

/**
 * @Auther: Ban
 * @Date: 2023/8/7 10:08
 * @Description: <p>
 * 打印从1到最大的n位数
 */
public class JZ17 {
    public static int[] printNumbers(int n) {
        int sum = (int) Math.pow(10, n) - 1;
        int[] res = new int[sum];
        for (int i = 0; i < res.length; i++) {
            res[i] = i + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        printNumbers(1);
    }
}
