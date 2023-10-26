package org.algorithm.search;

import java.util.Random;

/**
 * @Auther: Ban
 * @Date: 2023/8/11 10:24
 * @Description: <p>
 * 按权重随机选择
 * 前缀和 加上 二分搜索详解 能够解决带权重的随机选择算法
 */
public class PickIndex {

    // 前缀和数组
    private int[] preSum;
    private Random rand = new Random();

    // 构造前缀和数组
    public PickIndex(int[] w) {
        preSum = new int[w.length];
        preSum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            preSum[i] = preSum[i - 1] + w[i];
        }
    }

    public int pickIndex() {
        int n = preSum.length;
        // 再加一就是在闭区间 [1, preSum[n - 1]] 中随机选择一个数字
        int r = rand.nextInt(preSum[n - 1]) + 1;
        // 获取 target 在前缀和数组 preSum 中的索引
        return left_bound(preSum, r);
    }

    // 左侧边界搜索
    public int left_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = left + 1;
            } else if (nums[mid] == target) {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        PickIndex p = new PickIndex(new int[]{1, 5, 4, 6, 3});
        System.out.println(p.pickIndex());
    }
}
