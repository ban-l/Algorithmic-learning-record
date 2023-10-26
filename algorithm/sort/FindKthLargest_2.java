package org.algorithm.sort;

import java.util.PriorityQueue;

/**
 * @Auther: Ban
 * @Date: 2023/9/1 10:54
 * @Description: <p>
 * 数组中的第K个最大元素
 * 解法：堆排序
 */
public class FindKthLargest_2 {

    /**
     * 元素加入二叉堆
     * 堆大小设为k
     */
    public static int findKthLargest(int[] nums, int k) {
        // 小顶堆，堆顶是最小元素
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Integer node : nums) {
            // 每个元素都要过一遍二叉堆
            pq.offer(node);
            // 堆中元素多于 k 个时，删除堆顶元素
            if (pq.size() > k) {
                pq.poll();
            }
        }
        // pq 中剩下的是 nums 中 k 个最大元素，
        // 堆顶是最小的那个，即第 k 个最大元素
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int res = findKthLargest(nums, 2);
        System.out.println(res);
    }
}
