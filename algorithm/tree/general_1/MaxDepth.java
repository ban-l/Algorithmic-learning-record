package org.algorithm.tree.general_1;

import org.algorithm.tree.TreeNode;

/**
 * @Auther: ban
 * @Date: 2022/11/9 16:00
 * @Description: <p>
 * 二叉树最大深度
 * 1.回溯法
 * 2.动态规划法
 */
public class MaxDepth {
    static int res = 0;
    static int depth = 0;

    /**
     * 回溯
     * 用 traverse 函数遍历了一遍二叉树的所有节点，维护 depth 变量，在叶子节点的时候更新最大深度。
     *
     * @param root
     */
    public static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        depth++; // 前序位置
        if (root.left == null && root.right == null) {
            // 到达叶子节点，更新最大深度
            res = Math.max(res, depth);
        }
        traverse(root.left);
        traverse(root.right);
        depth--; // 后序位置
    }


    /**
     * 动态规划：最优子问题
     * 后序遍历
     *
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 左子树的最大深度
        int l = maxDepth(root.left);
        // 右子树的最大深度
        int r = maxDepth(root.right);
        // 后序遍历
        // 取左右子树深度最大值 max，当前节点的深度为max+1
        return Math.max(l, r) + 1;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{
                1,
                2, 5,
                10, 3, 6, 7,
                15, 0, 4, 0, 0, 0, 8, 0,
                20
        };
        // 创建二叉树
        TreeNode root = TreeNode.createBinaryTree(arr, 0);
        // 寻找二叉树最大深度
        traverse(root);
        System.out.println(res);
        int maxdepth = maxDepth(root);
        System.out.println(maxdepth);
    }
}
