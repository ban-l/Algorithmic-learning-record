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
     *
     * <p>
     * 题解一：快慢指针
     * 两个工作指针 slow fast
     * 慢指针 slow 前进一步，快指针 fast 前进两步，当 fast 走到链表末尾时，slow 指向链表中点。
     * 注意，如果链表长度为偶数，即中点有两个时，返回的节点是靠后的那个节点。
     * <p>
     * 题解二：可以遍历两遍，第一遍得到链表长度 n，第二遍找到中间节点
     *
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
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

    /**
     * 题解二：可以遍历两遍，第一遍得到链表长度 n，第二遍找到中间节点
     */
    public ListNode middleNode2(ListNode head) {
        ListNode p = head;
        int n = 0;
        // 遍历一遍，得到链表长度 n
        while (p != null) {
            n++;
            p = p.next;
        }
        p = head;
        // 遍历两遍，找到中间节点
        int i = 0;
        while (i < n / 2) {
            i++;
            p = p.next;
        }
        return p;
    }
}
