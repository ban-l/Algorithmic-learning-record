package org.algorithm.dp.subsequence;

/**
 * @Auther: Ban
 * @Date: 2023/9/8 09:04
 * @Description: <p>
 * 编辑距离
 * <p>
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 */
public class MinDistance_2 {

    /**
     * 状态：s1[0:i]、s2[0:j]
     * 选择：插入、删除、替换、跳过
     * dp[i][j]:将 s1[0:i-1] 转换成 s2[0:j-1] 所使用的最少操作数
     * base case：""和s2、 s1和“”
     * 状态转移方程
     * 相等：dp[i][j] = dp[i-1][j-1]
     * 不相等
     * dp[i][j] = dp[i - 1][j - 1] + 1; // 替换
     * dp[i][j] = dp[i - 1][j] + 1; // 删除
     * dp[i][j] = dp[i][j - 1] + 1; // 插入
     * dp[i][j] = min(dp[i-1][j-1]+1,dp[i-1][j]+1,dp[i][j-1]+1)
     */
    public int minDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        // dp[i][j]
        int[][] dp = new int[m + 1][n + 1];
        // base case
        for (int i = 0; i <= m; i++) { // s2为""，s1变成s2，s1删除s1的每个字符
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) { // s1为""，s1变成s2，s1插入s2的每个字符
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 状态转移方程
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // 跳过
                } else {
                    dp[i][j] = min(
                            dp[i - 1][j - 1] + 1, // 替换
                            dp[i - 1][j] + 1, // 删除
                            dp[i][j - 1] + 1 // 插入
                    );
                }
            }
        }
        // s1 和 s2 的最少操作数
        return dp[m][n];
    }

    public int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
