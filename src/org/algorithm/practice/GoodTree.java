package org.algorithm.practice;

import java.util.Arrays;

/**
 * @Auther: Ban
 * @Date: 2023/9/7 08:56
 * @Description: <p>
 * <p>
 * 题目描述：
 * 小红定义一个二叉树为“好二叉树”,当且仅当该二叉树所有节点的孩子数量为偶数(0或者2)。
 * 小红想知道，n个节点组成的二叉树tree，共有多少种不同的形态？答案请对10^9+7取模。
 * <p>
 * 数据范围：1≤n≤3000
 * <p>
 * 示例：
 * 输入：5
 * 输出：2
 */
public class GoodTree {
    private static int mod = 1000000007; // 取模
    private static int[] memo = new int[3001]; // 备忘录，消除重叠子问题

    /**
     * 1.带备忘录的递归  自顶向下，递归求解
     * 大问题划分为子问题
     * 根节点结果，可划分为多类，左子树节点数 + 1 + 左子树节点数
     * 例如 n =7，可以划分为：
     * 左子树 n=1  *  右子树n=5
     * 左子树 n=3  *  右右子树n=3
     * 左子树 n=5  *  右右子树n=1
     * 为什么n不能为偶数 ，n为偶数 则不存在这样形态 ，结果为0
     */
    public static int recursion(int n) {
        // base case n为偶数时，不存在
        if (n % 2 == 0 || n < 0) {
            return 0;
        }
        // base case n为1时，只有一种形态
        if (n == 1) {
            return 1;
        }
        if (memo[n] != -1) { // 备忘录
            return memo[n];
        }
        int res = 0;
        for (int i = 1; i < n; i += 2) { // n可划分为多类，左子树节点数 + 1 + 左子树节点数
            int a = recursion(i); // 左子树结果
            int b = recursion(n - i - 1); // 左子树结果
            res += a * b % mod;
        }
        return memo[n] = res; // 记录返回
    }

    /**
     * 2.动态规划  自底向上 递推求解
     * 状态：n
     * 选择：左子树节点数 + 1 + 左子树节点数
     * dp[i]: 节点数为i时，有多少种不同的形态
     * base：i =1 ，i =0 i%2==0
     * 状态转移方程：
     * dp[i] = res + dp[j-1] * dp[i - 1 -j]
     */
    public static int dp(int n) {
        // dp
        int[] dp = new int[n + 1];
        // base case
        dp[1] = 1;
        // 状态转移方程
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) continue; // i为偶数不存在
            int res = 0; // 记录分类结果累加和
            for (int j = 1; j < n; j += 2) { // 根据子树节点数变化，分类
                // 左子树节点数 + 1 + 左子树节点数 = i
                res += dp[j] * dp[i - j - 1] % mod;
            }
            dp[i] = res;
        }
        return dp[n];
    }


    public static void main(String[] args) {
        Arrays.fill(memo, -1);
        System.out.println(recursion(5));
        System.out.println(recursion(2999));
    }
}
