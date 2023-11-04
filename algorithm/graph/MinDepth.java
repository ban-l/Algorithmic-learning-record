package org.algorithm.graph;

import org.algorithm.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther: Ban
 * @Date: 2023/7/17 11:04
 * @Description:广度优先搜索 <p>
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明：叶子节点是指没有子节点的节点。
 */
public class MinDepth {


    /**
     * 二叉树的层次遍历，用不到visited数组
     * <p>
     * while控制 从上到下 遍历 每一层
     * for控制 从左到右 遍历 每一层的每个节点
     *
     * @param root
     * @return
     */
    public static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        // 根节点入队
        queue.offer(root);
        // root本身是一层，初始化为1
        int minDepth = 1;
        // 从上到下遍历每一层
        while (!queue.isEmpty()) {
            // 每一层节点数量
            int sz = queue.size();
            // 同一层次，从左到右遍历每一层的每个节点
            for (int i = 0; i < sz; i++) {
                // 出队
                TreeNode node = queue.poll();
                // 判断是否到达终点，该层的某个节点 左、右子树为空 说明是最小深度
                if (node.left == null && node.right == null) {
                    return minDepth;
                }
                // 将下一层节点放入队列
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            // 增加层数
            minDepth++;
        }
        return minDepth;
    }


    /**
     * 2.动态规划，递推求解
     *
     * @param root
     * @return
     */
    public static int minDepth(TreeNode root) {
        // base case
        if (root == null) {
            return 0;
        }
        int l = minDepth(root.left);
        int r = minDepth(root.right);
        int temp = 0;
        if (l == 0 && r == 0) {
            temp = 0;
        } else if (l == 0) {
            temp = r;
        } else if (r == 0) {
            temp = l;
        } else {
            temp = Math.min(r, l);
        }
        return temp + 1;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{
                3,
                9, 20,
                0, 0, 15, 7
        };
        // 创建二叉树
        TreeNode root = TreeNode.createBinaryTree(arr, 0);
        // 动态规划
        System.out.println(minDepth(root));
        // dfs
        System.out.println(dfs(root));

    }
}
