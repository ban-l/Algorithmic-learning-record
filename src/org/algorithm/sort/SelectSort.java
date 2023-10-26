package org.algorithm.sort;


import java.util.Arrays;

/**
 * 选择排序
 *
 * @author lbb
 */
public class SelectSort implements BaseSort {


    @Override
    public int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        // 当前日期距离1970-01-01 00:00:00的毫秒数
        Long start = System.currentTimeMillis();

        // 外层循环(arr.length -1)次
        for (int i = 0; i < arr.length - 1; i++) {
            // 刚开始假设最小值为arr[0],y依次循环
            int min = i;
            // 每次比较（arr.length-i）次
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            // 如果最小值和arr[i]不是同一个，交换
            if (i != min) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
        Long end = System.currentTimeMillis();
        System.out.println("程序执行所花费时间：" + (end - start));
        return arr;
    }
}
