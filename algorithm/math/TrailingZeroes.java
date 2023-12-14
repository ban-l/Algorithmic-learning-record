package org.algorithm.math;

/**
 * @Auther: Ban
 * @Date: 2023/11/28 11:14
 * @Description: <p>
 * 阶乘后的零
 * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 * 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
 */
public class TrailingZeroes {
    public int trailingZeroes(int n) {
        int res = 0;
        long divisor = 5;
        while (divisor <= n) { // 跳出循环
            res += n / divisor; // 5、25、125....提供的5 累加计数
            divisor *= 5; // 更新 divisor：5、25、125....
        }
        return res;
    }
}
