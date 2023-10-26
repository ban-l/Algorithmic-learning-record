package org.algorithm.linear;

/**
 * @Auther: ban
 * @Date: 2022/11/10 16:15
 * @Description: 链表
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }


    /**
     * 数组生成单链表
     *
     * @param arr
     * @return
     */
    public static ListNode arrToNode(int[] arr) {
        // 虚拟头节点
        ListNode dummy = new ListNode(), p = dummy;
        for (int i = 0; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            p.next = node;
            p = p.next;
        }
        return dummy.next;
    }
}
