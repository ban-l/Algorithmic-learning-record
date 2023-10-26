package org.algorithm.sort;

import java.util.Arrays;

/**
 * @Auther: Ban
 * @Date: 2023/9/1 08:57
 * @Description: <p>
 * 归并排序:二叉树的后序遍历
 */
class MergeSort {
    /**
     * 后续遍历
     * 先左、右子树排序
     * 再排序左右子树
     */


    // 用于辅助合并有序数组，记录初始状态，方便归并排序左、右子树
    private static int[] assist;

    public static void sort(int[] nums) {
        // 先给辅助数组开辟内存空间
        assist = new int[nums.length];
        // 排序整个数组（原地修改）
        sort(nums, 0, nums.length - 1);
    }

    // 定义：将子数组 nums[lo..hi] 进行排序
    private static void sort(int[] nums, int lo, int hi) {
        // base case
        if (lo == hi) {
            // 单个元素不用排序
            return;
        }
        int mid = lo + (hi - lo) / 2;  // 这样写是为了防止溢出，效果等同于 (hi + lo) / 2
        sort(nums, lo, mid);  // 先对左半部分数组 nums[lo..mid] 排序
        sort(nums, mid + 1, hi);  // 再对右半部分数组 nums[mid+1..hi] 排序
        /****** 后序位置 ******/
        // 此时两部分子数组已经被排好序
        // 合并 nums[lo..mid] 和 nums[mid+1..hi],使 nums[lo..hi] 有序
        merge(nums, lo, mid, hi);
    }

    /**
     * 合并 nums[lo..mid] 和 nums[mid+1..hi],使 nums[lo..hi] 有序
     * 1.nums复制到 辅助数组assist
     * 2.assist中的两个段，取出记录，进行关键字的比较，较小者放进 nums
     * 3.assist中有一段的下标，超过界限（mid、hi），将另一段剩余部分，复制到 nums
     */
    private static void merge(int[] nums, int lo, int mid, int hi) {
        // 先把 nums[lo..hi] 复制到辅助数组 assist ,以记录原nums 状态，以便合并后的结果 能够直接存入 nums
        for (int i = lo; i <= hi; i++) {
            assist[i] = nums[i]; // 赋值
        }

        // 数组双指针技巧，合并两个有序数组
        int i = lo; // 左半边数组，起始索引
        int j = mid + 1; // 右半边数组，起始索引
        for (int p = lo; p <= hi; p++) {
            if (i == mid + 1) {
                // 左半边数组已全部被合并
                nums[p] = assist[j++];
            } else if (j == hi + 1) {
                // 右半边数组已全部被合并
                nums[p] = assist[i++];
            } else if (assist[i] > assist[j]) {
                nums[p] = assist[j++];
            } else {
                nums[p] = assist[i++];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 8, 6, 2, 5, 3, 8, 4, 1, 3, 7, 1};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
