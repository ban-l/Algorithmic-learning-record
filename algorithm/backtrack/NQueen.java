package org.algorithm.backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @Auther: Ban
 * @Date: 2023/3/20 10:57
 * @Description: n皇后问题:回溯
 */
public class NQueen {

    public static int count = 0; // 记录解决方案数目
    public static List<List<String>> res = new LinkedList<>(); // 记录具体解决方案
    public static int n; // n*n矩阵
    public static int[] a; // a[i]表示，第i行皇后放在第a[i]列上

    /**
     * 检查第x行皇后是否可以放在第y列上
     * a（x，y），b（m，n）两个点在对角线上，满足x+y=m+n ; x-y=m-n。用于检测两个点是否在对角线上
     */
    public static boolean check(int x, int y) {
        // 检查x行之前的存放情况，从第0行开始，不可和（i,a[i]）同对角线、不可同一列（a[i]!=y）
        for (int i = 0; i < x; i++) {
            // 检查列是否有皇后互相冲突
            if (a[i] == y) { // a[i]不能等于 y
                return false;
            }
            // 检查对角线是否有皇后互相冲突
            if (i + a[i] == x + y) {
                return false;
            }
            if (i - a[i] == x - y) {
                return false;
            }
        }
        return true;
    }


    /**
     * 第row行皇后放于何处
     */
    public static void backtrack(int row) {
        // 触发结束条件
        if (row == n) { // 一次解决方案
            // 记录解决方案数目
            count++;
            System.out.println("第" + count + "种解决方案:" + Arrays.toString(a));

            // 记录具体解决方案
            List<String> track = new LinkedList<>();
            for (int i = 0; i < a.length; i++) {
                char[] c = new char[n];
                Arrays.fill(c, '.');
                c[a[i]] = 'Q';
                track.add(String.valueOf(c));
            }
            res.add(new LinkedList<>(track));

            // 跳出递归
            return;
        }
        // 回溯框架
        for (int i = 0; i < n; i++) {
            // 检查是否有皇后互相冲突，不合法，跳过
            if (!check(row, i)) continue;
            // 做选择
            a[row] = i;
            // 进入下一行决策
            backtrack(row + 1);
            // 撤销选择
            a[row] = 0; // 回溯；递归结束后将数组清零，计算下一种情况
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        in.close();
        a = new int[n];
        backtrack(0);
        System.out.println(count);
        System.out.println(res);
    }
}
