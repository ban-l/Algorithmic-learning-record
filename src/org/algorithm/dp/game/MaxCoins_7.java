package org.algorithm.dp.game;

/**
 * @Auther: Ban
 * @Date: 2023/10/3 09:48
 * @Description: <p>
 * 戳气球
 * 有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 * <p>
 * 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。
 * 这里的 i - 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
 * <p>
 * 求所能获得硬币的最大数量。
 */
public class MaxCoins_7 {

    /**
     * 加入两个「虚拟气球」
     * 改变问题：在一排气球 points 中，请你戳破气球 0 和气球 n+1 之间的所有气球（不包括 0 和 n+1），使得最终只剩下气球 0 和气球 n+1 两个气球，最多能够得到多少分？
     * <p>
     * 状态：n+2个气球，气球 i 和气球 j 之间的气球
     * <p>
     * 选择：最后一个戳破气球为 k，i < k <j
     * <p>
     * dp[i][j]:
     * 戳破气球 i 和气球 j 之间（开区间，不包括 i 和 j）的所有气球，可以获得的最高分数为 x。
     * int[][] dp = new int[n + 2][n + 2];
     * <p>
     * base case:
     * dp[i][j] = 0
     * <p>
     * 状态转移方程:
     * 根据选择，选择最后一个戳破气球为 k，i < k <j
     * 最后戳破气球k
     * 1.先把开区间 (i, k) 的气球都戳破
     * 2.再把开区间 (k, j) 的气球都戳破
     * 3.最后剩下气球 i、k、j
     * 4.所以最后戳破气球k得分为：points[i] * points[k] * points[j]
     * <p>
     * 根据dp的定义，如果最后一个戳破气球为k，则dp[i][j]为：
     * dp[i][j] = dp[i][k] +dp[k][j] + points[i] * points[k] * points[j]
     */
    public int maxCoins(int[] nums) {
        int n = nums.length;
        // 添加两侧的虚拟气球
        int[] points = new int[n + 2];
        points[0] = points[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            points[i] = nums[i - 1];
        }
        // base case 已经都被初始化为 0
        int[][] dp = new int[n + 2][n + 2];
        // 开始状态转移
        // i 应该从下往上
        for (int i = n; i >= 0; i--) {
            // j 应该从左往右
            for (int j = i + 1; j < n + 2; j++) {
                // 最后戳破的气球是哪个？
                for (int k = i + 1; k < j; k++) {
                    // 穷举k，选择中取最优
                    dp[i][j] = Math.max(
                            dp[i][j],
                            dp[i][k] + dp[k][j] + points[i] * points[j] * points[k]
                    );
                }
            }
        }
        return dp[0][n + 1];
    }
}
