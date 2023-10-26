package org.algorithm.dp.subsequence;

/**
 * @Auther: Ban
 * @Date: 2023/9/6 11:18
 * @Description: <p>
 * 最长回文子序列
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 * <p>
 * 子序列不连续
 * 字串连续
 */
class LongestPalindromeSubseq {


    /**
     * 状态： 子串：s[i..j]
     * 选择：相等、不相等
     * dp[i][j]:在子串 s[i..j] 中，最长的回文子序列的长度为 dp[i][j]
     * base case：i=j,i>j
     * 状态转移方程：
     * 相等：dp[i][j]=dp[i+1][j-1]+2
     * 不相等：dp[i][j]=Max(dp[i][j-1],dp[i+1][j])
     */
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        // dp数组：在子串 s[i..j] 中，最长的回文子序列的长度为 dp[i][j]
        int[][] dp = new int[n][n];
        // base case
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = 1;
        }
        // 反着遍历保证正确的状态转移
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                // 状态转移方程
                if (s.charAt(i) == s.charAt(j)) { // 相等
                    // 它俩一定在最长回文子序列中，构成最长回文子序列
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else { // 不相等
                    // s[i]、 s[j] 不可能同时出现在 s[i..j] 的最长回文子序列中，不构成最长回文子序列
                    // 把s[i]、 s[j] 分别加入 s[i..j-1]，s[i+1..j] 中，取最大
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        // 最后结果：在s[0:n-1]中，最长的回文子序列的长度为dp[0][n - 1]
        return dp[0][n - 1];
    }
}
