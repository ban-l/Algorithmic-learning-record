package org.algorithm.common;

import java.util.Arrays;

/**
 * @Auther: Ban
 * @Date: 2023/12/6 09:45
 * @Description: <p>
 * 截取 n*n 子矩阵
 */
public class Submatrix {
    public static void main(String[] args) {
        int size = 3;
        String[] s = new String[]{
                "DABC",
                "ABAB",
                "BABA",
                "BBAB"
        };
        int n = s.length;
        int m = s[0].length();
        char[][] matrix = new char[n][m];
        for (int i = 0; i < s.length; i++) {
            matrix[i] = s[i].toCharArray();
        }
        cut(matrix, size);
    }

    /**
     * 1.控制子矩阵滑动
     */
    public static void cut(char[][] matrix, int size) {
        int n = matrix.length;
        int m = matrix[0].length;
        // 通过 i，j 控制 子矩阵位置
        for (int i = 0; i <= n - size; i++) { // i的范围，防止越界
            for (int j = 0; j <= m - size; j++) { // j的范围，防止越界
                char[][] submatrix = extractSubmatrix(matrix, i, j, size);
                System.out.println(Arrays.deepToString(submatrix));
            }
        }
    }

    /**
     * 2.截取 size*size 子矩阵
     */
    public static char[][] extractSubmatrix(char[][] matrix, int startRow, int startCol, int size) {
        char[][] submatrix = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                submatrix[i][j] = matrix[startRow + i][startCol + j];
            }
        }
        return submatrix;
    }


}
