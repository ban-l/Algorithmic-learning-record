package org.algorithm.dp.stock;

/**
 * @Auther: Ban
 * @Date: 2023/7/30 08:50
 * @Description: <p>
 * 股票买卖问题
 * 状态转移框架
 */
public class Frame {
    /**
     * 状态转移方程
     * dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
     * dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
     *
     * base case
     * dp[-1][...][0] =dp[...][0][0] = 0
     * dp[-1][...][1] =dp[...][0][1] = -infinity
     *
     * k的状态
     * 1、无穷、K
     */
}
