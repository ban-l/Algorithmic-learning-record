package org.algorithm.backtrack.PCS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: Ban
 * @Date: 2023/7/15 10:39
 * @Description: 组合（元素可重不可复选）
 * <p>
 * 给定一个候选人编号的集合 candidates 和一个目标数 target，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates中的每个数字在每个组合中只能使用一次。 注意：解集不能包含重复的组合。
 */
public class CombinationSum_2 {

    public List<List<Integer>> res = new LinkedList<>(); // 记录结果
    public LinkedList<Integer> track = new LinkedList<>(); // 记录路径
    public int trackSum = 0; // 记录路径和

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        // 先排序，让相同的元素靠在一起
        Arrays.sort(nums);
        // 开启回溯树，最初从下标0开始选择
        backtrack(nums, 0, target);
        return res;
    }

    public void backtrack(int[] nums, int start, int target) {
        // base case，达到目标和，找到符合条件的组合
        if (trackSum == target) {
            res.add(new LinkedList<>(track));
            // 已找到，递归终止，后面的trackSum > target，没必要再继续找了
            return;
        }
        // base case，超过目标和，递归终止
        if (trackSum > target) return;
        // 回溯算法标准框架
        for (int i = start; i < nums.length; i++) {
            // 剪枝
            if (i > start && nums[i] == nums[i - 1]) continue;
            track.add(nums[i]);
            trackSum += nums[i];
            // 通过 start 参数控制树枝的遍历，避免产生重复的子集
            backtrack(nums, i + 1, target);
            track.removeLast();
            trackSum -= nums[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 2, 1, 2};
        int target = 5;
        System.out.println(new CombinationSum_2().combinationSum2(nums, target).toString());
    }
}
