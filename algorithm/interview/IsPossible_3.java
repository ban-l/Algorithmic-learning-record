package org.algorithm.interview;

import java.util.HashMap;

/**
 * @Auther: Ban
 * @Date: 2023/12/18 09:23
 * @Description: <p>
 * 分割数组为连续子序列
 * <p>
 * 给你一个按 非递减顺序 排列的整数数组 nums 。
 * 请你判断是否能在将 nums 分割成 一个或多个子序列 的同时满足下述 两个 条件：
 * 每个子序列都是一个 连续递增序列（即，每个整数 恰好 比前一个整数大 1 ）。
 * 所有子序列的长度 至少 为 3 。
 * 如果可以分割 nums 并满足上述条件，则返回 true ；否则，返回 false 。
 */
public class IsPossible_3 {

    /**
     * 检查序列是否可以被分成长度至少为 3 的连续子序列
     */
    public boolean isPossible(int[] nums) {
        // 维护每个数 在nums数组 出现的次数
        HashMap<Integer, Integer> freq = new HashMap<>();

        // 维护每个数作为结尾的 连续子序列的需求量(多少个子序列需要它)
        HashMap<Integer, Integer> need = new HashMap<>();

        // 遍历nums，统计每个数出现次数
        for (int v : nums) {
            freq.put(v, freq.getOrDefault(v, 0) + 1);
        }

        for (int v : nums) {

            // 已经被用到其他子序列中，无法再被用到
            if (freq.get(v) == 0) {
                continue;
            }

            /* 先判断 v 是否能接到其他子序列后面 */
            // 第一种情况：能，接到其他子序列后面
            if (need.containsKey(v) && need.get(v) > 0) {
                // v 可以接到之前的某个序列后面
                freq.put(v, freq.get(v) - 1);
                // 对 v 的需求减一
                need.put(v, need.get(v) - 1);
                // 对 v + 1 的需求加一
                need.put(v + 1, need.getOrDefault(v + 1, 0) + 1);
            }
            // 第二种情况：不能， 将 v 作为开头，新建一个长度为 3 的子序列 [v,v+1,v+2]
            else if (freq.containsKey(v) && freq.get(v) > 0 && freq.containsKey(v + 1) && freq.get(v + 1) > 0 && freq.containsKey(v + 2) && freq.get(v + 2) > 0) {
                // 新建的子序列 [v,v+1,v+2]，长度为 3
                freq.put(v, freq.get(v) - 1);
                freq.put(v + 1, freq.get(v + 1) - 1);
                freq.put(v + 2, freq.get(v + 2) - 1);
                // 对 v + 3 的需求加一
                need.put(v + 3, need.getOrDefault(v + 3, 0) + 1);
            } else {
                // 两种情况都不符合，则无法分配
                return false;
            }
        }
        return true;
    }
}
