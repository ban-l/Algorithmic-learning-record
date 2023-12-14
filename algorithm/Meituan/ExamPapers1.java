package org.algorithm.Meituan;

import java.util.Scanner;

/**
 * @Auther: Ban
 * @Date: 2023/12/11 19:11
 * @Description: <p>
 */
public class ExamPapers1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        in.close();

        int res = 0;
        int min = a[0];
        int max = a[0];
        for (int i = 1; i < n; i++) { // 2-n
            if (a[i] < min || a[i] > max) {
                res++;
                if (a[i] < min) {
                    min = a[i];
                }
                if (a[i] > max) {
                    max = a[i];
                }
            }
        }
        System.out.println(res);
    }

//    public static void sort(int[] a) {
//        for (int i = 1; i < a.length; i++) {
//            boolean flag = true;
//            for (int j = 0; j < a.length - i; j++) {
//                if (a[j] > a[j + 1]) {
//                    int temp = a[j];
//                    a[j] = a[j + 1];
//                    a[j + 1] = temp;
//                    flag = false;
//                }
//            }
//            if (flag) {
//                break;
//            }
//        }
//    }
}
