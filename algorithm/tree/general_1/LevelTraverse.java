package org.algorithm.tree.general_1;

import org.algorithm.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther: Ban
 * @Date: 2023/7/4 11:18
 * @Description: 二叉树层次遍历
 */
public class LevelTraverse {

    /**
     * 二叉树的层次遍历
     * <p>
     * while控制 从上到下 遍历 每一层
     * for控制 从左到右 遍历 每一层的每个节点
     *
     * @param root
     */
    public static void levelTraverse(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        // 根节点入队
        queue.offer(root);
        // 从上到下遍历二叉树的每一层
        while (!queue.isEmpty()) {
            // 每一层节点数量
            int sz = queue.size();
            // 从左到右遍历每一层的每个节点
            for (int i = 0; i < sz; i++) {
                // 出队
                TreeNode node = queue.poll();
                // 将下一层节点放入队列
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
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
        levelTraverse(root);
    }
}
