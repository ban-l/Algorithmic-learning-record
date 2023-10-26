package org.algorithm.dp.steal;

/**
 * @Auther: Ban
 * @Date: 2023/7/30 10:13
 * @Description: <p>
 */
public class Rob_2 {

    /**
     * 这些房子不是一排，而是围成了一个圈
     * 首先，首尾房间不能同时被抢，那么只可能有三种不同情况：
     * <p>要么都不被抢；
     * <p>要么第一间房子被抢最后一间不抢；
     * <p>要么最后一间房子被抢第一间不抢。
     * <p>取最大值
     *
     * @param nums
     * @return
     */
    public static int rob2(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int n = nums.length;
        // 抢 0 - n-2，最后一间房子不抢
        int res1 = steal(nums, 0, n - 2);
        // 抢 1 - n-1，第一间房子不抢
        int res2 = steal(nums, 1, n - 1);
        // 取最大值
        return Math.max(res1, res2);
    }

    public static int steal(int[] nums, int start, int end) {
        int dp_0 = 0, dp_1 = 0;
        for (int i = start; i <= end; i++) {
            int temp = dp_0;
            // 不抢，取前者（抢，不抢）的最大值
            dp_0 = Math.max(dp_0, dp_1);
            // 抢，取前者（不抢）+现在的值
            dp_1 = temp + nums[i];
        }
        // 返回最大值
        return Math.max(dp_0, dp_1);
    }
}
