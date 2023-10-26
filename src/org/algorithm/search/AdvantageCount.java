package org.algorithm.search;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Auther: Ban
 * @Date: 2023/8/14 08:49
 * @Description: <p>
 * 优势洗牌（田忌赛马）
 */
public class AdvantageCount {

    /**
     * 思路：
     * 将齐王和田忌的马按照战斗力排序，然后按照排名一一对比。
     * 1.如果田忌的马能赢，那就比赛
     * 2.如果赢不了，那就换个垫底的来送人头，保存实力。
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] res = new int[n];
        // nums2 降序排列，o1[0]是nums2的索引，o1[1]是nums2的值
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for (int i = 0; i < nums2.length; i++) {
            queue.offer(new int[]{i, nums2[i]});
        }
        // 给 nums1 升序排序
        int left = 0;
        int right = nums1.length - 1;
        Arrays.sort(nums1);
        while (!queue.isEmpty()) {
            int[] v2 = queue.poll();
            //  maxval 是 nums2 中的最大值，i 是对应索引
            int i = v2[0];
            int maxval = v2[1];
            if (nums1[right] > maxval) {
                // 如果 nums1[right] 能胜过 maxval，那就自己上
                res[i] = nums1[right];
                right--;
            } else {
                // 否则用最小值混一下，养精蓄锐
                res[i] = nums1[left];
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {12, 24, 8, 32};
        int[] nums2 = {13, 25, 32, 11};
        int[] res = advantageCount(nums1, nums2);
        for (Integer i : res) {
            System.out.print(i + " ");
        }
    }
}
