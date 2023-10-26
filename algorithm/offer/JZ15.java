package org.algorithm.offer;

/**
 * @Auther: Ban
 * @Date: 2023/8/1 11:02
 * @Description: <p>
 * JZ15 二进制中1的个数
 */
public class JZ15 {
    /**
     * 掩码技术
     * 正数
     * 负数，掩码会变成补码显示
     *
     * @param n
     * @return
     */
    public static int NumberOf1(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int temp = n & 1 << i;
            if (temp != 0) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(NumberOf1(-1));
    }
}
