package org.algorithm.dp;

/**
 * @Auther: Ban
 * @Date: 2023/7/5 09:37
 * @Description: <p>
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给定 n ，请计算 F(n) 。
 */
public class Fib {


    /***
     * 1.暴力递归
     * 存在重叠子问题（存在大量重复计算,耗时）
     */
    public int fib(int n) {
        if (n == 1 || n == 0) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 2.带备忘录的递归解法 - 剪枝
     * 每次遇到一个子问题时，先去查备忘录，存在拿出来用，否则计算子问题，答案先记录到备忘录，再返回。
     */
    private int[] memo;

    public int fib2(int n) {
        // 备忘录初始化
        memo = new int[n + 1];
        // 带备忘录的递归
        return f(n);
    }

    public int f(int n) {
        // base case
        if (n == 0 || n == 1) {
            return n;
        }
        // 查备忘录，存在拿出来用，没有再计算
        if (memo[n] != 0) {
            return memo[n];
        }
        // 每次计算出子问题答案，先记录到备忘录，再返回。
        memo[n] = f(n - 1) + f(n - 2);
        return memo[n];
    }


    /**
     * 3.动态规划 - 数组的迭代（递推）解法
     */
    public int dp(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        // base case
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            // 状态转移
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    /**
     * 4.空间优化
     * 当前状态 n 只和之前的 n-1, n-2 两个状态有关，去掉数组，用两个值替代。
     */
    public int dp2(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        // base case
        int dp_i_2 = 0;
        int dp_i_1 = 1;
        for (int i = 2; i <= n; i++) {
            // 状态转移
            int dp_i = dp_i_1 + dp_i_2;
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i_1;
    }

}
