package org.algorithm.linear;

/**
 * @Auther: Ban
 * @Date: 2023/5/7 16:08
 * @Description: 删除排序链表中的重复元素
 */
public class RemoveDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        // 快慢指针，fast遍历链表，slow遇到重复的跳过
        while (fast != null) {
            if (slow.val != fast.val) {
                slow.next = fast;
                // slow++;
                slow = slow.next;
            }
            // fast++
            fast = fast.next;
        }
        // 断开与后面重复元素的连接
        slow.next = null;
        return head;
    }
}
