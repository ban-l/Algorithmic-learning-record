package org.algorithm.linear.reverse;

import org.algorithm.linear.ListNode;

/**
 * @Auther: Ban
 * @Date: 2023/8/4 10:21
 * @Description: <p>
 * 反转链表前 N 个节点（n <= 链表长度）
 */
public class ReverseN {
    /**
     * 1.递归解法
     * 反转链表前 N 个节点（n <= 链表长度）
     * base case 变为 n == 1，反转一个元素，就是它本身，同时要记录后驱节点
     * 记录后驱 successor（第 n + 1 个节点），反转之后将 head 连接上
     *
     * @param head
     * @return
     */
    public static ListNode successor = null;

    public static ListNode reverseN(ListNode head, int n) {
        // base case
        if (n == 1) {
            // 记录后驱节点，第 n + 1 个节点，反转后拼接
            successor = head.next;
            // 返回第 n 个节点
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        // 让反转之后的 head 节点和 后面节点(n+1)连起来
        head.next = successor;
        return last;
    }

    /**
     * 2.迭代解法
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode reversen(ListNode head, int n) {
        ListNode dummy = new ListNode();  // 虚拟头节点
        ListNode p = head; // 后驱节点
        ListNode successor = null; // 后驱节点
        for (int i = 1; i <= n; i++) {
            successor = p.next;
            p.next = dummy.next; // 头插法
            dummy.next = p;
            p = successor;
        }
        // 反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return dummy.next;
    }


}
