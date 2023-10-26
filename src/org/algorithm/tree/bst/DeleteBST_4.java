package org.algorithm.tree.bst;

import org.algorithm.tree.TreeNode;

/**
 * @Auther: Ban
 * @Date: 2023/8/30 11:24
 * @Description: <p>
 * 在 BST 中删除一个数
 */
public class DeleteBST_4 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root.val == key) {
            // 找到啦，进行删除
        } else if (root.val > key) {
            // 去左子树找
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            // 去右子树找
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
}
