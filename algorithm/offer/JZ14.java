package org.algorithm.offer;

/**
 * @Auther: Ban
 * @Date: 2023/7/27 10:34
 * @Description: <p>
 * 剪绳子
 */
public class JZ14 {

    public static int cutRope(int n) {
        //不超过3直接计算
        if (n <= 3)
            return n - 1;
        //dp[i]表示长度为i的绳子可以被剪出来的最大乘积
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j < i; j++) {
                // 当前长度为 j，最大长度为 dp[j]
                // 基于子问题最优解，推出dp[i]最优解
                // 还剩 i - j 的最大长度，即dp[i-j]
                // dp[j] * dp[i - j]
                dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int res = cutRope(8);
        System.out.println(res);
    }
}
