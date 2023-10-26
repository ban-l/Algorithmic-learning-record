package org.algorithm.tree.build_3;

import org.algorithm.tree.TreeNode;

import java.util.HashMap;

/**
 * @Auther: Ban
 * @Date: 2023/8/17 09:50
 * @Description: <p>
 * 从中序与后序遍历序列构造二叉树
 */
public class BuildTreeInAndPost_2 {
    HashMap<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            // 存储 中序遍历的 值、索引
            indexMap.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    /**
     * build 函数的定义：
     * 中序遍历数组为 inorder[inStart..inEnd]，
     * 后序遍历数组为 postorder[postStart..postEnd]，
     * 构造二叉树，返回该二叉树的根节点
     */
    public TreeNode build(int[] inorder, int inStart, int inEnd,
                          int[] postorder, int postStart, int postEnd) {
        // base case，跳出递归
        if (inStart > inEnd) return null;
        // val为后序遍历的最后一个值
        int val = postorder[postEnd];
        // root.val 节点对应的值就是 val
        TreeNode root = new TreeNode(val);
        // 找到 val在中序遍历的 索引
        int index = indexMap.get(val);
        // 左子树的节点个数
        int leftSize = index - inStart;
        // 递归构造左右子树
        root.left = build(inorder, inStart, index - 1,
                postorder, postStart, postStart + leftSize - 1);
        root.right = build(inorder, index + 1, inEnd,
                postorder, postStart + leftSize, postEnd - 1);
        return root;
    }
}
