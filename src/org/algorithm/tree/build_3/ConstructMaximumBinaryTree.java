package org.algorithm.tree.build_3;

import org.algorithm.tree.TreeNode;

/**
 * @Auther: Ban
 * @Date: 2023/8/16 11:17
 * @Description: <p>
 */
public class ConstructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    // 前序位置
    public TreeNode build(int[] nums, int lo, int hi) {
        // base case
        if (lo > hi) return null;
        // 找到数组中的最大值，及索引
        int max = nums[lo];
        int index = lo;
        for (int i = lo + 1; i <= hi; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        // 先构造出根节点
        TreeNode root = new TreeNode(max);
        // 递归调用构造左右子树
        root.left = build(nums, lo, index - 1);
        root.right = build(nums, index + 1, hi);
        return root;
    }
}
