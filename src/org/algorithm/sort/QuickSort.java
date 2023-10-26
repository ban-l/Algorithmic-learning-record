package org.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @Auther: Ban
 * @Date: 2023/9/1 09:07
 * @Description: <p>
 * 快速排序:二叉树的前序遍历
 */
public class QuickSort {

    public static void sort(int[] nums) {
        // 为了避免出现耗时的极端情况，先随机打乱
        shuffle(nums);
        // 排序整个数组（原地修改）
        sort(nums, 0, nums.length - 1);
    }

    // 递归，排序
    public static void sort(int[] nums, int low, int high) {
        // base case
        if (low >= high) {
            return;
        }
        // 一次切分，对 nums[lo..hi] 进行切分
        // 使得 nums[lo..p-1] <= nums[p] < nums[p+1..hi]
        int p = partition(nums, low, high);

        sort(nums, low, p - 1);
        sort(nums, p + 1, high);
    }


    // 选取首元素为枢轴， 对 nums[lo..hi] 进行切分
    // 切分一次，确定一个位置
    public static int partition(int[] nums, int low, int high) {
        int pivot = nums[low]; // 首元素为枢轴
        while (low < high) {
            while (low < high && nums[high] >= pivot) {
                high--;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] <= pivot) {
                low++;
            }
            nums[high] = nums[low];
        }
        // 枢轴最终位置
        nums[low] = pivot;
        return low;
    }

    /**
     * 选取首元素为枢轴， 对 nums[lo..hi] 进行切分
     *
     * 三数取中法，防止首元素较小
     * 取三个数进行排序，将中间数作为枢轴
     * 一般取左端、右端、中间三个数
     */
    public static int partition2(int[] nums, int low, int high) {
        // 三数取中法
        int mid = low + (high - low) / 2; // 计算数组中间的元素的下标
        if (nums[low] > nums[high]) {
            swap(nums, low, high); // 交换，保证左端元素较小
        }
        if (nums[mid] > nums[high]) {
            swap(nums, mid, high); // 交换，保证中间元素较小
        }
        if (nums[mid] > nums[low]) {
            swap(nums, mid, low); // 交换，保证左端元素较小
        }
        // 此时，nums[low]已经成为 左、右、中三数的中间值

        int pivot = nums[low]; // 首元素为枢轴
        while (low < high) {
            while (low < high && nums[high] >= pivot) {
                high--;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] <= pivot) {
                low++;
            }
            nums[high] = nums[low];
        }
        // 枢轴最终位置
        nums[low] = pivot;
        return low;
    }

    // 洗牌算法，将输入的数组随机打乱
    public static void shuffle(int[] nums) {
        Random rand = new Random();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 生成 [i, n - 1] 的随机数
            int r = i + rand.nextInt(n - i);
            swap(nums, i, r);
        }
    }

    // 原地交换数组中的两个元素
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {4, 8, 6, 2, 5, 3, 8, 4, 1, 3, 7, 1};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
