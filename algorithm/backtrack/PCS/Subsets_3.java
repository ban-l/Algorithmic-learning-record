package org.algorithm.backtrack.PCS;

import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: Ban
 * @Date: 2024/2/3 17:59
 * @Description: <p>
 */
public class Subsets_3 {
    public List<List<Integer>> res = new LinkedList<>(); // 记录结果
    public LinkedList<Integer> track = new LinkedList<>(); // 记录回溯路径

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    // 回溯算法
    public void backtrack(int[] nums, int start) {
        // 前序位置，每个节点的值都是一个子集
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            // 通过start参数，控制树枝的遍历
            // start = start，下一层回溯树，可以选自己（一个元素可以无限次使用）
            // start=start+1，下一层回溯树，不可以选自己(一个元素只使用一次)
            backtrack(nums, i);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        System.out.println(new Subsets_3().subsets(nums).toString());
    }


}
