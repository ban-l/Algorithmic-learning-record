package org.algorithm.offer;

import org.algorithm.Traverse;
import org.algorithm.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Ban
 * @Date: 2023/7/18 09:59
 * @Description:给定节点数为 n 的二叉树的前序遍历和中序遍历结果，请重建出该二叉树并返回它的头结点。
 */
public class JZ7 {

    /**
     * 确定根节点的值
     * 然后递归构造左右子树
     */
    public Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            // 存储 中序遍历的 值、索引
            indexMap.put(inorder[i], i);
        }
        // 根据函数定义，用 preorder 和 inorder 构造二叉树
        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    // 根据前序、中序，确定一个节点位置，然后递归构造左右子树
    public TreeNode build(int[] preorder, int preStart, int preEnd,
                          int[] inorder, int inStart, int inEnd) {
        // base case，跳出递归
        if (preStart > preEnd) {
            return null;
        }
        // root 节点对应的值就是前序遍历数组的第一个元素
        TreeNode root = new TreeNode(preorder[preStart]);
        // 获得 root.val 在中序遍历的索引
        int index = indexMap.get(root.val);
        // 根据索引，确定一个节点位置,然后划分左右子树
        // 左树长度
        int leftSize = index - inStart;
        // 递归构造左右子树，传入前序、中序遍历
        root.left = build(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, index - 1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                inorder, index + 1, inEnd);
        return root;
    }

    public static void main(String[] args) {
        JZ7 jz7 = new JZ7();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = jz7.buildTree(preorder, inorder);
        Traverse.traverse(root);
    }
}
