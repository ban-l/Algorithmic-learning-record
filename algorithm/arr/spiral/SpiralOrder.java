package org.algorithm.arr.spiral;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Ban
 * @Date: 2023/8/10 08:54
 * @Description: <p>
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 */
public class SpiralOrder {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>(m * n);
        // 行的边界
        int upper_bound = 0, lower_bound = m - 1;
        // 列的边界
        int left_bound = 0, right_bound = n - 1;
        // res.size() == m * n 则遍历完整个数组
        while (res.size() < m * n) {
            if (upper_bound <= lower_bound) {
                // 在顶部从左向右遍历
                for (int j = left_bound; j <= right_bound; j++) {
                    res.add(matrix[upper_bound][j]);
                }
                // 行边界收缩，上边界下移
                upper_bound++;
            }

            if (left_bound <= right_bound) {
                // 在右侧从上向下遍历
                for (int i = upper_bound; i <= lower_bound; i++) {
                    res.add(matrix[i][right_bound]);
                }
                // 列边界收缩，右边界左移
                right_bound--;
            }
            if (upper_bound <= lower_bound) {
                // 在底部从右向左遍历
                for (int j = right_bound; j >= left_bound; j--) {
                    res.add(matrix[lower_bound][j]);
                }
                // 行边界收缩，下边界上移
                lower_bound--;
            }
            if (left_bound <= right_bound) {
                // 在左侧从下向上遍历
                for (int i = lower_bound; i >= upper_bound; i--) {
                    res.add(matrix[i][left_bound]);
                }
                // 列边界收缩，左边界右移
                left_bound++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] nums = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        System.out.println(spiralOrder(nums).size());
    }
}
