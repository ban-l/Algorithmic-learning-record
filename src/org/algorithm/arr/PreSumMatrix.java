package org.algorithm.arr;

import java.util.Arrays;

/**
 * @Auther: Ban
 * @Date: 2023/8/7 10:27
 * @Description: <p>
 */
public class PreSumMatrix {
    private int[][] preSum;

    // 构造前缀和
    public PreSumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        preSum = new int[m + 1][n + 1];
        // 构造前缀和矩阵
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 每一行的前缀哦
                preSum[i + 1][j + 1] = preSum[i + 1][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            // 每行前缀和相加
            sum += preSum[i + 1][col2 + 1] - preSum[i + 1][col1];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        PreSumMatrix m = new PreSumMatrix(matrix);
        System.out.println(Arrays.deepToString(m.preSum));
    }

    /*
    暴力
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }
     */
}
