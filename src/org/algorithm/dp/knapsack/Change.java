package org.algorithm.dp.knapsack;

/**
 * @Auther: Ban
 * @Date: 2023/9/20 09:34
 * @Description: <p>
 * 零钱兑换二
 * <p>
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * <p>
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 * <p>
 * 假设每一种面额的硬币有无限个。
 * <p>
 * 题目数据保证结果符合 32 位带符号整数。
 */
public class Change {
    /**
     * 状态：coins,amount
     * <p>
     * 选择：放、不放
     * <p>
     * dp[i][j]：前i种硬币（可以重复使用），可以凑成总金额j,有 dp[i][j] 种凑法。
     * <p>
     * base case：
     * dp[0][j]=0，0个硬币
     * dp[i][0]=1，总金额为0，什么都不做就是唯一的一种凑法。
     * <p>
     * 状态转移方程：
     * 放不下：
     * dp[i][j] = dp[i-1][j]
     * 放得下：(两种选择，求和)
     * 不放：dp[i][j] = dp[i-1][j]
     * 放：dp[i][j] = dp[i][j-coins]
     * dp[i][j] = dp[i][j-coins] + dp[i-1][j]
     */
    public int change(int amount, int[] coins) {
        int n = coins.length;
        // dp
        int[][] dp = new int[n + 1][amount + 1];
        // base case
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1; // 总金额为0，一种凑法
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                // 状态转移方程
                if (coins[i - 1] > j) { // 放不下
                    dp[i][j] = dp[i - 1][j];
                } else {// 放不下
                    // 两种选择：放、不放，次数求和
                    dp[i][j] = dp[i][j - coins[i - 1]]   // 放，重复使用
                            + dp[i - 1][j];  // 不放，取前i-1种硬币，可以凑成总金额j的硬币组合数
                }
            }
        }
        return dp[n][amount];
    }

    // 空间优化
    public int change2(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        // base case
        dp[0] = 1; // 总金额为0，一种凑法
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                // 状态转移方程
                if (coins[i - 1] <= j) {
                    // 两种选择：放、不放，次数求和
                    dp[j] = dp[j - coins[i - 1]] + dp[j];
                }
            }
        }
        return dp[amount];
    }
}
