package org.algorithm.dp.steal;

import java.util.Arrays;

/**
 * @Auther: Ban
 * @Date: 2023/7/30 10:13
 * @Description: <p>
 */
public class Rob {

    /**
     * 1.动态规划
     * <p>
     * 状态 ：nums[i]
     * <p>
     * 选择：抢、不抢
     * <p>
     * dp[i][2]:
     * -dp[i][0]:到第i个房子为止，不抢的最大值
     * -dp[i][1]:到第i个房子为止，抢的最大值
     * <p>
     * base case:
     * i=0:
     * dp[i][0] = 0;
     * dp[i][1]= nums[0]
     * <p>
     * 状态转移方程
     * 不抢：两种情况，取前者(抢，不抢)的最大值
     * -dp[i][0] = max(dp[i-1][0],dp[i-1][1])
     * 抢：取前者(不抢)+现在的值
     * -dp[i][1] = nums[i] + dp[i-1][0]
     */
    public static int rob(int[] nums) {
        int n = nums.length;
        // dp[i][0] dp[i][1]
        int[][] dp = new int[n][2];
        // base case
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        // 状态转移
        for (int i = 1; i < n; i++) {
            // 不抢，两种情况，取前者(抢，不抢)的最大值
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            // 抢，取前者(不抢)+现在的值
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        // 返回最大值
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    // 2.空间压缩
    public static int rob2(int[] nums) {
        int dp_0 = 0, dp_1 = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = dp_0;
            // 不抢，取前者（抢，不抢）的最大值
            dp_0 = Math.max(dp_0, dp_1);
            // 抢，取前者（不抢）+现在的值
            dp_1 = temp + nums[i];
        }
        // 返回最大值
        return Math.max(dp_0, dp_1);
    }


    private int[] memo;

    /**
     * 3.带备忘录的递归
     */
    public int rob3(int[] nums) {
        // 初始化备忘录
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        // 强盗从第 0 间房子开始抢劫
        return dp(nums, 0);
    }

    // 返回 dp[start..] 能抢到的最大值
    public int dp(int[] nums, int start) {
        if (start >= nums.length) {
            return 0;
        }
        // 避免重复计算
        if (memo[start] != -1) {
            return memo[start];
        }
        int res = Math.max(
                dp(nums, start + 1),   // 不抢，去下家（最大值）
                dp(nums, start + 2) + nums[start]   // 抢，去下下家（当前值+下下家）
        );
        // 记入备忘录
        memo[start] = res;
        return memo[start];
    }
}
