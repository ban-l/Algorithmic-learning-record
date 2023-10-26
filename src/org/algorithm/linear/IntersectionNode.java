package org.algorithm.linear;

/**
 * @Auther: Ban
 * @Date: 2022/11/25 16:45
 * @Description: 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 */
public class IntersectionNode {


    /**
     * 找到两个链表的交点
     * <p>
     * 解法1
     * 两条链表拼接（逻辑上连在一起）
     * 然后同时走，即可找到公共部分
     *
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 施展链表双指针技巧
        ListNode pa = headA;
        ListNode pb = headB;
        while (pa != pb) {
            // pa 走一步，如果走到根节点，转到 headB 节点
            if (pa == null) {
                pa = headB;
            } else {
                pa = pa.next;
            }
            // pb 走一步，如果走到根节点，转到 headA 节点
            if (pb == null) {
                pb = headA;
            } else {
                pb = pb.next;
            }
        }
        return pa;
    }

    /**
     * 找到两个链表的交点
     * <p>
     * 解法二
     * 1.找到较长的链表max
     * 2.max走（max-min）步
     * 3.max min同时走，相遇即是交点
     *
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        int lenA = getLen(headA);
        int lenB = getLen(headB);
        ListNode min = new ListNode(-1);
        ListNode max = new ListNode(-1);
        if (lenA > lenB) {
            max = headA;
            min = headB;
        } else {
            max = headB;
            min = headA;
        }
        int gap = Math.abs(lenA - lenB);
        while (gap > 0) {
            max = max.next;
            gap--;
        }
        while (max != min) {
            max = max.next;
            min = min.next;
        }
        return max;
    }


    /**
     * 得到链表长度
     *
     * @param node
     * @return
     */
    public static int getLen(ListNode node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }
}
