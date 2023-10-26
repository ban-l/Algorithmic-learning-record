package org.algorithm.dp.subsequence;

/**
 * @Auther: Ban
 * @Date: 2023/9/5 10:34
 * @Description: <p>
 * 两个字符串的删除操作
 * 给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。
 * <p>
 * 每步 可以删除任意一个字符串中的一个字符。
 */
public class MinDistance {
    /**
     * 删除的结果 是它俩的最长公共子序列
     */
    public int minDistance(String word1, String word2) {
        // 求出最长公共子序列
        int lcs = solution(word1, word2);
        // 计算删除的次数
        int res1 = word1.length() - lcs;
        int res2 = word2.length() - lcs;
        return res1 + res2;
    }

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
}
