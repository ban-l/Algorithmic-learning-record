package org.algorithm.dp;

import java.util.Arrays;

/**
 * @Auther: Ban
 * @Date: 2023/7/5 11:01
 * @Description: 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * <p>
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 */
public class CoinChange {

    /*
     * 对于递归问题，最好都画出递归树，这对你分析算法的复杂度，寻找算法低效的原因都有巨大帮助。
     *
     * 最优子结构：子问题最优解推出大问题最优解。
     */


    /**
     * 1.暴力递归，自顶向下，递归求解
     * base case：
     * 金额为0时，硬币个数为 0
     * 金额小于0时，凑不出，返回 -1
     */
    public int recursion(int[] coins, int amount) {
        // base case
        if (amount == 0) return 0;
        if (amount < 0) return -1;

        int res = amount + 1;
        for (int c : coins) {
            // 子问题结果
            int temp = recursion(coins, amount - c);
            // 子问题无解跳过
            if (temp == -1) continue;
            // 取子问题中的最优结果，然后+1
            res = Math.min(res, temp + 1);
        }
        return res == amount + 1 ? -1 : res;
    }


    /**
     * 2.带备忘录的递归，通过备忘录解决重叠子问题
     */
    public int[] memo;
    public int v;

    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        v = -110;
        // 备忘录初始化为一个不会被取到值，表示还未被计算
        Arrays.fill(memo, v);
        return recursionMemo(coins, amount);
    }

    public int recursionMemo(int[] coins, int amount) {
        // base case
        if (amount == 0) return 0;
        if (amount < 0) return -1;

        // 查询备忘录，存在结果返回，防止重复计算
        if (memo[amount] != v) {
            return memo[amount];
        }

        // 求最小值，初始化为最大值
        int res = Integer.MAX_VALUE;
        for (int c : coins) {
            // 子问题的结果
            int temp = recursionMemo(coins, amount - c);
            // 子问题无解跳过
            if (temp == -1) continue;
            // 取子问题中的最优结果，然后+1。+1表示子问题加一枚硬币可推出父问题
            res = Math.min(res, temp + 1);
        }
        // 子问题结果存入备忘录
        memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
        return memo[amount];
    }


    /**
     * 3.动态规划
     * dp 数组的迭代解法
     * dp[i]定义： 当目标金额为 i 时，至少需要 dp[i] 枚硬币凑出。
     */
    public int dp(int[] coins, int amount) {
        // dp[i]，当目标金额为 i 时，至少需要 dp[i] 枚硬币凑出。
        int[] dp = new int[amount + 1];
        // 初始化dp[i]=amount + 1，方便后续取最小值
        Arrays.fill(dp, amount + 1);
        // base case
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int c : coins) {
                // 子问题无解,跳过
                if (i - c < 0) {
                    continue;
                } else {
                    dp[i] = Math.min(dp[i], dp[i - c] + 1);
                }
            }
        }
        // 没有任何一种硬币组合能组成总金额，返回 -1
        int res = dp[amount] == amount + 1 ? -1 : dp[amount];
        return res;
    }

    /**
     public static void main(String[] args) {
     int[] coins = {1, 2, 5};
     int amount = 11;
     int res;
     // 1.暴力递归
     res = recursion(coins, amount);
     System.out.println(res);
     // 2.memo递归
     res = solution(coins, amount);
     System.out.println(res);
     // 3.动态规划
     res = dp(coins, amount);
     System.out.println(res);
     }
     **/
}
