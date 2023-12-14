package org.algorithm.Meituan;

import java.util.Scanner;

/**
 * @Auther: Ban
 * @Date: 2023/12/2 19:47
 * @Description: <p>
 * 4.小美的排列询问
 */
public class PastExamPapers4 {

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
        String res = "No";
        for (int i = 0; i < n - 1; i++) {
            if ((a[i] == x && a[i + 1] == y) || (a[i] == y && a[i + 1] == x)) {
                res = "Yes";
                break;
            }
        }
        System.out.println(res);
    }
}
