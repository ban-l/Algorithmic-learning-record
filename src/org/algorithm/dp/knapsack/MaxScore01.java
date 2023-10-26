package org.algorithm.dp.knapsack;

import java.util.Arrays;

/**
 * @Auther: Ban
 * @Date: 2023/10/14 20:28
 * @Description: <p>
 * <p>
 * 小红正在参加笔试，已知笔试一共有n个编程题，每个编程题有若干个测试用例，小红获得的分数和通过的测试用例数量成正比
 * 对于一个题而言，小红可以写一个暴力算法获得部分分，这样相对的比较节省时间，另外她还可以直接尝试正解，这样可以获得满分，但需要花费更多的时间。
 * 现在给定了总时间，以及每个题目暴力算法的用时和得分、正确算法的用时和得分。
 * 请你帮小红规划一个做题方案，可以在有限的时间内获得更多分数：
 * <p>
 * 输入描述
 * 第一行输入两个正整数 n，t，代表题目数量，以及笔试的总时长。
 * 接下来 n 行，每行输入四个正整数t1,s1,t2,s2,分别代表小红写出正解的用时，正确算法的得分，小红写暴力算法的用时，暴力算法的得分。
 * 1≤n,t≤2000
 * 1≤t1≤t2≤2000
 * 1≤s1≤s2≤10^5
 * <p>
 * 输出描述
 * 输出一个长度为的字符串，第i个字符 代表 第i道题的策略：
 * 如果这道题写暴力算法，则用字符'B'表示；
 * 如果写正确算法，则用字符'A'表示；
 * 如果放弃此题（不耗时间，但这道题0分），则用'F表'示。
 * 请务必保证总耗时不超过 t，且总得分尽可能大。如果有多种做题方案都能拿到最高分数，输出任意一种即可
 */
public class MaxScore01 {

    /**
     * 状态：题目n，用时t
     * <p>
     * 选择：做：暴力、正解，不做
     * <p>
     * dp[i][j]:共i道题，限时为j，求取得的最大分数
     * <p>
     * base case：
     * 题目为0：dp[0][j] = 0
     * 限时为0：dp[i][0] = 0
     * <p>
     * 状态转移
     * 做：
     * 正解:
     * ——dp[i][j] = 第i道题的分数 + 前i-1道题，限时为 j -第i道题用时(nums[i-1][0]) ，求取得的最大分数
     * ——dp[i][j] = nums[i-1][1] + dp[i-1][j-nums[i-1][0]];
     * 暴力：
     * ——dp[i][j] = 第i道题的分数 + 前i-1道题，限时为 j -第i道题用时(nums[i-1][2]) ，求取得的最大分数
     * ——dp[i][j] = nums[i-1][3] + dp[i-1][j-nums[i-1][2]];
     * <p>
     * 不做：
     * ——dp[i][j] = 前i-1道题，限时为j，求取得的最大分数
     * ——dp[i][j] = dp[i-1][j];
     */
    public static int knapsack(int[][] nums, int t) {
        int n = nums.length;
        char[] res = new char[n]; // 记录解法
        int[][] dp = new int[n + 1][t + 1]; // dp
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= t; j++) {
                // 正解
                if (nums[i - 1][0] > j) {
                    dp[i][j] = dp[i - 1][j];
                    res[i - 1] = 'F';
                } else {
                    int temp = nums[i - 1][1] + dp[i - 1][j - nums[i - 1][0]];
                    if (temp > dp[i - 1][j]) {
                        dp[i][j] = temp;
                        res[i - 1] = 'A';
                    } else {
                        dp[i][j] = dp[i - 1][j];
                        res[i - 1] = 'F';
                    }
                }
                // 暴力
                if (nums[i - 1][2] <= j) {
                    int temp = nums[i - 1][3] + dp[i - 1][j - nums[i - 1][2]];
                    if (temp > dp[i][j]) {
                        dp[i][j] = temp;
                        res[i - 1] = 'B';
                    }
                }
            }
        }
        System.out.println(Arrays.toString(res));
        return dp[n][t];
    }

    public static void main(String[] args) {
        int n = 4;
        int t = 10;
        int[][] nums = {
                {5, 10, 3, 6},
                {6, 12, 3, 6},
                {3, 8, 1, 3},
                {10, 20, 7, 13}
        };
        int res = knapsack(nums, t);
        System.out.println(res);
    }
}
