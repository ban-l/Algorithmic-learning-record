package org.algorithm.arr.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: Ban
 * @Date: 2023/7/31 14:09
 * @Description: <p>
 * 两数之和
 * 排序+左右指针+去重
 *
 */
public class SumTwo {

    /**
     * 两数之和，无重复
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] sum(int[] numbers, int target) {
        // 一左一右指针
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum > target) {
                // sum变小
                right--;
            } else {
                // sum变大
                left++;
            }
        }
        return new int[]{-1, -1};
    }


    /**
     * 两数之和，无重复
     * 排序+双指针
     * 当 sum == target 时：左右指针跳过重复的元素
     *
     * @param numbers
     * @param target
     * @return
     */
    public static List<List<Integer>> twoSum(int[] numbers, int target) {
        // 排序
        Arrays.sort(numbers);
        List<List<Integer>> res = new ArrayList<>();
        // 一左一右指针
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int l = numbers[left];
            int r = numbers[right];
            int sum = l + r;
            if (sum == target) {
                // 找到
                res.add(new ArrayList<>(Arrays.asList(l, r)));
                // 左、右指针跳过重复的元素
                while (left < right && l == numbers[left]) left++;
                while (left < right && r == numbers[right]) right--;
            } else if (sum > target) {
                // sum变小
                while (left < right && r == numbers[right]) right--; // 跳过相同的元素
            } else {
                // sum变大
                while (left < right && l == numbers[left]) left++; // 跳过相同的元素
            }
        }
        return res;
    }


    public static void main(String[] args) {
//        int[] numbers = {2, 7, 11, 15};
//        System.out.println(Arrays.toString(twoSum(numbers, 18)));
        int[] nums = {1, 1, 1, 2, 2, 3, 3};
        List<List<Integer>> res = twoSum(nums, 4);
        System.out.println(res.toString());
    }
}
