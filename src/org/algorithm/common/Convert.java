package org.algorithm.common;

import java.util.Arrays;

/**
 * @Auther: Ban
 * @Date: 2023/4/1 15:35
 * @Description: 倒置
 */
public class Convert {
    /**
     * 泛型方法
     * left、right参数为数组下标
     *
     * @param arr
     * @param left
     * @param right
     */
    public static <T> void convert(T[] arr, int left, int right) {
        while (left < right) {
            T temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void convertInt(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        convert(arr, 0, 9);
        System.out.println(Arrays.toString(arr));
    }
}
