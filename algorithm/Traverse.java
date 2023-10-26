package org.algorithm;

import org.algorithm.linear.ListNode;
import org.algorithm.tree.TreeNode;

/**
 * @Auther: ban
 * @Date: 2022/11/7 17:04
 * @Description: 数据结构的基本操作
 * <p>
 * 遍历+访问
 * 线性、非线性
 */
public class Traverse {

    /**
     * 数组遍历框架，典型的线性迭代结构：
     *
     * @param arr
     */
    public static void traverseArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 迭代访问
            System.out.println(i);
        }
    }

    /**
     * 链表遍历框架，兼具迭代和递归结构：
     *
     * @param head
     */
    public static void traverseLinear1(ListNode head) {
        // 1.迭代访问 p.val
        for (ListNode p = head; p != null; p = p.next) {
            System.out.println(p.val);
        }
    }

    public static void traverseLinear2(ListNode head) {
        // 2.递归访问
        if (head == null) {
            return;
        }
        // 前序
        traverseLinear2(head.next);
        // 后序
    }

    /**
     * 二叉树遍历框架，典型的非线性递归遍历结构：
     *
     * @param root
     */
    public static void traverse(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        traverse(root.left);
        traverse(root.right);
    }
}
