package org.algorithm.practice;

/**
 * @Auther: Ban
 * @Date: 2023/7/24 15:27
 * @Description: <p>
 * 题目描述:
 * 小明有一个数组。他挑选了一个有理数u/v，现在他想知道这个数组有多少个子区间的平均值恰好等于u/v。数组的子区间即是数组中连续的一段区间。
 * 如数组[4,2,6]有6个子区间[4],[2],[6],[4,2],[2,6],[4,2,6]
 * <p>
 * 输入描述：
 * 第一行有三个整数n,u,v(1<=n,v<100000,1<=u<n*v)，代表数组的长度，小明选择的有理数的分子和分母。
 * 输入保证u和v的最大公因数是1，即u/v是最简分数。
 * 第二行有n个绝对值不超过1000000的整数，代表数组中的元素。
 * 数字间两两有空格隔开。
 * 输出描述：
 * 输出一个非负整数，代表所求的答案。
 * <p>
 * 样例输入：
 * 6 5 2
 * 2 4 1 3 2 3
 * 样例输出：
 * 6
 */

import java.util.LinkedList;
import java.util.List;

public class Subinterval {
    private static List<List<Integer>> solution(int[] nums, int u, int v) {
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            LinkedList<Integer> track = new LinkedList<>();
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                track.add(nums[j]); // 子区间
                sum += nums[j];
                if (u * track.size() == sum * v) {
                    res.add(new LinkedList<>(track));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int u = in.nextInt();
//        int v = in.nextInt();
//        int[] nums = new int[n];
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = in.nextInt();
//        }
//        in.close();
        int[] nums = {2, 4, 1, 3, 2, 3};
        List<List<Integer>> res = solution(nums, 5, 2);
        System.out.println(res);
    }
}

