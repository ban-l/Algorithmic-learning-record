package org.algorithm.dp.subsequence;

/**
 * @Auther: Ban
 * @Date: 2023/8/8 10:08
 * @Description: <p>
 * 任意子数组和的绝对值的最大值
 */
public class MaxAbsoluteSum {

    /**
     * 1.动态规划法
     * 一个变量绝对值的最大值，可能是这个变量的最大值的绝对值，也可能是这个变量的最小值的绝对值。
     * 分别求出子数组和的最大值和子数组和的最小值，取绝对值最大
     * <p>
     * dp[i]：定义为以第 i 个数nums[i]为结尾，最大/最小子数组和
     *
     * @param nums
     * @return
     */
    public static int maxAbsoluteSum(int[] nums) {
        int max = 0, min = 0;
        int res = 0;
        for (int i : nums) {
            max = Math.max(i, i + max);
            min = Math.min(i, i + min);
            res = Math.max(res, Math.abs(max));
            res = Math.max(res, Math.abs(min));
        }
        return res;
    }

    /**
     * 前缀和
     * 由于子数组和等于两个前缀和的差，那么取前缀和中的最大值与最小值，它俩的差就是答案。
     *
     * @param nums
     * @return
     */
    public static int maxAbsoluteSum2(int[] nums) {
        int max = 0, min = 0;
        int sum = 0;
        for (int i : nums) {
            sum += i;
            // mx = Math.max(mx, s);
            // mn = Math.min(mn, s);
            if (sum > max) max = sum;
            else if (sum < min) min = sum; // 效率更高的写法
        }
        return max - min;
    }


    public static void main(String[] args) {
        int[] nums = {-7, -1, 0, -2, 1, 3, 8, -2, -6, -1, -10, -6, -6, 8, -4, -9, -4, 1, 4, -9};
        int res = maxAbsoluteSum(nums);
        System.out.println(res);
    }
}
