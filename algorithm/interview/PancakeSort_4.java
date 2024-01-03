package org.algorithm.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Ban
 * @Date: 2023/12/18 10:44
 * @Description: <p>
 * 煎饼排序
 * <p>
 * 给你一个整数数组 arr ，请使用 煎饼翻转 完成对数组的排序。
 * 一次煎饼翻转的执行过程如下：
 * 选择一个整数 k ，1 <= k <= arr.length
 * 反转子数组 arr[0...k-1]（下标从 0 开始）
 * 例如，arr = [3,2,1,4] ，选择 k = 3 进行一次煎饼翻转，反转子数组 [3,2,1] ，得到 arr = [1,2,3,4] 。
 * <p>
 * 以数组形式返回能使 arr 有序的煎饼翻转操作所对应的 k 值序列。
 * 任何 将数组排序且 翻转次数 在 10 * arr.length 范围内的有效答案都将被判断为正确。
 */
public class PancakeSort_4 {
    // 记录反转操作序列
    private List<Integer> res = new ArrayList<>();

    public List<Integer> pancakeSort(int[] arr) {
        sort(arr, arr.length);
        return res;
    }

    /**
     * 1.找到最大值索引index
     * 2.第一次翻转，将最大饼翻到最上面：反转数组[0,index]，最大值反转到 索引0
     * 3.第二次翻转，将最大饼翻到最下面：反转数组[0,n-1]，最大值反转到 索引n-1
     * 4.递归调用 n-1
     */
    public void sort(int[] arr, int n) {
        // base case 只有一个元素，不用反转，退出递归
        if (n == 1) {
            return;
        }

        // 1.找到最大值索引index
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }

        // 2.第一次翻转，将最大饼翻到最上面：反转数组[0,index]，最大值反转到 索引0
        reverse(arr, 0, maxIndex);
        res.add(maxIndex + 1); // 记录k：索引+1

        // 3.第二次翻转，将最大饼翻到最下面：反转数组[0,n-1]，最大值反转到 索引n-1
        reverse(arr, 0, n - 1);
        res.add(n); // 记录k：索引+1

        // 递归调用，已经排好序一个，所以长度减1
        sort(arr, n - 1);
    }

    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
