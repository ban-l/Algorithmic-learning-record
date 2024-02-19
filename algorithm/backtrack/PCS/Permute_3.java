package org.algorithm.backtrack.PCS;

import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: Ban
 * @Date: 2023/7/13 09:48
 * @Description: 排列问题
 * <p>
 * 排列（元素无重可复选）
 * <p>
 * 比如输入 nums = [1,2,3]，那么这种条件下的全排列共有 3^3 = 27 种：
 * [
 * [1,1,1],[1,1,2],[1,1,3],[1,2,1],[1,2,2],[1,2,3],[1,3,1],[1,3,2],[1,3,3],
 * [2,1,1],[2,1,2],[2,1,3],[2,2,1],[2,2,2],[2,2,3],[2,3,1],[2,3,2],[2,3,3],
 * [3,1,1],[3,1,2],[3,1,3],[3,2,1],[3,2,2],[3,2,3],[3,3,1],[3,3,2],[3,3,3]
 * ]
 */
public class Permute_3 {

    public List<List<Integer>> res = new LinkedList<>(); // 结果
    public LinkedList<Integer> track = new LinkedList<>(); // list记录路径

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums);
        return res;
    }

    /**
     * 回溯
     */
    public void backtrack(int[] nums) {
        // base case，到达叶子节点
        if (track.size() == nums.length) {
            // 收集叶子节点上的值
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            track.add(nums[i]); // 做选择
            backtrack(nums); // 进入下一层决策树
            track.removeLast(); // 撤销选择
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Permute_3().permute(nums).toString());
    }
}
