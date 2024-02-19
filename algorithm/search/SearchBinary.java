package org.algorithm.search;

import java.util.Arrays;

/**
 * @Auther: Ban
 * @Date: 2023/4/4 16:42
 * @Description: 二分查找有序序列
 */
public class SearchBinary {

    /**
     * 递归实现
     *
     * @param nums
     * @param target
     * @param left
     * @param right
     * @return
     */
    public static int recursion(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (nums[mid] < target) {
            return recursion(nums, target, mid + 1, right);
        } else if (nums[mid] > target) {
            return recursion(nums, target, left, mid - 1);
        } else {
            return mid;
        }
    }

    /**
     * 基本的二分搜索
     * 非递归实现
     *
     * @param nums
     * @param target
     * @param left
     * @param right
     * @return
     */
    public static int rank(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) { //在右边
                left = mid + 1;
            } else if (nums[mid] > target) { //在左边
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


    /**
     * 基本的二分搜索
     *
     * @param nums
     * @param target
     * @return
     */
    public int binarySearch(int[] nums, int target) {
        // 一左一右两个指针相向而行
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid - 1;
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        Arrays.sort(nums);
        int res = rank(nums, 8, 0, nums.length - 1);
        System.out.println(res);
    }
}
