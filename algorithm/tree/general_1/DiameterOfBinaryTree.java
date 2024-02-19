package org.algorithm.tree.general_1;

import org.algorithm.tree.TreeNode;

/**
 * @Auther: Ban
 * @Date: 2023/7/3 11:01
 * @Description: ...
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 * <p>
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 * <p>
 * 两节点之间路径的 长度 由它们之间边数表示。
 */
public class DiameterOfBinaryTree {


    public int diameterOfBinaryTree(TreeNode root) {
//        preorder(root);
        postorder(root);
        return res;
    }

    // 记录最大直径
    public int res = 0;

    /**
     * 前序遍历
     */
    public void preorder(TreeNode root) {
        if (root == null) return;
        // 前序遍历
        // 先求左、右子树的最大深度
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        // 当前节点的最大直径
        int nodeDiameter = l + r;
        // 更新全局最大直径
        res = Math.max(res, nodeDiameter);
        preorder(root.left);
        preorder(root.right);
    }

    // 求节点的最大深度
    public int maxDepth(TreeNode root) {
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


    /**
     * 后序遍历
     */
    public int postorder(TreeNode root) {
        if (root == null) return 0;
        // 左、右子树的最大深度
        int l = postorder(root.left);
        int r = postorder(root.right);
        // 后续遍历
        // 根据左、右节点的最大深度，更新全局最大直径
        res = Math.max(res, l + r);
        // 返回当前节点最大深度
        return Math.max(l, r) + 1;
    }

}
