package org.algorithm.arr.spiral;

import org.algorithm.common.Convert;

import java.util.Arrays;

/**
 * @Auther: Ban
 * @Date: 2023/8/9 09:52
 * @Description: <p>
 */
public class Rotate {
    /**
     * 将二维矩阵原地 顺时针 旋转 90 度
     * <p>
     * 1.先沿对角线镜像对称二维矩阵
     * 2.反转一维数组 matrix[i]
     *
     * @param matrix
     */
    public static void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            // 先沿对角线镜像对称二维矩阵
            for (int j = 0; j <= i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int[] arr : matrix) {
            // 反转一维数组 matrix[i]
            int left = 0;
            int rigjt = arr.length - 1;
            Convert.convertInt(arr, left, rigjt);
        }
    }

    // 将二维矩阵原地 逆时针 旋转 90 度
    public static void rotate2(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            // 沿左下到右上的对角线镜像对称二维矩阵
            for (int j = 0; j < n - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][n - i - 1];
                matrix[n - j - 1][n - i - 1] = temp;
            }
        }
        for (int[] arr : matrix) {
            // 反转一维数组 matrix[i]
            int left = 0;
            int rigjt = arr.length - 1;
            Convert.convertInt(arr, left, rigjt);
        }
    }


    public static void main(String[] args) {
        int[][] nums = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
//        rotate(nums);
//        System.out.println(Arrays.deepToString(nums));
        rotate2(nums);
        System.out.println(Arrays.deepToString(nums));
    }
}
