package org.algorithm.sort;

import java.util.Random;

/**
 * @Auther: Ban
 * @Date: 2023/9/1 10:54
 * @Description: <p>
 * 数组中的第K个最大元素
 * 解法：快速排序
 */
public class FindKthLargest {

    /**
     * 第k大的元素，即升序排序后，第n-k个位置的元素，rank = n-k
     * partition 函数会将 nums[p] 排到正确的位置，p为排名
     * rank 和 p比较
     * 如果 p < rank 说明 rank 在 nums[p+1..hi] 中
     * 如果 p > rank 说明 rank 在 nums[lo..p-1] 中
     * 进一步，去 nums[p+1..hi] 或者 nums[lo..p-1] 这两个子数组中执行 partition 函数，就可以进一步缩小排在第 rank 的元素的范围，最终找到目标元素。
     */
    public int findKthLargest(int[] nums, int k) {
        // 首先随机打乱数组
        shuffle(nums);
        int low = 0, high = nums.length - 1;
        // 第K个最大元素 转化成「排名第 rank 的元素」
        int rank = nums.length - k;
        while (low <= high) {
            // 切分一次，确定一个位置，排名为 pivot，值为 nums[pivot]
            int p = partition(nums, low, high);
            if (p == rank) { // 找到 排名第 rank 的元素
                return nums[p];
            } else if (p < rank) { // 元素在 nums[p+1..hi]
                low = p + 1;
            } else if (p > rank) { // 元素在 nums[lo..p-1]
                high = p - 1;
            }
        }
        return -1;
    }

    // 选取首元素为枢轴， 对 nums[lo..hi] 进行切分
    // 切分一次，确定一个位置
    public int partition(int[] nums, int low, int high) {
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
    public void shuffle(int[] nums) {
        Random rand = new Random();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 生成 [i, n - 1] 的随机数
            int r = i + rand.nextInt(n - i);
            swap(nums, i, r);
        }
    }

    // 原地交换数组中的两个元素
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
