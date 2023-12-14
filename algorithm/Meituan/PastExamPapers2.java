package org.algorithm.Meituan;

import java.util.Scanner;

/**
 * @Auther: Ban
 * @Date: 2023/12/2 19:47
 * @Description: <p>
 * 2.小美的字符串匹配度
 */
public class PastExamPapers2 {

    public static void main(String[] args) {
        solution();
    }

    /* 暴力1 */
    public static void solution() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        String t = in.next();
        in.close();

        // s和t 匹配的初始结果
        int res = match(s, t);
        // 穷举其它匹配结果
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                char[] c = t.toCharArray();
                swap(c, i, j);
                int count = match(s, String.valueOf(c));
                res = Math.max(res, count);
            }
        }
        System.out.println(res);
    }

    public static int match(String s, String t) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(i)) {
                count++;
            }
        }
        return count;
    }


    public static void swap(char[] c, int i, int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }

    /* 暴力2 */
    public static void solution2() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        String t = in.next();
        in.close();

        char[] c = t.toCharArray();
        // s和t 匹配的初始结果
        int res = match(s, t);
        // 穷举其它匹配结果
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                sb.append(t.substring(0, i)).append(c[j]).append(t.substring(i + 1, j)).append(c[i]).append(t.substring(j + 1, n));
                int count = match(s, sb.toString());
                res = Math.max(res, count);
                sb.setLength(0);
            }
        }
        System.out.println(res);
    }
}
