package org.algorithm.dp.game;

import java.util.Arrays;

/**
 * @Auther: Ban
 * @Date: 2023/9/21 08:58
 * @Description: <p>
 * 最小路径和
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 */
public class MinPathSum_1 {
    /**
     * 1.动态规划
     * 自下而上递推求解
     * 状态：网格位置 grid[i][j]
     * <p>
     * 选择：向下、向右
     * <p>
     * dp:(0,0)位置 到 (i,j)位置的最小路径和为dp[i][j]
     * <p>
     * base case:
     * dp[i][0] = dp[i-1][0]+grid[i][0]
     * dp[0][j] = dp[0][j-1]+grid[0][j]
     * <p>
     * 状态转移
     * 基于子问题最优解，根据选择，转移状态
     * dp[i][j] 和 子问题dp[i-1][j]、dp[i][j-1] 有关
     * dp[i][j] = min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n]; //dp
        // base case
        dp[0][0] = grid[0][0];
        // base case 1，第一行的累加和
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        // base case 2，第一列的累加和
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        // 状态转移
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 左、上位置的最小路径和，取较小值，加上当前值
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 2.带备忘录的递归
     * 自上而下，递归求解
     */
    public int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 备忘录，设置特殊值
        memo = new int[m][n];
        for (int[] t : memo) {
            Arrays.fill(t, -1);
        }
        int res = dp(grid, m - 1, n - 1);
        return res;
    }

    private int[][] memo;

    // dp：从(0,0)位置 到 (i,j)位置的最小路径和为dp[i][j]
    public int dp(int[][] grid, int i, int j) {
        // base case
        if (i == 0 && j == 0) {
            return grid[0][0];
        }
        // 如果索引出界，返回一个很大的值，
        // 保证在取 min 的时候不会被取到
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }
        // 备忘录，避免重复计算
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        // // 将计算结果记入备忘录
        // 左、上位置的最小路径和，取较小值，加上当前值
        memo[i][j] = grid[i][j] + Math.min(
                dp(grid, i - 1, j),
                dp(grid, i, j - 1)
        );
        return memo[i][j];
    }
}
