package org.algorithm.offer;

/**
 * @Auther: Ban
 * @Date: 2023/7/12 10:54
 * @Description: JZ4 二维数组中的查找
 * <p>
 * 在一个二维数组array中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * [
 * [1,2,8,9],
 * [2,4,9,12],
 * [4,7,10,13],
 * [6,8,11,15]
 * ]
 * 给定 target = 7，返回 true。
 * <p>
 * 给定 target = 3，返回 false。
 */
public class JZ4 {

    /**
     * 1.暴力
     *
     * @param target
     * @param array
     * @return
     */
    public static boolean Find(int target, int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 2.二分查找
     *
     * @param target
     * @param array
     * @return
     */
    public static boolean Find2(int target, int[][] array) {
        for (int i = 0; i < array.length; i++) {
            if (binarySearch(target, array[i])) return true;
        }
        return false;
    }

    public static boolean binarySearch(int target, int[] a) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] < target) { //在右边
                low = mid + 1;
            } else if (a[mid] > target) { //在左边
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }


    /**
     * 3.线性搜索
     * 利用二维数组行列递增特性
     * <p>
     * 由于行列递增，可以得出：
     * a.在一列中的某个数字，其上的数字都比它小
     * b.在一行中的某个数字，其右的数字都比它大
     * <p>
     * 搜索流程：
     * a.首先从数组左下角搜索.
     * b.如果当前数字大于target,那么查找往上移一位,如果当前数字小于target,那么查找往右移一位。
     * c.查找到target,返回true; 如果越界，返回false;
     *
     * @param target
     * @param array
     * @return
     */
    public static boolean Find3(int target, int[][] array) {
        int row = array.length - 1; // 行
        int col = 0; // 列
        // 从左下角开始
        while (row >= 0 && col < array[0].length) {
            if (array[row][col] == target) {
                return true;
            } else if (target > array[row][col]) {
                col++; // 右移
            } else {
                row--; // 上移
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int target = 7;
        int[][] nums = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        boolean res = Find3(target, nums);
        System.out.println(res);
    }
}
