package org.algorithm.tree.bst;

import org.algorithm.tree.TreeNode;

/**
 * @Auther: Ban
 * @Date: 2023/8/30 11:18
 * @Description: <p>
 * 在 BST 中插入一个数
 */
public class InsertBST_3 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // 找到空位置插入新节点
        if (root == null) return new TreeNode(val);
        // if (root.val == val)
        //     BST 中一般不会插入已存在元素
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
}
