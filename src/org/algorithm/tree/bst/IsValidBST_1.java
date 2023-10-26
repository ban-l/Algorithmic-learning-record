package org.algorithm.tree.bst;

import org.algorithm.tree.TreeNode;

/**
 * @Auther: Ban
 * @Date: 2023/8/30 10:12
 * @Description: <p>
 * 验证二叉搜索树
 */
public class IsValidBST_1 {

    public boolean isValidBST(TreeNode root) {
        // traverse(root);
        // return flag;
        return isValidBST(root, null, null);
    }

    // 1.递归
    public boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        // base case
        if (root == null) return true;
        // 若 root.val 不符合 max 和 min 的限制，说明不是合法 BST
        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;
        // 限定左子树的最大值是 root.val，右子树的最小值是 root.val
        return isValidBST(root.left, min, root)
                && isValidBST(root.right, root, max);
    }

    // 2.中序遍历，升序，若不满足则不是BST
    boolean flag = true; //外部变量，记录结果
    double pre = -Double.MAX_VALUE; // 记录前一个节点值

    public void traverse(TreeNode root) {
        if (root == null) return;
        // 访问左子树
        traverse(root.left);
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if (root.val <= pre) {
            flag = false;
            return;
        }
        // pre 更新
        pre = root.val;
        // 访问右子树
        traverse(root.right);
    }
}
