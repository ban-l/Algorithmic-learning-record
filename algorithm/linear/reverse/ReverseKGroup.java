package org.algorithm.linear.reverse;

import org.algorithm.linear.ListNode;

/**
 * @Auther: Ban
 * @Date: 2023/8/4 10:59
 * @Description: <p>
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 */
public class ReverseKGroup {

    /**
     * 1.递归解法
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode left = head;
        ListNode right = head;
        for (int i = 0; i < k; i++) {
            // base case：不足 k 个 ，不反转，返回 head
            if (right == null) return head;
            right = right.next;
        }
        // 左闭右开，先反转
        // 反转 k 个元素 [left,right)
        ListNode node = reverse(left, right);
        // 再拼接
        // 递归反转下一个[left,right)，并连接 反转后的头节点
        left.next = reverseKGroup(right, k);
        // 返回反转后的头节点
        return node;
    }

    // 反转 左闭右开 区间 [left,right) 节点
    public static ListNode reverse(ListNode left, ListNode right) {
        ListNode dummy = new ListNode();
        ListNode p = left;
        ListNode rear = null;
        while (p != right) {
            rear = p.next;
            p.next = dummy.next;
            dummy.next = p;
            p = rear;
        }
        left.next = rear;
        // 返回反转后的头结点
        return dummy.next;
    }


    /**
     * 2.迭代解法
     * 一次反转k个
     * 反转（len / k） 次
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup2(ListNode head, int k) {
        ListNode p = head;
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }
        int i;
        for (i = 1; i <= len / k * k; i += k) {
            head = reverseBetween(head, i, i + k - 1);
        }
        return head;
    }

    // 反转链表的一部分
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        for (int i = 1; i < left; i++) {
            pre = cur;
            cur = cur.next; // cur前进到left节点
        }
        // pre 和 反转后的节点连接
        pre.next = reversen(cur, right - left + 1);
        return dummy.next;
    }

    // 反转前n个节点，头插法
    public static ListNode reversen(ListNode head, int n) {
        ListNode dummy = new ListNode();  // 虚拟头节点
        ListNode p = head;
        ListNode successor = null; // 后驱节点
        for (int i = 1; i <= n; i++) {
            successor = p.next;
            p.next = dummy.next; // 头插法
            dummy.next = p;
            p = successor;
        }
        // 反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.arrToNode(new int[]{1, 2, 3, 4, 5});
        ListNode b = head;
        for (int i = 0; i < 3; i++) {
            // 不足 k 个，不需要反转，base case
            if (b == null) break;
            b = b.next;
        }
        System.out.println(b);
    }
}
