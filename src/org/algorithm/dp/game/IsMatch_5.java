package org.algorithm.dp.game;

import java.util.Arrays;

/**
 * @Auther: Ban
 * @Date: 2023/9/30 09:29
 * @Description: <p>
 * <p>
 * 正则表达式匹配
 * <p>
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 */
public class IsMatch_5 {
    /**
     * 1.动态规划 - 自底向上递推
     * <p>
     * 状态：s[0...i]、p[0...j]
     * <p>
     * 选择：s的第i个字符 是否等于 p的第j个字符
     * <p>
     * dp[i][j]：s的前i个字符和p的前j个字符的匹配结果，即字符串s[0...i]和p[0...j]是否匹配
     * <p>
     * base case:
     * s=""，p=""，dp[0][0]=true
     * <p>
     * 状态转移方程：
     * 根据选择：s的第i个字符 是否等于 p的第j个字符，下标从0开始
     */
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    /**
     * 2.带备忘录的递归-自顶向下递归求解-子问题自底向上被解决
     */
    public boolean isMatch2(String s, String p) {
        memo = new int[s.length()][p.length()];
        for (int[] t : memo) {
            Arrays.fill(t, -1);
        }
        // 指针 i，j 从索引 0 开始移，答案就是 i = 0, j = 0 时 dp 函数的结果
        return dp(s, 0, p, 0);
    }


    /**
     * 备忘录
     * -1：没计算
     * 1：true
     * 0：false
     */
    private int[][] memo;

    /**
     * dp(s, i, p, j)表示字符串s[i...]和p[j...]是否匹配
     * 若 dp(s, i, p, j) = true，则表示 s[i..] 可以匹配 p[j..]
     * 若 dp(s, i, p, j) = false，则表示 s[i..] 无法匹配 p[j..]
     */
    public boolean dp(String s, int i, String p, int j) {
        int m = s.length();
        int n = p.length();
        // base case
        // 字符p走到结尾
        if (j == n) {
            return i == m;
        }
        //  字符s走到结尾
        if (i == m) {
            // 如果能匹配空串，一定是字符和 * 成对儿出现
            if ((n - j) % 2 == 1) {
                return false;
            }
            // 检查是否为 x*y*z* 这种形式
            for (; j + 1 < n; j += 2) {
                if (p.charAt(j + 1) != '*') {
                    return false;
                }
            }
            return true;
        }
        // 查备忘录，防止重复计算
        if (memo[i][j] != -1) {
            return memo[i][j] == 1;
        }
        boolean res = false;
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            // 匹配
            if (j < n - 1 && p.charAt(j + 1) == '*') {
                // 1.1 通配符匹配 0次或多次
                res = dp(s, i, p, j + 2) ||
                        dp(s, i + 1, p, j);
            } else {
                // 1.2 无通配符,常规匹配 1 次
                res = dp(s, i + 1, p, j + 1);
            }
        } else {
            // 不匹配
            if (j < n - 1 && p.charAt(j + 1) == '*') {
                // 2.1 通配符匹配0次
                res = dp(s, i, p, j + 2);
            } else {
                // 2.2 无通配符,无法继续匹配
                res = false;
            }
        }
        // 将当前结果记入备忘录
        memo[i][j] = res ? 1 : 0;
        return res;
    }


    // 不考虑 '*'，进行匹配
    public boolean isMatch3(String s, String p) {
        int m = s.length();
        int n = p.length();
        int i = 0, j = 0;
        while (i < m && j < n) {
            // 「.」通配符就是万金油
            if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                // 匹配，接着匹配 s[i+1..] 和 p[j+1..]
                i++;
                j++;
            } else {
                // 不匹配
                return false;
            }
        }
        return i == j;
    }

}
