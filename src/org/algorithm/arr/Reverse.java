package org.algorithm.arr;

import java.util.Arrays;

/**
 * @Auther: Ban
 * @Date: 2023/5/14 14:25
 * @Description: 数组反转
 */
public class Reverse {

    /**
     * 反转int
     *
     * @param nums
     */
    public static void reverseInt(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    /**
     * 反转String
     *
     * @param nums
     */
    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        reverseInt(nums);
        System.out.println(Arrays.toString(nums));
    }
}
