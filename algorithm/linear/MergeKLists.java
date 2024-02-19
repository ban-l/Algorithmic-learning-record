package org.algorithm.linear;

import java.util.PriorityQueue;

/**
 * @Auther: Ban
 * @Date: 2022/11/22 15:00
 * @Description: 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * 链表遍历框架
 */
public class MergeKLists {


    /**
     * 解法1
     * 合并 k 个有序链表的逻辑类似合并两个有序链表，难点在于，如何快速得到 k 个节点中的最小节点，接到结果链表上
     * 这里我们就要用到 优先级队列（二叉堆） 这种数据结构，把链表节点放入一个最小堆，就可以每次获得 k 个节点中的最小节点，然后链接在一起.
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists.length == 0) return null;
        // 涉及新链表-虚拟头节点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        // 优先队列，创建小根堆，堆内有 lists.length 个元素，并指定排序方式
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                lists.length, (a, b) -> (a.val - b.val)
        );
        // 将 k 个链表的头结点加入最小堆
        for (ListNode head : lists) {
            // 为空入堆
            if (head != null) {
                pq.add(head);
            }
        }
        while (!pq.isEmpty()) {
            // 获得最小节点（堆顶）
            ListNode node = pq.poll();
            p.next = node;
            // node.next非空，入堆，继续构造小根堆
            if (node.next != null) {
                pq.add(node.next);
            }
            // p 指针不断前进
            p = p.next;
        }
        return dummy.next;
    }

    /**
     * 解法2
     * 思路：每次合并两条链表，合并成为新的链表，新链表再去和另一条合并，直至k条链表全部合并；
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        ListNode ans = null;
        for (int i = 0; i < lists.length; i++) {
            ans = MergeTwoLists.mergeTwoLists(ans, lists[i]);
        }
        return ans;
    }

}