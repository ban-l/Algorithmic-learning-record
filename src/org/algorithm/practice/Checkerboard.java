package org.algorithm.practice;

import java.util.Scanner;

/**
 * @Auther: Ban
 * @Date: 2023/9/12 09:14
 * @Description: <p>
 * <p>
 * 棋盘染色
 * <p>
 * 有一个n行m列的棋盘，共n*m个格子，每个格子上都放置了一个白色棋子或者黑色棋子。
 * 现在你可以进行若干次操作，每次操作是将一个黑色棋子换成白色棋子，或是将一个白色棋子换成黑色棋子。
 * 请问至少需要多少次操作，可以让棋盘变成黑白相间的呢？黑白相间指的是对于每个棋子，其上下左右相邻的棋子（如果有的话）的颜色与其不同。
 * <p>
 * 输入描述
 * 第一行是两个整数n和m,表示棋盘的行数和列数。
 * 接下来n行，每行是一个长度为m的字符串，字符串只包含字符0'或1'。
 * 第i行第j列的字符为'0' 则表示棋盘上第i行第j列上摆放的棋子颜色为白色，若字符为'1'则表示黑色。
 * 对于所有的数据：1<=n,m<=400
 * 输出描述
 * 一行一个正整数，表示需要的最少操作次数。
 */
public class Checkerboard {
    /**
     * 两种情况
     * 第一行是：010101...
     * 第一行是：101010...
     * 取二种情况最小的
     *
     * @param s
     * @return
     */
    public static int solution(String[] s) {
        int n = s.length;
        int m = s[0].length();
        char[] c1 = new char[m];
        char[] c2 = new char[m];
        // 构造第一行的两种情况
        for (int i = 0; i < m; i++) {
            if (i % 2 == 0) {
                c1[i] = '0';
                c2[i] = '1';
            } else {
                c1[i] = '1';
                c2[i] = '0';
            }
        }
        // 010101...
        int res1 = 0;
        for (int i = 0; i < n; i++) {
            char[] temp = s[i].toCharArray();
            for (int j = 0; j < m; j++) {
                if (i % 2 == 0) {
                    if (temp[j] != c1[j]) {
                        res1++;
                    }
                } else {
                    if (temp[j] != c2[j]) {
                        res1++;
                    }
                }
            }
        }
        // 101010...
        int res2 = 0;
        for (int i = 0; i < n; i++) {
            char[] temp = s[i].toCharArray();
            for (int j = 0; j < m; j++) {
                if (i % 2 == 0) {
                    if (temp[j] != c2[j]) {
                        res2++;
                    }
                } else {
                    if (temp[j] != c1[j]) {
                        res2++;
                    }
                }
            }
        }
        System.out.println(res1);
        System.out.println(res2);
        return Math.min(res1, res2);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = in.next();
        }
        in.close();
        int res = solution(s);
        System.out.println(res);
    }
}
