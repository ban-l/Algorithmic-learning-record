package org.algorithm.common;

import java.util.Arrays;
import java.util.Random;

/**
 * @Auther: Ban
 * @Date: 2023/3/22 21:52
 * @Description: 抽取随机数字集合
 */
public class RandomNumber {
    public static void main(String[] args) {
        int n = 30;
        int k = 5;
        // 源数组
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        // 随机数集合
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            // 0到n-1之间的随机数
            // int r = (int) (Math.random() * n);
            int r = new Random().nextInt(n);
            // 赋值
            result[i] = nums[r];
            // 确保不会再抽取到同样的数，使用数组最后一个数覆盖nums[r]，并将n--
            // 移动最后一个数，到随机数位置
            nums[r] = nums[n - 1];
            n--;
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(result));
    }
}
