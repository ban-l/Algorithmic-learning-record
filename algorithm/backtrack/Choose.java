package org.algorithm.backtrack;

import java.util.LinkedList;

/**
 * @Auther: Ban
 * @Date: 2023/7/24 15:27
 * @Description: <p>
 */
public class Choose {

    /**
     * 小红有一个数组，她需要对数组操作n-1次，每次操作有两种选择：
     * 1.选择数组的最后两个数，记x和y，将它们从数组中删除，然后将x+y的个位数放回数组的最后。
     * 2.选择数组的最后两个数，记x和y，将它们从数组中删除，然后将x*y的个位数放回数组的最后。
     * 小红一共操作了n-1次，显然操作后数组只剩下了一个数。小红想知道，这个数等于0,1，...，9的方案数分别为多少，答案可能很大，你只需要输出答案对10^9+7取模的结果。
     * 输入描述：
     * 一个正整数n,代表数组的长度。
     * 一行n个正整数,代表初始数组。
     * 输出描述:
     * 一行10个整数，第i个数代表结果为i的方案数。
     * 示例：
     * 输入
     * 4
     * 1 2 3 4
     * 输出
     * 1 0 0 0 3 3 0 0 0 1
     */
    public static int[] res = new int[10];

    public static LinkedList<Integer> track = new LinkedList<>();

    public static int mod(int i) {
        return (int) (i % (Math.pow(10, 9) + 7));
    }


    public static void solution(int[] arr) {
        // 初始化路径
        for (Integer i : arr) {
            track.add(i);
        }
        backTrack();
    }

    /**
     * 回溯
     */
    public static void backTrack() {
        // 递归终止条件，0,1，...，9任意一个值
        if (track.size() == 1) {
            int i = track.get(0);
            res[i] = mod(res[i] + 1);
            return;
        }
        // 做选择
        int x = track.removeLast();
        int y = track.removeLast();
        // 回溯，两种选择
        // 选择1
        track.add((x + y) % 10);
        backTrack();
        track.removeLast();
        // 选择2
        track.add((x * y) % 10);
        backTrack();
        track.removeLast();
        // 撤销选择，注意顺序下，x，y - y，x
        track.add(y);
        track.add(x);
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        solution(array);
        // 输出结果
        for (Integer i : res) {
            System.out.print(i + " ");
        }
    }
}
