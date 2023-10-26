package org.algorithm.tree.bst;

import org.algorithm.tree.TreeNode;

/**
 * @Auther: Ban
 * @Date: 2023/8/30 11:03
 * @Description: <p>
 * 二叉搜索树中的搜索
 */
public class SearchBST_2 {
    public TreeNode searchBST(TreeNode root, int val) {
        // base case
        if (root == null) return null;
        // 去左子树搜索
        if (root.val > val) {
            return searchBST(root.left, val);
        }
        // 去右子树搜索
        if (root.val < val) {
            return searchBST(root.right, val);
        }
        // root.val == val
        return root;
    }
}
