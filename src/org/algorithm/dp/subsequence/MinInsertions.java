package org.algorithm.dp.subsequence;

/**
 * @Auther: Ban
 * @Date: 2023/9/7 11:01
 * @Description: <p>
 * 让字符串成为回文串的最少插入次数
 * <p>
 * 给你一个字符串 s ，每一次操作你都可以在字符串的任意位置插入任意字符。
 * <p>
 * 请你返回让 s 成为回文串的 最少操作次数 。
 * <p>
 * 「回文串」是正读和反读都相同的字符串。
 */
public class MinInsertions {

    /**
     * 状态：子串 s[i..j]
     * 选择：插入、不插入
     * dp[i][j]:让子串 s[i..j]成为回文串的 最少操作次数 为 dp[i][j]
     * base case:
     * i =j,i>j,dp[i][j]=0
     * 状态转移方程：
     * 字符相等，不需要插入，就是回文串
     * dp[i][j]=dp[i+1][j-1]
     * <p>
     * 字符不相等，需要插入，构成回文串
     * 把s[i+1..j] 和 s[i..j-1] 变成回文串，选插入次数较少的
     * 然后还要再插入一个 s[i] 或 s[j]，使 s[i..j] 配成回文串
     * dp[i][j]=min(dp[i][j-1],dp[i+1][j]))+1
     */
    public int minInsertions(String s) {
        int n = s.length();
        // dp数组：成为回文串的 最少操作次数 为 dp[i][j]
        int[][] dp = new int[n][n];
        // base case，一个字符，插入次数为0
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = 0;
        }
        // 反着遍历保证正确的状态转移
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                // 状态转移方程
                if (s.charAt(i) == s.charAt(j)) { // 相等
                    // 不需要插入
                    dp[i][j] = dp[i + 1][j - 1];
                } else { // 不相等
                    // 需要插入，构成回文串
                    // 把s[i..j-1] 和 s[i+1..j]变成回文串，取插入次数较少的
                    // 然后再插入一个 s[i] 或 s[j]，使 s[i..j] 配成回文串
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i + 1][j]) + 1;
                }
            }
        }
        // s[0:n-1]成为回文串的 最少操作次数 为dp[0][n - 1]
        return dp[0][n - 1];
    }
}
