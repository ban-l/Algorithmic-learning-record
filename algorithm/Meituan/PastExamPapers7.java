package org.algorithm.Meituan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Auther: Ban
 * @Date: 2023/12/2 19:47
 * @Description: <p>
 * 7.小美的好矩阵
 */
public class PastExamPapers7 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = in.next();
        }
        in.close();
        char[][] matrix = new char[n][m];
        for (int i = 0; i < n; i++) {
            matrix[i] = s[i].toCharArray();
        }
        int res = solution(matrix);
        System.out.println(res);
    }

    /**
     * 1.截取3*3矩阵
     * 2.判断
     */
    public static int solution(char[][] matrix) {
        int res = 0;
        for (int i = 0; i <= matrix.length - 3; i++) {
            for (int j = 0; j <= matrix[i].length - 3; j++) {
                // 1.截取3*3矩阵
                char[][] submatrix = extractSubmatrix(matrix, i, j, 3);
                // 2.判断
                if (check1(submatrix) && check2(submatrix)) {
                    res++;
                }
            }
        }
        return res;
    }

    /**
     * 矩阵相邻的字符都不相等
     */
    public static boolean check1(char[][] m) {
        int n = m.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = m[i][j];
                if (i - 1 >= 0 && m[i - 1][j] == c) {
                    return false;
                }
                if (i + 1 < n && m[i + 1][j] == c) {
                    return false;
                }
                if (j - 1 >= 0 && m[i][j - 1] == c) {
                    return false;
                }
                if (j + 1 < n && m[i][j + 1] == c) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 矩阵 仅 由'A'、'B'、'C'三种字符组成。且三种字符都出现过。
     */
    public static boolean check2(char[][] m) {
        // 包含 'A'、'B'、'C'三种字符
        boolean flag1 = false;
        String s = Arrays.deepToString(m);
        if (s.contains("A") && s.contains("B") && s.contains("C")) {
            flag1 = true;
        }
        //  不包含其它字符
        boolean flag2 = true;
        int n = m.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = m[i][j];
                if (c < 'A' || c > 'C') {
                    flag2 = false;
                    break;
                }
            }
            if (!flag2) break;
        }
        return flag1 && flag2;
    }

    /**
     * 截取3*3矩阵
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