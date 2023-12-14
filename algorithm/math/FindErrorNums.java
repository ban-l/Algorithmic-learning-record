package org.algorithm.math;

import java.util.HashMap;

/**
 * @Auther: Ban
 * @Date: 2023/12/2 09:46
 * @Description: <p>
 * <p>
 * 如何同时寻找缺失和重复的元素
 * 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 */
public class FindErrorNums {
    /* 不使用辅助空间 */
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int dup = -1;
        for (int i = 0; i < n; i++) {
            // 现在的元素是从 1 开始的
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0)
                dup = Math.abs(nums[i]);
            else
                nums[index] *= -1;
        }

        int missing = -1;
        for (int i = 0; i < n; i++)
            if (nums[i] > 0)
                // 将索引转换成元素
                missing = i + 1;

        return new int[]{dup, missing};
    }


    /* 哈希表 */
    public int[] findErrorNums2(int[] nums) {
        int n = nums.length;
        // map统计次数
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int dup = 0, mis = 0;
        // 整数：1 到 n
        for (int i = 1; i <= n; i++) {
            int count = map.getOrDefault(i, 0);
            if (count == 2) { // 出现了两次
                dup = i;
            } else if (count == 0) {  // 没有出现
                mis = i;
            }
        }
        return new int[]{dup, mis};
    }

}
