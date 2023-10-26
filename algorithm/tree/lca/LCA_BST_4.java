package org.algorithm.tree.lca;

import org.algorithm.tree.TreeNode;

/**
 * @Auther: Ban
 * @Date: 2023/8/29 09:57
 * @Description: <p>
 * 二叉搜索树   的最近公共祖先
 * -两个点
 * -不含重复值
 * -节点存在于二叉树中
 */
public class LCA_BST_4 {

    /**
     * 给你输入一棵不含重复值的 二叉搜索树，以及存在于树中的两个节点 p 和 q，请你计算 p 和 q 的最近公共祖先节点。
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 保证 val1 较小，val2 较大
        int val1 = Math.min(p.val, q.val);
        int val2 = Math.max(p.val, q.val);
        return find(root, val1, val2);
    }

    // 在 BST 中寻找 val1 和 val2 的最近公共祖先节点
    public TreeNode find(TreeNode root, int val1, int val2) {
        if (root == null) {
            return null;
        }
        if (root.val > val2) {
            // 当前节点太大，去左子树找
            return find(root.left, val1, val2);
        }
        if (root.val < val1) {
            // 当前节点太小，去右子树找
            return find(root.right, val1, val2);
        }
        // val1 <= root.val <= val2
        // 则当前节点就是最近公共祖先
        return root;
    }

}
