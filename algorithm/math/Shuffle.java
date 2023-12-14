package org.algorithm.math;

import java.util.Arrays;
import java.util.Random;

/**
 * @Auther: Ban
 * @Date: 2023/11/18 11:25
 * @Description: <p>
 * 打乱数组
 * <p>
 * 给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。打乱后，数组的所有排列应该是 等可能 的。
 * <p>
 * 实现 Shuffle class:
 * <p>
 * Shuffle(int[] nums) 使用整数数组 nums 初始化对象
 * int[] reset() 重设数组到它的初始状态并返回
 * int[] shuffle() 返回数组随机打乱后的结果
 */
public class Shuffle {

    /**
     * 分析洗牌算法正确性的准则：产生的结果必须有 n! 种可能。
     * 这个很好解释，因为一个长度为 n 的数组的全排列就有 n! 种，也就是说打乱结果总共有 n! 种。算法必须能够反映这个事实，才是正确的。
     * <p>
     * 有了这个原则再看代码应该就容易理解了：
     * 对于 nums[0]，我们把它随机换到了索引 [0, n) 上，共有 n 种可能性；
     * 对于 nums[1]，我们把它随机换到了索引 [1, n) 上，共有 n - 1 种可能性；
     * 对于 nums[2]，我们把它随机换到了索引 [2, n) 上，共有 n - 2 种可能性；
     * 以此类推，该算法可以生成 n! 种可能的结果，所以这个算法是正确的，能够保证随机性。
     */
    private int[] nums;
    private Random rand = new Random();

    public Shuffle(int[] nums) {
        this.nums = nums;
    }

    public int[] reset() {
        return nums;
    }

    // 洗牌算法
    public int[] shuffle() {
        int n = nums.length;
        int[] copy = Arrays.copyOf(nums, n);
        for (int i = 0; i < n; i++) {
            // 生成一个随机数，范围：[i,n-1]
            int r = i + rand.nextInt(n - i);
            swap(copy, i, r);
        }
        return copy;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
