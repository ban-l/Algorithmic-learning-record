package org.algorithm.tree.general_1;

import org.algorithm.tree.TreeNode;

/**
 * @Auther: Ban
 * @Date: 2023/7/2 11:37
 * @Description: ...
 * 1、如果把根节点看做第 1 层，如何打印出每一个节点所在的层数？
 * <p>
 * 2、如何打印出每个节点的左右子树各有多少节点？
 */
public class PrintTree {


    /**
     * 前序遍历
     * 打印层数
     *
     * @param root
     * @param layer
     */
    public static void printLayer(TreeNode root, int layer) {
        if (root == null) return;
        // 前序遍历
        System.out.println("值 " + root.val + "，层数" + layer);
        layer++;
        // 左右子树
        printLayer(root.left, layer);
        printLayer(root.right, layer);
    }

    /**
     * 后序遍历
     * 打印左右子树各有多少节点
     *
     * @param root
     */
    public static int printNumber(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = printNumber(root.left);
        int r = printNumber(root.right);
        // 后序遍历,统计左右子树节点数
        System.out.println("值：" + root.getVal() + ",节点数:" + (l + r + 1));
        return l + r + 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{
                1,
                2, 5,
                3, 4, 6, 0,
                0, 0, 0, 0, 7, 0, 0, 0
        };
        // 创建二叉树
        TreeNode root = TreeNode.createBinaryTree(arr, 0);
        // 调用
        printLayer(root, 1);
        printNumber(root);
    }
}
