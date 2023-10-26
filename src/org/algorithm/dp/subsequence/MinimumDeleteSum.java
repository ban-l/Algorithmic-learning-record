package org.algorithm.dp.subsequence;

import java.util.Arrays;

/**
 * @Auther: Ban
 * @Date: 2023/9/5 10:37
 * @Description: <p>
 * 两个字符串的最小ASCII删除和
 */
public class MinimumDeleteSum {

    /**
     * 1.动态规划
     * 「自底向上」进行「递推」求解
     * <p>
     * 定义状态
     * i，j是序号，不是下标
     * dp[i][j]:表示 s1[0,i]字符和 s2[0,j]相同的最小 ASCII删除和。
     * s1[0,i]表示s1的长度为 i 的前缀
     * s2[0,j]表示s2长度为为 j 的前缀
     * <p>
     * base case
     * i=j=0,s1 ,s1 都为空，dp[0][0]=0
     * i=0,s1为空，将s2的字符全部删除，dp[0][j]= dp[0][j-1] + s2[j-1]
     * j=0,s2为空，将s1的字符全部删除，dp[i][0]= dp[i-1][0] + s1[i-1]
     * <p>
     * 当i>0且j>0 分类讨论，选择
     * s1[i-1] == s2[j-1]
     * 增加一个相同公共字符之后，最小 ASCII 删除和不变
     * s1[i-1] != s2[j-1]
     * <p>
     * 状态转移方程
     * dp[i][j] 的计算
     */
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        // 明确状态，创建 m+1  行， n+1 列的二维数组 dp
        int[][] dp = new int[m + 1][n + 1];
        // base case
        for (int i = 1; i <= m; i++) { // s2为空
            dp[i][0] = dp[i - 1][0] + s1.codePointAt(i - 1);
        }
        for (int j = 1; j <= n; j++) { // s1为空
            dp[0][j] = dp[0][j - 1] + s2.codePointAt(j - 1);
        }

        for (int i = 1; i < dp.length; i++) {
            // s1第 i 个字符
            int codei = s1.codePointAt(i - 1);
            for (int j = 1; j < dp[i].length; j++) {
                // s2第 j 个字符
                int codej = s2.codePointAt(j - 1);
                // 选择
                if (codei == codej) { // 相等一种
                    dp[i][j] = dp[i - 1][j - 1]; // 状态转移
                } else { // 不相等，两种,取最小
                    dp[i][j] = Math.min(dp[i - 1][j] + codei, dp[i][j - 1] + codej); // 状态转移
                }
            }
        }
        // 结果
        return dp[m][n];
    }


    /**
     * 2.带备忘录的递归
     * 「自顶向下」进行「递归」求解
     */

    private int[][] memo; // 备忘录，消除重叠子问题

    public int solution(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        // 备忘录值为 -1 代表未曾计算
        memo = new int[m][n];
        for (int[] row : memo)
            Arrays.fill(row, -1);
        // 计算 s1[0..] 和 s2[0..] 的 lcs 长度
        return dp(s1, 0, s2, 0);
    }

    // 定义：将 s1[i..] 和 s2[j..] 删除成相同字符串，
    // 最小的 ASCII 码之和为 dp(s1, i, s2, j)。
    public int dp(String s1, int i, String s2, int j) {
        int res = 0;
        // base case
        if (i == s1.length()) {
            // 如果 s1 到头了，那么 s2 剩下的都得删除
            for (; j < s2.length(); j++)
                res += s2.charAt(j);
            return res;
        }
        if (j == s2.length()) {
            // 如果 s2 到头了，那么 s1 剩下的都得删除
            for (; i < s1.length(); i++)
                res += s1.charAt(i);
            return res;
        }
        // 如果之前计算过，则直接返回备忘录中的答案
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            // s1[i] 和 s2[j] 都是在 lcs 中的，不用删除
            memo[i][j] = dp(s1, i + 1, s2, j + 1);
        } else {
            // s1[i] 和 s2[j] 至少有一个不在 lcs 中，删一个
            memo[i][j] = Math.min(
                    s1.charAt(i) + dp(s1, i + 1, s2, j),
                    s2.charAt(j) + dp(s1, i, s2, j + 1)
            );
        }
        return memo[i][j];
    }
}
