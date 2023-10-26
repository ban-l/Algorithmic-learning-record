package org.algorithm.linear.reverse;

import org.algorithm.linear.ListNode;

/**
 * @Auther: Ban
 * @Date: 2023/8/2 10:20
 * @Description: <p>
 * 反转链表
 */
public class Reverse {
    /**
     * 反转整个链表
     * <p>
     * 1.递归
     * 输入一个节点 head，将「以 head 为起点」的链表反转，并返回反转之后的头结点。
     *
     * @param head
     * @return
     */
    public static ListNode reverse(ListNode head) {
        // base case
        // 如果链表为空或者只有一个节点的时候，反转结果就是它自己，直接返回即可
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next); // last为反转之后的头结点
        head.next.next = head; // 反转
        head.next = null; // 链表的末尾要指向 null
        return last;
    }

    /**
     * 2.头插法
     *
     * @param head
     * @return
     */
    public static ListNode reverse2(ListNode head) {
        ListNode dummy = new ListNode();  // 虚拟头节点
        while (head != null) {
            ListNode temp = head.next; // 防止断链
            // 头插法
            head.next = dummy.next;
            dummy.next = head;
            head = temp; // 下一个节点
        }
        return dummy.next;
    }

    /**
     * 3.迭代
     *
     * @param head
     * @return
     */
    public static ListNode reverse3(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next; // 防止断链
            curr.next = pre; // 指向前一个节点
            pre = curr;
            curr = next;
        }
        return pre;
    }

}
