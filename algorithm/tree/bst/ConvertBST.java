package org.algorithm.tree.bst;

import org.algorithm.tree.TreeNode;

/**
 * @Auther: Ban
 * @Date: 2023/8/30 09:17
 * @Description: <p>
 * 把二叉搜索树转换为累加树
 */
public class ConvertBST {

    private int res = 0;

    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    /**
     * BST
     * 左、右子树遍历升序
     * 右、左子树遍历降序
     */
    public void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.right); // 先遍历右子树
        // 外部变量记录累计和
        res += root.val;
        // 赋值 ,将 BST 转化成累加树
        root.val = res;
        traverse(root.left); // 后遍历右子树
    }
}
