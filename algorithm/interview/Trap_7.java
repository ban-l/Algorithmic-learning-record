package org.algorithm.interview;

/**
 * @Auther: Ban
 * @Date: 2023/12/24 09:29
 * @Description: <p>
 * 接雨水
 * <p>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class Trap_7 {


    /**
     * 思路：仅仅对于位置 i，能装下多少水呢？
     * 位置 i 能达到的水柱高度和其左边的最高柱子 l_max 、右边的最高柱子 r_max 有关
     * 位置 i 最大的水柱高度就是 min(l_max, r_max)
     * 更进一步，对于位置 i，能够装的水为：
     * water[i] = min( max(height[0..i]), max(height[i..end])) - height[i]
     */


    /* 1.暴力 */
    public int trap(int[] height) {
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            /* 当前位置 i */

            // 左边的最高柱子 l_max
            int l_max = 0;
            for (int l = 0; l <= i; l++) {
                if (height[l] > l_max) {
                    l_max = height[l];
                }
            }
            // 右边的最高柱子 r_max
            int r_max = 0;
            for (int r = i; r < height.length; r++) {
                if (height[r] > r_max) {
                    r_max = height[r];
                }
            }
            // 如果自己就是最高的话，l_max == r_max == height[i]

            // 对于位置 i，能够装的水
            int cur = Math.min(l_max, r_max) - height[i];
            // 每个位置的装水量，累加求和
            res += cur;
        }
        return res;
    }

    /**
     * 2.备忘录
     * 两个数组 r_max 和 l_max 充当备忘录
     * l_max[i] 表示位置 i 左边最高的柱子高度
     * r_max[i] 表示位置 i 右边最高的柱子高度
     * 预先把这两个数组计算好，避免重复计算
     */
    public int trap2(int[] height) {
        int res = 0;
        int n = height.length;
        // 数组充当备忘录
        int[] l_max = new int[n];
        int[] r_max = new int[n];
        // base csae
        l_max[0] = height[0];
        r_max[n - 1] = height[n - 1];
        // 从左向右计算 l_max
        for (int i = 1; i < n; i++) {
            l_max[i] = Math.max(height[i], l_max[i - 1]);
        }
        // 从右向左计算 r_max
        for (int i = n - 2; i >= 0; i--) {
            r_max[i] = Math.max(height[i], r_max[i + 1]);
        }
        // 计算答案，累加求和
        for (int i = 0; i < n; i++) {
            int cur = Math.min(l_max[i], r_max[i]) - height[i];
            res += cur;
        }
        return res;
    }

    /**
     * 3.双指针
     * 不用备忘录提前计算
     * 而是用双指针边走边算，节省下空间复杂度
     */
    public int trap3(int[] height) {
        int res = 0;
        int n = height.length;

        // 双指针
        int left = 0, l_max = 0;
        int right = n - 1, r_max = 0;
        while (left < right) {
            // 左边最高的柱子，l_max 是 left 指针左边的最高柱子
            l_max = Math.max(height[left], l_max);
            // 右边的柱子（不一定最高），r_max 并不一定是 left 指针右边最高的柱子
            r_max = Math.max(height[right], r_max);
            // res += min(l_max, r_max) - height[i]
            if (l_max < r_max) {
                res += l_max - height[left];
                left++;
            } else {
                res += r_max - height[right];
                right--;
            }
        }
        return res;
    }
}
