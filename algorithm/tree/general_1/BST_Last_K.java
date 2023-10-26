package org.algorithm.tree.general_1;

import org.algorithm.tree.TreeNode;

/**
 * @Auther: Ban
 * @Date: 2023/6/26 10:14
 * @Description: 寻找二叉搜索树中的第 k 小的元素
 */
public class BST_Last_K {

    public static int rank = 0;
    public static int res = 0;

    public static void traverse(TreeNode root, int k) {
        if (root == null) return;
        traverse(root.left, k);
        // 中序遍历 BST 从最小开始
        rank++;
        if (rank == k) {
            res = root.val;
            return;
        }
        traverse(root.right, k);
    }


    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 6, 0, 2, 4, 9};
        // 创建二叉树
        TreeNode root = TreeNode.createBinaryTree(arr, 0);
        traverse(root, 5);
        System.out.println(res);
    }
}
