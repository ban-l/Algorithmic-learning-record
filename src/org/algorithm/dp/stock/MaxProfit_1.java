package org.algorithm.dp.stock;

/**
 * @Auther: Ban
 * @Date: 2023/7/28 09:26
 * @Description: <p>
 * k = 1 的情况
 * <p>
 * 给你一个整数数组 prices 和一个整数 k ，其中 prices[i] 是某支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class MaxProfit_1 {

    /**
     * 1.暴力解法
     *
     * @param prices
     * @return
     */
    public static int violence(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > max) {
                    max = profit;
                }
            }
        }
        return max;
    }

    /**
     * 2.动态规划
     * dp[i][0] = 0;
     * 根据状态转移方程可得：
     * dp[i][0]
     * = max(dp[-1][0], dp[-1][1] + prices[i])
     * = max(0, -infinity + prices[i]) = 0
     * <p>
     * dp[i][1] = -prices[i];
     * 根据状态转移方程可得：
     * dp[i][1]
     * = max(dp[-1][1], dp[-1][0] - prices[i])
     * = max(-infinity, 0 - prices[i])
     * = -prices[i]
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
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]); // dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][1] -prices[i])
        }
        return dp[n - 1][0];
    }

    //

    /**
     * 3.动态规划,空间复杂度优化版本
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
            // dp[i][1] = max(dp[i-1][1], -prices[i])
            dp_i_1 = Math.max(dp_i_1, -prices[i]);
        }
        return dp_i_0;
    }


    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int res = maxProfit(prices);
        int res2 = maxProfit2(prices);
        System.out.println(res);
        System.out.println(res2);
    }
}
