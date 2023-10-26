package org.algorithm.linear;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Auther: Ban
 * @Date: 2023/8/5 10:27
 * @Description: <p>
 */
public class IsPalindrome {

    // 左侧指针
    public ListNode left;

    /**
     * 1.递归
     * 后序遍历
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }

    public boolean traverse(ListNode head) {
        if (head == null) {
            return true;
        }
        boolean res = traverse(head.next);
        // 后序遍历,判断是否回文串
        res = (res && head.val == left.val);
        // 指针右移，比较下一个
        left = left.next;
        return res;
    }

    // 空间优化
    public boolean isPalindrome2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        // fast移动到链表末尾（长度奇数），fast为null（长度偶数数）
        // slow移动到中点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode left = head;
        ListNode right = reverse(slow);
        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
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


    /**
     * 3.暴力：比较值倒过来是否相同
     *
     * @param head
     * @return
     */
    public boolean isPalindrome3(ListNode head) {
        List<Integer> list = new ArrayList<>();
        for (ListNode p = head; p != null; p = p.next) {
            list.add(p.val);
        }
        Collections.reverse(list); // 反转
        int i = 0;
        for (ListNode p = head; p != null; p = p.next) {
            if (!list.get(i).equals(p.val)) {
                return false;
            }
            i++;
        }
        return true;
    }
}
