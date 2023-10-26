package org.algorithm.tree.lca;

import org.algorithm.tree.TreeNode;

/**
 * @Auther: Ban
 * @Date: 2023/8/29 09:57
 * @Description: <p>
 * 二叉树的最近公共祖先
 * -两个点
 * -不含重复值
 * -节点存在于二叉树中
 */
public class LCA1 {

    /**
     * 给你输入一棵不含重复值的二叉树，以及存在于树中的两个节点 p 和 q，请你计算 p 和 q 的最近公共祖先节点。
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode find(TreeNode root, TreeNode p, TreeNode q) {
        // base case
        if (root == null) {
            return null;
        }
        // 前序位置，看看 root 是不是目标值
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        // 去左、右子树寻找
        TreeNode left = find(root.left, p, q);
        TreeNode rigt = find(root.right, p, q);
        // 如果一个节点能够在它的左、右子树中分别找到 p 和 q，则该节点为 LCA 节点。
        // 后序位置，已经知道左右子树是否存在目标值
        if (left != null && rigt != null) {
            return root;
        }
        // 看哪边找到了
        return left != null ? left : rigt;
    }
}
