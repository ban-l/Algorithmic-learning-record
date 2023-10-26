package org.algorithm.dp.subsequence;

/**
 * @Auther: Ban
 * @Date: 2023/3/25 15:39
 * @Description: 最大连续子序列和
 */
public class MaxSubArray {

    /**
     * 1.贪心法
     * 从左向右迭代，一个个数字加过去，如果sum<0，重新开始找子序串
     *
     * @param nums
     * @return
     */
    public static int greed(int[] nums) {
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum < 0) {
                sum = 0;
            }
            sum += nums[i];
            max = Math.max(max, sum);
        }
        return max;
    }


    /**
     * 2.动态规划
     * 优化：空间压缩
     *
     * @param nums
     */
    public static int dp(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 以每个位置为终点的最大子数列 都是基于其前一位置的最大子数列计算得出（基于前一位置的最优值）
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;

        /*
        if (dp[i - 1] > 0) {
            dp[i] = dp[i - 1] + nums[i];
        } else {
            dp[i] = nums[i];
        }
         */

        /* 空间压缩
        int pre = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            max = Math.max(pre, max);
        }
        return max;
         */
    }


    /**
     * 3.暴力法
     *
     * @param nums
     */
    public static int violence(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            // 从第当前位置开始加
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                // 每加一次，判断取最大
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    /**
     * 4.前缀和思路
     *
     * @param nums
     * @return
     */
    public static int preSum(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        // 构造 nums 的前缀和数组
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        int res = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            // 维护 minVal 是 preSum[0..i] 的最小值
            minVal = Math.min(minVal, preSum[i]);
            // 以 nums[i] 结尾的最大子数组和就是 preSum[i+1] - min(preSum[0..i])
            res = Math.max(res, preSum[i + 1] - minVal);
        }
        return res;
    }

}
