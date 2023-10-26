package org.algorithm.tree.thinking_2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther: Ban
 * @Date: 2023/8/15 11:07
 * @Description: <p>
 * 填充每个节点的下一个右侧节点指针
 */
public class Connect {


    // 1.层次遍历
    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        // 根节点入队
        queue.offer(root);
        // 从上到下遍历二叉树的每一层
        while (!queue.isEmpty()) {
            // 每一层节点数量
            int sz = queue.size();
            // 前驱节点,初始为null
            Node pre = null;
            // 从左到右遍历每一层的每个节点
            for (int i = 0; i < sz; i++) {
                // 出队
                Node node = queue.poll();
                if (pre != null) {
                    // 同层次节点连接
                    pre.next = node;
                }
                pre = node;
//                if (i < sz - 1) {
//                    // 同层次节点连接
//                    node.next = queue.peek();
//                }
                // 将下一层节点放入队列
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }

    // 2.三叉树遍历
    public Node connect2(Node root) {
        if (root == null) return null;
        // 遍历「三叉树」，连接相邻节点
        traverse(root.left, root.right);
        return root;
    }

    // 三叉树遍历框架
    public void traverse(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        /**** 前序位置 ****/
        // 将传入的两个节点穿起来
        node1.next = node2;
        // 连接相同父节点的两个子节点
        traverse(node1.left, node1.right);
        traverse(node2.left, node2.right);
        // 连接跨越父节点的两个子节点
        traverse(node1.right, node2.left);
    }


    // 静态内部类
    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
