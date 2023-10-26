package org.algorithm.arr;

/**
 * @Auther: Ban
 * @Date: 2023/5/7 15:55
 * @Description: 删除有序数组中的重复项
 * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
 */
public class RemoveDuplicates {
    public static int solution(int[] nums) {
        // 0-j都是无重复元素
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                // 维护 nums[0..slow] 无重复
                nums[slow] = nums[fast];
            }
            fast++;
        }
        // 数组长度为索引 + 1
        return slow + 1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(solution(a));
    }
}
