package org.algorithm.linear;

/**
 * @Auther: Ban
 * @Date: 2022/11/15 16:35
 * @Description:分隔链表: 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 */
public class SeparateList {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode();
        ListNode dummy2 = new ListNode();
        ListNode p = head, r;
        ListNode p1 = dummy1, p2 = dummy2;
        while (p != null) {
            if (p.val < x) {
                p1.next = p;
                p1 = p;
            } else {
                p2.next = p;
                p2 = p;
            }
            p = p.next;
        }
        // 最后，设置尾指针的 next 为空
        p1.next = null;
        p2.next = null;
        // 连接两个链表
        p1.next = dummy2.next;
        return dummy1.next;
    }

    public ListNode solution(ListNode head, int x) {
        ListNode dummy1 = new ListNode();
        ListNode dummy2 = new ListNode();
        ListNode p = head, r;
        ListNode p1 = dummy1, p2 = dummy2;
        while (p != null) {
            // 记录当前节点的下一个，防止断链
            r = p.next;
            if (p.val < x) {
                p1.next = p;
                p1 = p;
            } else {
                p2.next = p;
                p2 = p;
            }
            // 已经分解的节点，断开原链表，断开 next 指针
            p.next = null;
            p = r;
        }
        // 连接两个链表
        p1.next = dummy2.next;
        return dummy1.next;
    }
}
