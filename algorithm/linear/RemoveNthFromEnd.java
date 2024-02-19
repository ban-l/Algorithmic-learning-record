package org.algorithm.linear;

/**
 * @Auther: Ban
 * @Date: 2022/11/24 15:30
 * @Description: 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */
public class RemoveNthFromEnd {


    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     * 找到倒数第 n+1 个节点，然后删除其下一个节点。
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 边界处理可以使用头节点，链表为空时方便处理
        ListNode dummy = new ListNode(-1);
        // 头节点和链表 链接
        dummy.next = head;
        // 处理有虚拟头节点的链表，步骤一样
        // 先走n+1步(存在头节点，+1)
        ListNode p1 = dummy;
        for (int i = 0; i < n + 1; i++) {
            p1 = p1.next;
        }
        // 一起走
        ListNode p2 = dummy;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        // 找到倒数第 n+1 个节点,删除下一下
        p2.next = p2.next.next;
        return dummy.next;
    }
}
