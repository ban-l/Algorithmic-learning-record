package org.algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author lbb
 */
public class InsertSort implements BaseSort {
    @Override
    public int[] sort(int[] sourceArray) {
        int[] nums = Arrays.copyOf(sourceArray, sourceArray.length);

        // 当前日期距离1970-01-01 00:00:00的毫秒数
        Long start = System.currentTimeMillis();

        // 假设nums[0]默认有序，外层从下标为 1 开始循环，从后面选择数值 插入已排序的数组(已升序)
        for (int i = 1; i < nums.length; i++) {
            // 记录要插入的值
            int tmp = nums[i];
            // 从已经排序的数据 最右边 开始比较，找到比其小的数
            int j = i;
            // 前面的数 大于 要插入的值，则插入赋值
            while (j > 0 && tmp < nums[j - 1]) {
                nums[j] = nums[j - 1];
                j--;
            }
            // 确定最后位置，找到比其小的数，插入数据
            if (j != i) {
                nums[j] = tmp;
            }
        }

        Long end = System.currentTimeMillis();
        System.out.println("程序执行所花费时间：" + (end - start));
        return nums;
    }

    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        int[] res = insertSort.sort(new int[]{1, 5, 3, 7, 6, 5, 9, 23, 56, 12, 5});
        System.out.println(Arrays.toString(res));
    }
}
