package org.algorithm.backtrack.permute;

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

    public static List<List<Integer>> res = new LinkedList<>(); // 结果
    public static LinkedList<Integer> track = new LinkedList<>(); // list记录路径

    public static List<List<Integer>> permute(int[] nums) {
        backtrack(nums);
        return res;
    }

    /**
     * 回溯
     */
    public static void backtrack(int[] nums) {
        // base case，到达叶子节点
        if (track.size() == nums.length) {
            // 找出一个全排列
            res.add(new LinkedList<>(track)); // 不能直接add(list)，list是引用，引用的对象会发生变化。需要这样添加：new ArrayList<>(list)，做拷贝
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 已存在的路径排除,避免重复使用
            if (track.contains(nums[i])) continue;
            track.add(nums[i]); // 做选择
            backtrack(nums); // 进入下一层决策树
            track.removeLast(); // 撤销选择
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        permute(nums);
        System.out.println(res.toString());
    }
}
