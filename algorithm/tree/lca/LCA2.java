package org.algorithm.tree.lca;

import org.algorithm.tree.TreeNode;

import java.util.HashSet;

/**
 * @Auther: Ban
 * @Date: 2023/8/29 09:57
 * @Description: <p>
 * 二叉树的最近公共祖先
 * -多个点
 * -不含重复值
 * -节点存在于二叉树中
 */
public class LCA2 {

    /**
     * 给你输入一棵不含重复值的二叉树，但这次不是给你输入 p 和 q 两个节点了，
     * 而是给你输入一个包含若干节点的列表 nodes（这些节点都存在于二叉树中），让你算这些节点的最近公共祖先。
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        // 将nodes转化成哈希集合，便于判断元素是否存在
        HashSet<Integer> values = new HashSet<>();
        for (TreeNode node : nodes) {
            values.add(node.val);
        }
        return find(root, values);
    }

    // 在二叉树中寻找 values 的最近公共祖先节点
    public TreeNode find(TreeNode root, HashSet<Integer> values) {
        // base case
        if (root == null) {
            return null;
        }
        // 前序位置，看看 root 是不是目标值
        if (values.contains(root.val)) {
            return root;
        }
        // 去左、右子树寻找
        TreeNode left = find(root.left, values);
        TreeNode rigt = find(root.right, values);
        // 如果一个节点能够在它的左、右子树中分别找到 p 和 q，则该节点为 LCA 节点。
        // 后序位置，已经知道左右子树是否存在目标值
        if (left != null && rigt != null) {
            // 当前节点是 LCA 节点
            return root;
        }
        // 看哪边找到了
        return left != null ? left : rigt;
    }
}
