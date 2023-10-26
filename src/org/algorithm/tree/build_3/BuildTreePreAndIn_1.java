package org.algorithm.tree.build_3;

import org.algorithm.tree.TreeNode;

import java.util.HashMap;

/**
 * @Auther: Ban
 * @Date: 2023/7/19 09:45
 * @Description: 从前序与中序遍历序列构造二叉树
 */
public class BuildTreePreAndIn_1 {

    public HashMap<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            // 存储 中序遍历的 值、索引
            indexMap.put(inorder[i], i);
        }
        // 根据函数定义，用 preorder 和 inorder 构造二叉树
        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    /**
     * 根据前序、中序，确定一个节点位置，然后递归构造左右子树
     * 前序遍历数组为 preorder[preStart..preEnd]
     * 中序遍历数组为 inorder[inStart..inEnd]
     */
    public TreeNode build(int[] preorder, int preStart, int preEnd,
                          int[] inorder, int inStart, int inEnd) {
        // base case，跳出递归
        if (preStart > preEnd) return null;

        // 获取前序遍历第一个值 val
        // root.val 节点对应的值就是 val
        int val = preorder[preStart];
        // 构造根节点
        TreeNode root = new TreeNode(val);

        // 获取 val 在中序遍历的索引
        int index = indexMap.get(val);
        // 左树长度
        int leftSize = index - inStart;

        // 递归构造左右子树，传入前序、中序遍历
        root.left = build(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, index - 1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                inorder, index + 1, inEnd);
        return root;
    }
}
