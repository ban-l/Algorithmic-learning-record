package org.algorithm.dp;

import java.util.Arrays;

/**
 * @Auther: Ban
 * @Date: 2023/9/13 09:42
 * @Description: <p>
 * 不同的子序列
 * <p>
 * 给你两个字符串 s 和 t ，统计并返回在 s 的 子序列 中 t 出现的个数，结果需要对 109 + 7 取模。
 */
public class NumDistinct {
    /**
     * 1.动态规划
     * 状态：子串s[0..i] t[0..j]
     * 选择：字符s[i] 和 字符t[j] 相等、不相等
     * dp[i][j]:子串s[0..i]的 子序列中，出现子串t[0..j]的次数
     * base acse: t=""、i<j
     * 状态转移方程：
     * 字符s[i]，在子串的位置是 s[i-1]，下标从0开始
     * 字符t[j]，在子串的位置是 t[j-1]，下标从0开始
     * s[i-1]== t[j-1]
     * dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
     * s[i-1]!= t[j-1]
     * dp[i][j] = dp[i - 1][j];
     * <p>
     * 解释：
     * 字符s[i]和字符t[j]相等
     * s有两种选择
     * 使用字符s[i]去匹配，结果为子问题的次数
     */
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        // dp
        int[][] dp = new int[m + 1][n + 1];
        // base case
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 状态转移方程
                if (s.charAt(i - 1) == t.charAt(j - 1)) { //
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1]; // 使用s[i-1]字符 和 不使用s[i-1]字符两种情况
                } else {
                    dp[i][j] = dp[i - 1][j]; // 不相等，肯定不包含s[i-1]字符 ，取去掉s[i-1]字符的子问题最优解
                }
            }
        }
        return dp[m][n];
    }

    /**
     * 2,.带备忘录的递归
     * 自顶向下分解成子问题
     * 子问题自底向上被解决
     */
    public int solution(String s, String t) {
        int m = s.length();
        int n = t.length();
        memo = new int[m][n];
        // 初始化备忘录为特殊值 -1
        for (int[] temp : memo) {
            Arrays.fill(temp, -1);
        }
        int res = dp(s, 0, t, 0);
        return res;
    }

    private int[][] memo;

    // dp(s,i,t,j)：子串s[i...]的 子序列中，出现子串t[i..]的次数
    public int dp(String s, int i, String t, int j) {
        // base case 1，t[i..]只有一个字符时，次数为1
        if (j == t.length()) {
            return 1;
        }
        // base case 2 ，子串s[i...] 小于 子串t[i..]的长度时。不存在，次数为0
        if (s.length() - i < t.length() - j) {
            return 0;
        }
        // 查备忘录
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        // 状态转移
        int res = 0;
        if (s.charAt(i) == t.charAt(j)) {
            res = dp(s, i + 1, t, j + 1) +  // 使用字符s[i]
                    dp(s, i + 1, t, j);   // 不使用字符s[i]
        } else {
            res = dp(s, i + 1, t, j);  // 不相等，肯定不包含s[i-1]字符 ，取去掉s[i-1]字符的子问题最优解
        }
        // 结果存入备忘录
        memo[i][j] = res;
        return memo[i][j];
    }
}
