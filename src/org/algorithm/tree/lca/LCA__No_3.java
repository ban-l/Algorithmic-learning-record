package org.algorithm.tree.lca;

import org.algorithm.tree.TreeNode;

/**
 * @Auther: Ban
 * @Date: 2023/8/29 09:57
 * @Description: <p>
 * 二叉树的最近公共祖先
 * -两个点
 * -不含重复值
 * -节点 不一定 存在于二叉树中
 */
public class LCA__No_3 {

    // 用于记录 p 和 q 是否存在于二叉树中
    private boolean foundP = false;
    private boolean foundQ = false;

    /**
     * 给你输入一棵不含重复值的二叉树的，以及两个节点 p 和 q，如果 p 或 q 不存在于树中，则返回空指针，否则的话返回 p 和 q 的最近公共祖先节点。
     * p 和 q 不一定存在于树中，所以你不能遇到一个目标值就直接返回，
     * 而应该对二叉树进行完全搜索（遍历每一个节点），如果发现 p 或 q 不存在于树中，那么是不存在 LCA 的。
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = find(root, p, q);
        if (!foundP || !foundQ) {
            return null;
        }
        // p 和 q 都存在二叉树中，才有公共祖先
        return res;
    }


    // 后序遍历，完全搜索（遍历每一个节点），判断p 、q是否在树中
    public TreeNode find(TreeNode root, TreeNode p, TreeNode q) {
        // base case
        if (root == null) {
            return null;
        }
        // 去左、右子树寻找
        TreeNode left = find(root.left, p, q);
        TreeNode rigt = find(root.right, p, q);
        // 后序位置，判断当前节点是不是 LCA 节点
        if (left != null && rigt != null) {
            return root;
        }
        // 后序位置，判断当前节点是不是目标值
        if (root.val == p.val || root.val == q.val) {
            // 找到了，记录一下
            if (root.val == p.val) foundP = true;
            if (root.val == q.val) foundQ = true;
            return root;
        }
        // 看哪边找到了
        return left != null ? left : rigt;
    }
}
