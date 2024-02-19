package org.algorithm.backtrack.PCS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: Ban
 * @Date: 2023/7/15 09:45
 * @Description: 子集（元素可重不可复选）
 * <p>
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 */
public class Subsets_2 {

    public List<List<Integer>> res = new LinkedList<>(); // 结果
    public LinkedList<Integer> track = new LinkedList<>(); // 记录路径

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 先排序，让相同的元素靠在一起
        Arrays.sort(nums);
        backtrack(nums, 0);
        return res;
    }

    /**
     * 剪枝，值相同的相邻树枝(跳过)，只遍历第一个
     */
    public void backtrack(int[] nums, int start) {
        // 前序位置，每个节点的值都是一个子集
        res.add(new LinkedList<>(track));
        for (int i = start; i < nums.length; i++) {
            // 剪枝，同一层，发现重复值，跳过
            if (i > start && nums[i] == nums[i - 1]) continue;
            track.add(nums[i]);
            backtrack(nums, i + 1);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        System.out.println(new Subsets_2().subsetsWithDup(nums).toString());
    }
}
