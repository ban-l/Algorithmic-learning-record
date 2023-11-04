package org.algorithm.backtrack.permute;

import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: Ban
 * @Date: 2023/7/14 09:37
 * @Description: 子集问题
 * 子集（元素无重不可复选）
 * <p>
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class Subsets_1 {

    public static List<List<Integer>> res = new LinkedList<>(); // 结果
    public static LinkedList<Integer> track = new LinkedList<>(); // 记录路径
    public static List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }
    // 回溯算法核心函数，遍历子集问题的回溯树
    private static void backtrack(int[] nums, int start) {
        // 前序遍历，记录所有节点的值，每个节点的值都是一个子集
        res.add(new LinkedList<>(track));
        // 回溯框架
        for (int i = start; i < nums.length; i++) { //当 start == nums.length 时，叶子节点的值会被装入 res，但 for 循环不会执行，也就结束了递归。
            // 做选择
            track.add(nums[i]);
            // 只选择start之后的值，通过 start 参数控制树枝的遍历，避免产生重复的子集
            backtrack(nums, i + 1);
            // 撤销选择
            track.removeLast();
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        subsets(nums);
        System.out.println(res.toString());
    }
}
