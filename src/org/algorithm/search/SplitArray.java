package org.algorithm.search;

/**
 * @Auther: Ban
 * @Date: 2023/8/13 10:14
 * @Description: <p>
 * 分割数组的最大值
 * <p>
 * 给定一个非负整数数组 nums 和一个整数 m ，你需要将这个数组分成 m 个非空的连续子数组。
 * <p>
 * 设计一个算法使得这 m 个子数组各自和的最大值最小。
 */
public class SplitArray {

    public int splitArray(int[] nums, int k) {
        int left = 0;
        int right = 0;
        for (Integer i : nums) {
            left = Math.max(left, i);
            right += i;
        }
        while (left <= right) {
            // x：mid为子数组各自和的最大值，
            // f(x)：find(nums, mid)为，子数组数目，f(x)单调递减
            int mid = left + (right - left) / 2;
            if (find(nums, mid) > k) {
                left = mid + 1;
            } else if (find(nums, mid) < k) {
                right = mid - 1;
            } else if (find(nums, mid) == k) {
                // 找最小的，左边界
                right = mid - 1;
            }
        }
        return left;
    }

    // x，子数组各自和的最大值
    // f(x)，子数组各自和的最大值为x，有f(x)个子数组
    // f(x) 随着 x 的增加单调递减
    public int find(int[] nums, int x) {
        int res = 1;
        int sum = 0;
        for (Integer i : nums) {
            sum += i;
            if (sum > x) {
                res++;
                sum = i;
            }
        }
        return res;
    }


    public static void main(String[] args) {

    }
}
