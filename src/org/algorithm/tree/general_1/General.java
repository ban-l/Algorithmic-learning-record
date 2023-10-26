package org.algorithm.tree.general_1;

import org.algorithm.linear.ListNode;

/**
 * @Auther: Ban
 * @Date: 2023/6/30 10:17
 * @Description:
 */
public class General {

    /**
     * 递归（后序位置）
     * 倒叙打印链表
     *
     * @param node
     */
    public static void traverse(ListNode node) {
        if (node == null) {
            return;
        }
        // 前序位置
        // System.out.println(node.val);
        traverse(node.next);
        // 后序位置
        System.out.println(node.val);
    }

    public static void main(String[] args) {
        ListNode node = ListNode.arrToNode(new int[]{1, 2, 3, 4, 5});
        traverse(node);
    }
}
