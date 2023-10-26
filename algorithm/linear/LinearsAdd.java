package org.algorithm.linear;

/**
 * @Auther: Ban
 * @Date: 2023/10/12 15:17
 * @Description: <p>
 * <p>
 * 链表相加，注意产生进位
 */
public class LinearsAdd {
    public static ListNode solution(ListNode l1, ListNode l2) {
        // 虚拟头节点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        ListNode p1 = l1, p2 = l2;
        int r = 0; // 进位
        while (p1 != null && p2 != null) {
            int temp = r + p1.val + p2.val;
            r = temp / 10;
            ListNode node = new ListNode(temp % 10);
            p.next = node;
            p = p.next;
            p1 = p1.next;
            p2 = p2.next;
        }
        if (p1 == null && p2 == null) {
            if (r != 0) {
                ListNode node = new ListNode(r);
                p.next = node;
                p = p.next;
            }
        }
        if (p1 != null) {
            p1.val = p1.val + r;
            p.next = p1;
        }
        if (p2 != null) {
            p2.val = p2.val + r;
            p.next = p2;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(8);
        ListNode l6 = new ListNode(4);
        ListNode l7 = new ListNode(4);
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;

        ListNode node = solution(l1, l4);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
