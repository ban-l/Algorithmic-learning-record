package org.algorithm.backtrack.PCS;

import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: Ban
 * @Date: 2023/7/17 09:12
 * @Description:
 */
public class CombinationSum_3 {
    public List<List<Integer>> res = new LinkedList<>(); // 记录结果
    public LinkedList<Integer> track = new LinkedList<>(); // 记录回溯路径
    public int trackSum = 0; // 记录 track 中的路径和

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtrack(nums, 0, target);
        return res;
    }

    // 回溯算法
    public void backtrack(int[] nums, int start, int target) {
        // base case，找到目标和，记录结果，结束递归
        if (trackSum == target) {
            res.add(new LinkedList<>(track));
            return;
        }
        // base case，大于目标和，停止向下遍历，结束递归
        if (trackSum > target) {
            return;
        }
        // 回溯算法标准框架
        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            trackSum += nums[i];
            // 通过start参数，控制树枝的遍历
            // start = start，下一层回溯树，可以选自己（一个元素可以无限次使用）
            // start=start+1，下一层回溯树，不可以选自己(一个元素只使用一次)
            backtrack(nums, i, target);
            track.removeLast();
            trackSum -= nums[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 6, 7};
        int target = 7;
        System.out.println(new CombinationSum_3().combinationSum(nums, target).toString());
    }

    // 回溯算法
    public void backtrack(int[] nums, int start) {
        // 前序位置，每个节点的值都是一个子集
        res.add(new LinkedList<>(track));
        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            // 通过start参数，控制树枝的遍历
            // start = start，下一层回溯树，可以选自己（一个元素可以无限次使用）
            // start=start+1，下一层回溯树，不可以选自己(一个元素只使用一次)
            backtrack(nums, i);
            track.removeLast();
        }
    }
}
