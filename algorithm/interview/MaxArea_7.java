package org.algorithm.interview;

/**
 * @Auther: Ban
 * @Date: 2023/12/22 09:59
 * @Description: <p>
 * 盛最多水的容器
 * <p>
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * <p>
 * 说明：你不能倾斜容器。
 */
public class MaxArea_7 {

    /* 暴力 */
    public int maxArea(int[] height) {
        int res = 0;
        for (int left = 0; left < height.length; left++) {
            for (int right = left + 1; right < height.length; right++) {
                // [left, right] 之间的矩形面积
                int subproblem = Math.min(height[left], height[right]) * (right - left);
                // 更新最大值
                res = Math.max(res, subproblem);
            }
        }
        return res;
    }

    /**
     * 双指针
     * 用 left 和 right 两个指针从两端向中心收缩
     * 一边收缩 一边计算 [left, right] 之间的矩形面积
     * 取最大的面积值即是答案
     */
    public int maxArea_2(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while (left < right) {
            // [left, right] 之间的矩形面积
            int cur_area = Math.min(height[left], height[right]) * (right - left);
            // 更新最大值
            res = Math.max(res, cur_area);
            // 双指针技巧，移动较低的一边
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
