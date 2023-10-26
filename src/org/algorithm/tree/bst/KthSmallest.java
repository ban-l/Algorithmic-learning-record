package org.algorithm.tree.bst;

/**
 * @Auther: Ban
 * @Date: 2023/8/29 11:31
 * @Description: <p>
 * 二叉搜索树中第K小的元素
 */
public class KthSmallest {
    // 记录当前元素的排名
    private int rank = 0;
    // 记录结果
    private int res = 0;

    public int kthSmallest(TreeNode root, int k) {
        // 利用 BST 的中序遍历特性
        traverse(root, k);
        return res;
    }

    public void traverse(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        traverse(root.left, k);
        // 中序遍历 BST, 从最小开始
        rank++;
        if (rank == k) {
            // 找到第 k 小的元素
            res = root.val;
            return;
        }
        traverse(root.right, k);
    }

    static class TreeNode {
        int val;
        // 以该节点为根的树的节点总数
        int size;
        TreeNode left;
        TreeNode right;
    }

}
