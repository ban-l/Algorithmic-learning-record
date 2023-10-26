package org.algorithm.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: Ban
 * @Date: 2023/9/16 11:16
 * @Description: <p>
 * 单词拆分 II
 * <p>
 * 给定一个字符串 s 和一个字符串字典 wordDict ，在字符串 s 中增加空格来构建一个句子，使得句子中所有的单词都在词典中。以任意顺序 返回所有这些可能的句子。
 * <p>
 * 注意：词典中的同一个单词可能在分段中被重复使用多次。
 */
public class WordBreak2 {

    // WordBreak是找到一个，返回true就行
    // WordBreak2是找到全部，返回全部结果


    /**
     * 2.带备忘录的递归
     * 状态：子串s[i...]
     * 选择：前缀匹配
     * dp：返回 子串s[i..] 是否能够被拼出
     * base case：i==s.length
     * 状态转移方程：
     * if(i+len<=s.length() && s.substring(i,len).equals(word))
     * dp(s,i) = dp(s,i+len)
     */

    private List<String> res = new LinkedList<>();
    private List<String> track = new LinkedList<>();
    private HashSet<String> wordDict; // 用哈希集合方便快速判断是否存在
    private int[] memo; // 备忘录，-1 代表未计算，0 代表无法凑出，1 代表可以凑出

    public List<String> wordBreak(String s, List<String> wordDict) {
        // 转化为哈希集合，快速判断元素是否存在
        this.wordDict = new HashSet<>(wordDict);
        // 备忘录初始化为 -1
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        dp(s, 0);
        return res;
    }

    // 定义dp(s,i):返回 子串s[i..] 是否能够被拼出
    public boolean dp(String s, int i) {
        // base case,s[i..] 是空串
        if (i == s.length()) {
            res.add(String.join(" ", track));
            return true;
        }
        // 防止冗余计算
        if (memo[i] != -1) {
            return memo[i] == 0 ? false : true;
        }
        // 遍历 s[i..] 的所有前缀
        for (int len = 1; i + len <= s.length(); len++) {
            // 看看哪些前缀存在 wordDict 中
            String prefix = s.substring(i, i + len);
            if (wordDict.contains(prefix)) {
                track.add(prefix);
                // 找到一个单词匹配 s[i..i+len)
                // 只要 s[i+len..] 可以被拼出，s[i..] 就能被拼出
                boolean subProblem = dp(s, i + len);
                if (subProblem == true) {
                    memo[i] = 1;
                    return true;
                }
            }
        }
        // s[i..] 无法被拼出
        memo[i] = 0;
        return false;
    }


    /**
     * 3.动态规划
     * 状态：子串s[0...i]
     * 选择：前缀匹配
     * dp[i]：返回 子串s[0...i-1] 是否能够被拼出
     * base case：当 i==0 ，时表示空串""
     * 状态转移方程：
     * ——dp[i]：表示子串s[0...i-1]能否由字典中的单词拼出
     * ——dp[j]:表示子串s[0...j-1]能否被拼出，即已经求出的子问题最优解
     * <p>
     * ——状态转移的时候，考虑枚举分割点 j (1 <= j <= i)，将字符串分成 s[0,j-1] 和 s[j,i-1] 两部分
     * ——如果两部分都在字典中，则整个串可以由字典中的单词拼成
     * ——因为计算到 dp[i] 的时候，已经计算出了 dp[0]....dp[i-1] 的值, 所以 s[0,j-1] 直接由 dp[j] 即可得到
     * ——所以只需计算 s[j,i-1]  在不在字典中即可
     * ——所以如果 s[j,i-1] 在字典中且 dp[j] 为 true , 则 dp[i] = true , 否则 dp[i] = false
     */
    public boolean wordBreak3(String s, List<String> wordDict) {
        // 字符串字典
        HashSet<String> set = new HashSet(wordDict);
        int n = s.length();
        // dp
        boolean[] dp = new boolean[n + 1];
        // base case。空串一定可以拼出
        dp[0] = true;
        // 状态
        for (int i = 1; i <= n; i++) {
            // 选择
            for (int j = 0; j < i; j++) { // 分割点 j
                // 状态转移方程
                String s_j_i_1 = s.substring(j, i); // 表示子串s[j...i-1]，即子串s[0...i-1] 去掉 s[0...j-1]的内容
                if (dp[j] && set.contains(s_j_i_1)) {
                    dp[i] = true;
                    break; // 跳出内层循环
                }
            }
        }
        return dp[n];
    }
}
