package org.algorithm.dp;

/**
 * @Auther: Ban
 * @Date: 2023/7/5 09:37
 * @Description: 斐波纳契数列
 * 斐波那契数列：1，1，2，3，5，8，13，21，34，55，89...
 * <p>
 * 解决重叠子问题
 */
public class Fib {

    public static int[] memo;

    /***
     * 1.暴力递归
     *
     * 存在重叠子问题（存在大量重复计算,耗时）
     * @param n
     * @return
     */
    public static int fib(int n) {
        if (n == 2 || n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 2.带备忘录的递归解法
     * <p>
     * 每次计算出子问题答案，先记录到备忘录，再返回。
     * <p>
     * 每次遇到一个子问题先去「备忘录」里查一查，如果发现之前已经解决过这个问题了，直接把答案拿出来用，不要再耗时去计算了。
     *
     * @param n
     * @return
     */
    public static int m(int n) {
        if (n == 2 || n == 1) {
            return 1;
        }
        // 查备忘录，存在拿出来用，没有再计算
        if (memo[n] != 0) {
            return memo[n];
        }
        // 每次计算出子问题答案，先记录到备忘录，再返回。
        memo[n] = m(n - 1) + m(n - 2);
        return memo[n];
    }


    /**
     * 3.dp 数组的迭代（递推）解法
     *
     * @param n
     * @return
     */
    public static int dp(int n) {
        if (n == 2 || n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = dp[2] = 1; // base case
        for (int i = 3; i < n + 1; i++) {
            // 状态转移
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    /**
     * 优化
     * 当前状态 n 只和之前的 n-1, n-2 两个状态有关，优化 ，去掉数组，只用两个值(n-1, n-2 )
     *
     * @param n
     * @return
     */
    public static int dp2(int n) {
        int dp_i_1 = 1, dp_i_2 = 1; // base case
        for (int i = 3; i < n + 1; i++) {
            // 状态转移
            int dp_i = dp_i_1 + dp_i_2;
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i_1;
    }

    public static void main(String[] args) {
        // 斐波那契数列：1，1，2，3，5，8，13，21，34，55，89...
        int n = 9;

        // System.out.println(fib(n));

        // 备忘录
        memo = new int[n + 1];
        System.out.println(m(n));

        // dp
        System.out.println(dp(n));
        // dp优化
        System.out.println(dp2(n));
    }
}
