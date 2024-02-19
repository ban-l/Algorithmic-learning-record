package org.algorithm.linear;

/**
 * @Auther: ban
 * @Date: 2022/11/10 16:23
 * @Description: 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class MergeTwoLists {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 虚拟头节点-涉及到新链表
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        ListNode p1 = list1;
        ListNode p2 = list2;
        while (p1 != null && p2 != null) {
            // 比较 p1 和 p2 两个指针
            // 将值较小的的节点接到 p 指针（尾指针）
            if (p1.val <= p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            // p 指针不断前进，相当于尾指针
            p = p.next;
        }
        // 若p1或p2非空，接在p后面
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        // 返回新链表（头节点的下一个）
        return dummy.next;
    }
}
