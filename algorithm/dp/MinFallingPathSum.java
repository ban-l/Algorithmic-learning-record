package org.algorithm.dp;

import java.util.Arrays;

/**
 * @Auther: Ban
 * @Date: 2023/9/9 10:18
 * @Description: <p>
 * 下降路径最小和
 * <p>
 * 给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
 * <p>
 * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。
 * 在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。
 * 具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
 */
public class MinFallingPathSum {


    /**
     * 1.动态规划 [ 自下而上，递推 ]
     * <p>
     * 状态：matrix[i][j]
     * 选择：每个坐标仅可以通过它的上一排紧邻的三个坐标到达（左上，正上，右上）
     * dp[i][j]:从第一行开始，到matrix[i][j]的下降路径最小和
     * base case：
     * 第一行：本身的值
     * 状态转移方程：
     * dp[i][j] = matrix[i][j] + min(dp[i-1][j-1],dp[i-1][j],dp[i-1][j+1]);
     * dp[i][j] 只能由这3中途径获得
     * 边界处理：第一列，最后一列
     */
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        // base case
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j]; // 第一行 dp 为 matrix 本身的值
        }
        for (int i = 1; i < n; i++) { //  从第二行开始，递推求dp
            for (int j = 0; j < n; j++) {
                int min = dp[i - 1][j]; // 正上方一定有值
                if (j - 1 >= 0) { // 第一列，边界处理
                    min = Math.min(min, dp[i - 1][j - 1]);
                }
                if (j + 1 < n) { // 最后一列，边界处理
                    min = Math.min(min, dp[i - 1][j + 1]);
                }
                dp[i][j] = min + matrix[i][j]; // 上一行dp最小值 + matrix[i][j]
            }
        }
        return Arrays.stream(dp[n - 1]).min().getAsInt(); // 返回最后一行的最小值
    }


    /**
     * 2.带备忘录的递归
     * [ 自上而下，递归 ]
     */
    public int solution(int[][] matrix) {
        int n = matrix.length;
        memo = new int[n][n];
        // 备忘录里的值初始化为 66666
        for (int[] temp : memo) {
            Arrays.fill(temp, 66666);
        }
        int res = Integer.MAX_VALUE;
        // 终点可能在最后一行的任意一列，取最小值
        for (int j = 0; j < matrix.length; j++) {
            res = Math.min(res, dp(matrix, n - 1, j));
        }
        return res;
    }

    private int[][] memo; // 备忘录

    // 从第一行开始，到matrix[i][j]的下降路径最小和
    public int dp(int[][] matrix, int i, int j) {
        // 第一列，最后一列，边界处理
        if (j < 0 || j >= matrix.length) {
            return Integer.MAX_VALUE;
        }
        // base case
        if (i == 0) {
            return matrix[i][j];
        }
        // 查备忘录
        if (memo[i][j] != 66666) {
            return memo[i][j];
        }
        // 进行状态转移
        // 取上一排紧邻的三个坐标到达（左上，正上，右上），记录 最小值 + 当前值
        memo[i][j] = matrix[i][j] + min(
                dp(matrix, i - 1, j - 1),
                dp(matrix, i - 1, j),
                dp(matrix, i - 1, j + 1)
        );
        return memo[i][j];
    }

    public int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
