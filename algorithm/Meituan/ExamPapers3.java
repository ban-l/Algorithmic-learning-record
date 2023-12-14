package org.algorithm.Meituan;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Auther: Ban
 * @Date: 2023/12/11 19:11
 * @Description: <p>
 */
public class ExamPapers3 {

    private static int[] a;
    private static int n;
    private static int res = 0;
    private static LinkedList<Integer> track = new LinkedList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        in.close();
        backTrack(0);
        System.out.println(res);
    }

    public static void backTrack(int start) {
        if (!track.isEmpty()) {
            int temp = track.get(0);
            for (int i = 1; i < track.size(); i++) {
                temp &= track.get(i);
            }
            res = Math.max(res, count(temp));
        }
        for (int i = start; i < n; i++) {
            track.add(a[i]);
            backTrack(i + 1);
            track.removeLast();
        }
    }

    public static int count(int x) {
        int res = 0;
        while (x % 2 == 0) {
            res++;
        }
        return res;
    }
}
