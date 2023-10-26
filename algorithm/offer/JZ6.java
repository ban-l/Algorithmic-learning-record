package org.algorithm.offer;

import org.algorithm.linear.ListNode;

import java.util.ArrayList;

/**
 * @Auther: Ban
 * @Date: 2023/7/18 09:51
 * @Description: 输入一个链表的头节点，按链表从尾到头的顺序返回每个节点的值（用数组返回）。
 */
public class JZ6 {
    public static ArrayList<Integer> res = new ArrayList<>();

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        recursion(listNode);
        return res;
    }

    public static void recursion(ListNode listNode) {
        if (listNode == null) {
            return;
        }
        recursion(listNode.next);
        // 后序遍历
        res.add(listNode.val);
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.arrToNode(new int[]{1, 2, 3});
        printListFromTailToHead(listNode);
        System.out.println(res.toString());
    }
}
