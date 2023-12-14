package org.algorithm.Meituan;

import java.util.Scanner;

/**
 * @Auther: Ban
 * @Date: 2023/12/11 19:11
 * @Description: <p>
 */
public class ExamPapers2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String time = in.next();
        int n = in.nextInt();
        in.nextLine();
        String[] op = new String[n];
        for (int i = 0; i < n; i++) {
            op[i] = in.nextLine();
        }
        in.close();

        int t1 = Integer.valueOf(time.substring(0, 2));
        int t2 = Integer.valueOf(time.substring(3, 5));
        for (int i = 0; i < n; i++) {
            String s = op[i].substring(0, 1);
            int x = Integer.valueOf(op[i].substring(2, op[i].length()));
            int temp1 = (x / 60) % 24;
            int temp2 = x % 60;
            if (s.equals("+")) {
                t1 += temp1;
                t2 += temp2;
                t1 += t2 / 60;
                t2 %= 60;
                t1 %= 24;
            } else if (s.equals("-")) {
                t1 -= temp1;
                t2 -= temp2;
                if (t2 < 0) {
                    t2 += 60;
                    t1--;
                }
                if (t1 < 0) {
                    t1 += 24;
                }
            }
        }
        // 输出为长度为5的字符串
        String res1 = String.valueOf(t1);
        String res2 = String.valueOf(t2);
        if (t1 < 10) { // 不足补充0
            res1 = "0" + t1;
        }
        if (t2 < 10) { // 不足补充0
            res2 = "0" + t2;
        }
        System.out.println(res1 + ":" + res2);
    }
}
