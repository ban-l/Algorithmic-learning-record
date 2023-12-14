package org.algorithm.Meituan;

import java.util.Scanner;

/**
 * @Auther: Ban
 * @Date: 2023/12/2 19:47
 * @Description: <p>
 * 6.小美走公路
 */
public class PastExamPapers6 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int x = in.nextInt();
        int y = in.nextInt();
        in.close();

        if (x > y) {
            int temp = x;
            x = y;
            y = temp;
        }
        int res1 = 0;
        int res2 = 0;
        for (int i = x - 1; i < y - 1; i++) {
            res1 += a[i];
        }
        for (int i = y - 1; i < n; i++) {
            res2 += a[i];
        }
        for (int i = 0; i < x - 1; i++) {
            res2 += a[i];
        }
        int res = res1 > res2 ? res2 : res1;
        System.out.println(res);
    }
}
