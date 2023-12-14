package org.algorithm.arr.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: Ban
 * @Date: 2023/8/1 09:18
 * @Description: <p>
 * 三数之和
 * 排序加双指针
 */
public class SumThree {
    /**
     * 三数和为target
     *
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums, int target) {
        // 排序
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        // 穷举 threeSum 的第一个数
        for (int i = 0; i < nums.length; i++) {
            int twoSum = target - nums[i];
            // 计算 twoSum (target - nums[i])
            List<List<Integer>> two = twoSum(nums, i + 1, twoSum);
            // 如果存在满足条件的二元组，再加上 nums[i] 就是结果三元组
            for (List<Integer> list : two) {
                // 加上第三个数字
                list.add(nums[i]);
                res.add(list);
            }
            // 跳过第一个数字重复的情况，否则会出现重复结果
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
        }
        return res;
    }

    public static List<List<Integer>> twoSum(int[] numbers, int start, int target) {
        List<List<Integer>> res = new ArrayList<>();
        // 一左一右指针
        int left = start, right = numbers.length - 1;
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
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = threeSum(nums, 0);
        System.out.println(res.toString());
    }
}
