package org.algorithm.dp.stock;

/**
 * @Auther: Ban
 * @Date: 2023/7/28 10:45
 * @Description: <p>
 * k 为正无穷的情况
 */
public class MaxProfit_2 {
    /**
     * 1.动态规划
     * <p>
     * 交易次数 k 无穷
     * 如果 k 为正无穷，那么就可以认为 k 和 k - 1 是一样的。
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i - 1 == -1) {
                // base case
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    //

    /**
     * 2.动态规划,空间复杂度优化版本
     *
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        int n = prices.length;
        // base case: dp[-1][0] = 0, dp[-1][1] = -infinity
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            // dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            // dp[i][1] = max(dp[i-1][1], dp[i-1][0] -prices[i])
            dp_i_1 = Math.max(dp_i_1, dp_i_0 - prices[i]);
        }
        return dp_i_0;
    }

}
