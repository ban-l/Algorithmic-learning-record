package org.algorithm.linear;

/**
 * @Auther: Ban
 * @Date: 2022/11/24 14:57
 * @Description: 单链表的倒数第 k 个节点
 */
public class ReciprocalK {

    /**
     * 解法一
     * <p>
     * 先遍历一遍链表，得到长度 n
     * 再遍历一遍，倒数第 k 个节点是正数第 n-k+1 个节点
     *
     * @param head
     * @param k
     * @return 返回链表的倒数第 k 个节点
     */
    public static ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        int len = 0;
        while (p1 != null) {
            len++;
            p1 = p1.next;
        }
        ListNode p2 = head;
        int i = 1;
        while (i < len - k + 1) {
            i++;
            p2 = p2.next;
        }
        return p2;
    }

    /**
     * 解法二
     * 只遍历一遍链表
     * <p>
     * 两个工作指针，p1，p2 最初都指向 头节点head
     * p1指针先走 k 步
     * 然后，p1，p2 一起走 n-k 步
     * 此时 p2 位置是倒数第 k 个节点
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode findFromEnd2(ListNode head, int k) {
        ListNode p1 = head;
        // p1先走 k 步
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }

        ListNode p2 = head;
        // p1，p2 同时走 n-k 步
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        // p2 现在指向第 n - k + 1 个节点，即倒数第 k 个节点
        return p2;
    }
}
