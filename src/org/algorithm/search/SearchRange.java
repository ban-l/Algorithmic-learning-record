package org.algorithm.search;

import java.util.Arrays;

/**
 * @Auther: Ban
 * @Date: 2023/7/22 11:25
 * @Description:
 */
public class SearchRange {

    /**
     * 在排序数组中查找元素的第一个和最后一个位置
     * 二分查找，搜索左、右边界
     * 搜索区间[left,right]
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return new int[]{-1, -1};
        }
        int l = searchLeft(nums, target);
        int r = searchRight(nums, target);
        return new int[]{l, r};
    }

    // 搜索左边界
    public static int searchLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else if (target == nums[mid]) {
                // 别返回，锁定左侧边界
                right = mid - 1;
            }
        }
        // 判断一下 nums[left] 是不是 target
        return nums[left] == target ? left : -1;
    }

    // 搜索右边界
    public static int searchRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else if (target == nums[mid]) {
                // 别返回，锁定右侧边界
                left = mid + 1;
            }
        }
        // 由于 while 的结束条件是 right == left - 1，且现在在求右边界
        // 所以用 right 替代 left - 1 更好记
        return nums[right] == target ? right : -1;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        Arrays.sort(nums);
        int[] res = searchRange(nums, 8);
        System.out.println(Arrays.toString(res));
    }
}
