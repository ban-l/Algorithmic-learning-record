package org.algorithm.dp.stock;

/**
 * @Auther: Ban
 * @Date: 2023/7/30 09:11
 * @Description: <p>
 * k = 2 的情况
 */
public class MaxProfit_5 {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int max_k = 2;
        int[][][] dp = new int[n][max_k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int k = max_k; k >= 1; k--) {
                if (i - 1 == -1) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        // 穷举了 n × max_k × 2 个状态，正确。
        return dp[n - 1][max_k][0];
    }


    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int res = maxProfit(prices);
        System.out.println(res);
    }
}
