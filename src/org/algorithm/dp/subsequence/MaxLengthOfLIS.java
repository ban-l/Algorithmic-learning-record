package org.algorithm.dp.subsequence;

import java.util.Arrays;

/**
 * @Auther: Ban
 * @Date: 2023/3/27 10:49
 * @Description: 最长递增子序列
 */
public class MaxLengthOfLIS {

    /**
     * 动态规划
     *
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        int maxLen = 1;
        // 定义：dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度
        int[] dp = new int[nums.length];
        // base case：dp 数组全都初始化为 1，单个数 maxLen为 1
        Arrays.fill(dp, 1);

        for (int i = 0; i < nums.length; i++) { // 状态
            for (int j = 0; j < i; j++) { // 0...i-1，选择最优的
                if (nums[i] > nums[j]) { // 寻找 nums[0..j-1] 中比 nums[i] 小的元素
                    // 把 nums[i] 接在后面，即可形成长度为 dp[j] + 1，
                    // 且以 nums[i] 为结尾的递增子序列
                    dp[i] = Math.max(dp[i], dp[j] + 1); // 有多个结果，取最优
                }
            }
            // 结果
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}
