package org.algorithm.dp.subsequence;

import java.util.Arrays;

/**
 * @Auther: Ban
 * @Date: 2023/3/27 15:50
 * @Description: 最长公共子序列
 */
public class LongestCommonSubsequence {


    /**
     * 1.动态规划
     * 「自底向上」进行「递推」求解
     * <p>
     * 定义状态
     * dp[i][j]:表示text1[0,i]字符和text2[0,j]字符之间的最长公共子序列
     * <p>
     * base case
     * i=0,text1为空，空字符串和任何字符串的最长公共子序列都为0，dp[0][j]=0
     * j=0,text2为空，空字符串和任何字符串的最长公共子序列都为0，dp[i][0]=0
     * <p>
     * 分类讨论，选择
     * text1[i-1] == text2[j-1]
     * text1[i-1] != text2[j-1]
     * 状态转移方程
     */
    public int solution(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        // dp初始化为0
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                // 三种情况
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) { // 相等一种
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else { // 不相等两种,取最大
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }

    /**
     * 2.带备忘录的递归
     * 「自顶向下」进行「递归」求解
     */
    private int[][] memo; // 备忘录，消除重叠子问题

    public int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        // 备忘录值为 -1 代表未曾计算
        memo = new int[m][n];
        for (int[] row : memo)
            Arrays.fill(row, -1);
        // 计算 s1[0..] 和 s2[0..] 的 lcs 长度
        return dp(s1, 0, s2, 0);
    }

    // 定义：计算 s1[i..] 和 s2[j..] 的最长公共子序列长度
    public int dp(String s1, int i, String s2, int j) {
        // base case
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }
        // 如果之前计算过，则直接返回备忘录中的答案
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        // 根据 s1[i] 和 s2[j] 的情况做选择
        if (s1.charAt(i) == s2.charAt(j)) {
            // s1[i] 和 s2[j] 必然在 lcs 中
            memo[i][j] = 1 + dp(s1, i + 1, s2, j + 1);
        } else if (s1.charAt(i) != s2.charAt(j)) {
            // s1[i] 和 s2[j] 至少有一个不在 lcs 中
            memo[i][j] = Math.max(
                    dp(s1, i + 1, s2, j),
                    dp(s1, i, s2, j + 1));
        }
        return memo[i][j];
    }
}
