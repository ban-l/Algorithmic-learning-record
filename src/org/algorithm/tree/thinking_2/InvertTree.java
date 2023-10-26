package org.algorithm.tree.thinking_2;

import org.algorithm.tree.TreeNode;

/**
 * @Auther: Ban
 * @Date: 2023/8/15 10:29
 * @Description: <p>
 * 翻转二叉树
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 */
public class InvertTree {


    public TreeNode invertTree(TreeNode root) {
        // 遍历二叉树，交换每个节点的子节点
        traverse(root);
        traverse2(root);
        return root;
    }

    // 遍历思维
    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        /**** 前序位置 ****/
        // 每一个节点需要做的事就是交换它的左右子节点
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // 遍历框架，去遍历左右子树的节点
        traverse(root.left);
        traverse(root.right);
    }

    // 分解思维
    public TreeNode traverse2(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = traverse2(root.left);
        TreeNode right = traverse2(root.right);

        /**** 后序位置 ****/
        // 交换左右子节点
        root.left = right;
        root.right = left;
        return root;
    }
}
