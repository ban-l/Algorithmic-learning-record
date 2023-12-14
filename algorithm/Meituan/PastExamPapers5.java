package org.algorithm.Meituan;

import java.util.Scanner;

/**
 * @Auther: Ban
 * @Date: 2023/12/2 19:47
 * @Description: <p>
 * 5.小美的排列构造
 */
public class PastExamPapers5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();

        int[] res = new int[n];
        int max = n;
        int min = 1;
        int i = 0;
        while (i < n) {
            res[i++] = max--;
            if (i < n) {
                res[i++] = min++;
            }
        }
        for (int j = 0; j < n; j++) {
            System.out.print(res[j] + " ");
        }
    }
}
