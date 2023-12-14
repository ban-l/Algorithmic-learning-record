package org.algorithm.math;

import java.util.*;

/**
 * @Auther: Ban
 * @Date: 2023/11/27 10:11
 * @Description: <p>
 * 随机数索引
 * 给你一个可能含有 重复元素 的整数数组 nums ，请你随机输出给定的目标数字 target 的索引。你可以假设给定的数字一定存在于数组中。
 * <p>
 * 实现 Solution 类：
 * <p>
 * Solution(int[] nums) 用数组 nums 初始化对象。
 * int pick(int target) 从 nums 中选出一个满足 nums[i] == target 的随机索引 i 。如果存在多个有效的索引，则每个索引的返回概率应当相等
 */
public class RandomNumberIndex {
    private int[] nums;

    public RandomNumberIndex(int[] nums) {
        this.nums = nums;
    }

    // 1.水样抽样
    public int pick(int target) {
        Random random = new Random();
        int res = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                // 第 count 次遇到target
                count++;
                // 生成一个 [0, count) 之间的整数
                // 1/count 的概率
                if (random.nextInt(count) == 0) {
                    res = i;
                }
            }
        }
        return res;
    }

    // 2.哈希表
    public int pick2(int target) {
        Map<Integer, List<Integer>> pos = new HashMap<>();
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            pos.putIfAbsent(nums[i], new ArrayList<Integer>());
            pos.get(nums[i]).add(i);
        }
        List<Integer> indices = pos.get(target);
        int r = random.nextInt(indices.size());
        return indices.get(r);
    }
}
