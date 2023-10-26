package org.algorithm.offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: Ban
 * @Date: 2023/7/6 16:07
 * @Description: 数组中重复的数字
 * <p>
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组[2,3,1,0,2,5,3]，那么对应的输出是2或者3。存在不合法的输入的话输出-1
 */
public class JZ3 {

    /**
     * 1.辅助数组
     *
     * @param numbers
     * @return
     */
    public static int duplicate(int[] numbers) {
        // 辅助数组,初始化默认为 false
        boolean[] arr = new boolean[numbers.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[numbers[i]]) { // 第二次出现，返回
                return numbers[i];
            } else {
                arr[numbers[i]] = true; // 出现一次，设为true
            }
        }
        return -1;
    }

    /**
     * 2.辅助集合
     *
     * @param numbers
     * @return
     */
    public static int duplicate2(int[] numbers) {
        Set<Integer> set = new HashSet<>(numbers.length);
        for (int i = 0; i < numbers.length; i++) {
            if (set.contains(numbers[i])) { // 已存在则重复，输出
                return numbers[i];
            } else { // 不存在，加入集合
                set.add(numbers[i]);
            }
        }
        return -1;
    }

    /**
     * 3.数据重排
     * 从头到尾遍历
     * 遍历到第 i 个元素，若 temp（numbers[i]） == i，表示已排好序
     * 若不同
     * 若下标 temp 和 i 的值相同，则出现出现重复
     * 否则，交换位置（temp被排好序）
     *
     * @param numbers
     * @return
     */
    public static int duplicate3(int[] numbers) {
        int i = 0, n = numbers.length;
        while (i < n) {
            int temp = numbers[i];
            if (i == temp) { // 相同跳过
                i++;
            } else {
                if (numbers[i] == numbers[temp]) { // 出现重复
                    return numbers[i];
                } else { // 交换
                    swap(numbers, i, temp);
                }
            }
        }
        return -1;
    }

    public static void swap(int[] numbers, int left, int right) {
        int temp = numbers[left];
        numbers[left] = numbers[right];
        numbers[right] = temp;
    }


    public static void main(String[] args) {
        int[] numbers = {2, 3, 1, 0, 2, 5, 3};
        int res = duplicate(numbers);
        System.out.println(res);
    }
}
