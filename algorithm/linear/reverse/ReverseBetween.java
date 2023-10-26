package org.algorithm.linear.reverse;

import org.algorithm.linear.ListNode;

/**
 * @Auther: Ban
 * @Date: 2023/8/4 09:08
 * @Description: <p>
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 */
public class ReverseBetween {

    /**
     * 1.递归解法
     * 1).head 前进到 left节点
     * 2).然后反转 以 left 为起点的 right - left 个节点，返回新的头结点（right）
     * 3).head.next 连接 反转后新的头节点
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        // base case
        if (left == 1) {
            // 反转以 left 为起点的 right - left 个节点，返回新的头结点（right）
            return ReverseN.reverseN(head, right);
        }
        // head前进，直到 left节点，开始反转
        // head.next 连接 反转后新的头节点
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }


    /**
     * 2.迭代解法
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public static ListNode reverseBetween2(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1); // 防止空节点
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        for (int i = 1; i < left; i++) {
            pre = cur;
            cur = cur.next; // cur前进到left节点
        }
        // pre 和 反转后的节点连接
        pre.next = ReverseN.reverseN(cur, right - left + 1);
        return dummy.next;
    }
}
