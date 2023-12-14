package org.algorithm.arr.spiral;

import java.util.Arrays;

/**
 * @Auther: Ban
 * @Date: 2023/8/10 09:27
 * @Description: <p>
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 */
public class GenerateMatrix {
    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int sum = 1;
        // 行的边界
        int upper_bound = 0, lower_bound = n - 1;
        // 列的边界
        int left_bound = 0, right_bound = n - 1;
        while (sum <= n * n) {
            if (upper_bound <= lower_bound) {
                for (int j = left_bound; j <= right_bound; j++) {
                    res[upper_bound][j] = sum++;
                }
                upper_bound++;
            }
            if (left_bound <= right_bound) {
                for (int i = upper_bound; i <= lower_bound; i++) {
                    res[i][right_bound] = sum++;
                }
                right_bound--;
            }
            if (upper_bound <= lower_bound) {
                for (int j = right_bound; j >= left_bound; j--) {
                    res[lower_bound][j] = sum++;
                }
                lower_bound--;
            }
            if (left_bound <= right_bound) {
                for (int i = lower_bound; i >= upper_bound; i--) {
                    res[i][left_bound] = sum++;
                }
                left_bound++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] nums = generateMatrix(3);
        System.out.println(Arrays.deepToString(nums));
    }
}