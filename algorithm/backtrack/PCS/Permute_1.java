package org.algorithm.backtrack.PCS;

import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: Ban
 * @Date: 2023/7/13 09:48
 * @Description: 排列问题
 * <p>
 * 排列（元素无重不可复选）
 * <p>
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class Permute_1 {

    public List<List<Integer>> res = new LinkedList<>(); // 记录结果
    public LinkedList<Integer> track = new LinkedList<>(); // 记录路径

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums);
        return res;
    }

    // 回溯
    public void backtrack(int[] nums) {
        // 结束条件，base case，到达叶子节点
        if (track.size() == nums.length) {
            // 找出一个全排列，退出。不能直接add(track)，track引用的对象一直在变化，最后track为空，导致res添加的所有track也全都为空。
            res.add(new LinkedList<>(track));
            return;
        }
        // 选择列表
        for (int i = 0; i < nums.length; i++) {
            // 已存在的路径排除,避免重复使用
            if (track.contains(nums[i])) continue;
            track.add(nums[i]); // 前序位置，做选择
            backtrack(nums); // 进入下一层决策树
            track.removeLast(); // 后序位置，撤销选择
        }
    }

    // 求元素个数为 k 的排列
    public void backtrack(int[] nums, int k) {
        if (track.size() == k) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) continue;
            track.add(nums[i]);
            backtrack(nums, k);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        Permute_1 p = new Permute_1();
        p.permute(new int[]{1, 2, 3});
        for (List list : p.res) {
            System.out.println(list);
        }
    }
}
