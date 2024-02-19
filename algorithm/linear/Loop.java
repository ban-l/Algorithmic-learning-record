package org.algorithm.linear;

/**
 * @Auther: Ban
 * @Date: 2022/11/24 16:28
 * @Description: 判断链表是否包含环
 */
public class Loop {

    /**
     * 解决方案：快慢指针
     * 如果 fast 最终遇到空指针，说明链表中没有环；
     * 如果 fast 最终和 slow 相遇，那肯定是 fast 超过了 slow 一圈，说明链表中含有环。
     *
     * @param head
     * @return
     */
    public boolean loop(ListNode head) {
        // 快慢指针初始化指向 head
        ListNode slow = head;
        ListNode fast = head;
        // 快指针走到末尾时停止
        while (fast != null && fast.next != null) {
            // 慢指针走一步，快指针走两步
            slow = slow.next;
            fast = fast.next.next;
            // 快慢指针相遇，说明有环
            if (slow == fast) {
                return true;
            }
        }
        // 无环
        return false;
    }

    /**
     * 如果有环
     * 找到 环的起点
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        // 快慢指针初始化指向 head
        ListNode slow = head;
        ListNode fast = head;
        // 快指针走到末尾时停止
        while (fast != null && fast.next != null) {
            // 慢指针走一步，快指针走两步
            slow = slow.next;
            fast = fast.next.next;
            // 快慢指针相遇，说明有环
            if (slow == fast) {
                break;
            }
        }
        // fast 遇到空指针 说明 没有环
        if (fast != null || fast.next != null) {
            return null;
        }

        // 假设 环起始点 和 相遇点 相差 m 步
        // 从相遇点开始走，走k-m步（ k 为 slow指针 走过的 步数）， 快慢指针同步前进，相交点就是环起点
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
