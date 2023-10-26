package org.algorithm.linear;

/**
 * @Auther: Ban
 * @Date: 2022/11/24 16:00
 * @Description: 单链表的中点
 */
public class MiddleNode {


    /**
     * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
     * <p>
     * 如果有两个中间结点，则返回第二个中间结点。
     * <p>
     * 解法一：可以遍历两边，一遍得到链表长度 n，另一编找到中间节点
     * <p>
     * 解法二：快慢指针
     * 两个工作指针 slow fast
     * 每当慢指针 slow 前进一步，快指针 fast 就前进两步，这样，当 fast 走到链表末尾时，slow 就指向了链表中点。
     *
     * @param head
     * @return
     */
    public static ListNode MiddleNode(ListNode head) {
        // 快慢指针初始化指向 head
        ListNode slow = head;
        ListNode fast = head;
        // 快指针走到末尾时停止
        while (fast != null && fast.next != null) {
            // 慢指针走一步，快指针走两步
            slow = slow.next;
            fast = fast.next.next;
        }
        // 慢指针指向中点
        return slow;
    }
}
