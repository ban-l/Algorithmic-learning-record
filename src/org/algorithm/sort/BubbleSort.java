package org.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author lbb
 */
public class BubbleSort implements BaseSort {

    @Override
    public int[] sort(int[] sourceArray) {
        // 对数组进行copy，不改变参数内容
        int[] array = Arrays.copyOf(sourceArray, sourceArray.length);

        // 当前日期距离1970-01-01 00:00:00的毫秒数
        Long start = System.currentTimeMillis();

        // 外层判断循环次数
        for (int i = 1; i < array.length; i++) {
            // 设置标识，若为true，则表示此数组已经有序，不需要再排序
            boolean isFlag = true;
            // 内层判断交换次数
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    isFlag = false;
                }
            }
            if (isFlag) {
                break;
            }
        }
        Long end = System.currentTimeMillis();
        System.out.println("程序执行所花费时间：" + (end - start));
        return array;
    }
}
