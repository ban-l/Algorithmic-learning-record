package org.algorithm.dp.game;

import java.util.Arrays;

/**
 * @Auther: Ban
 * @Date: 2023/9/21 10:04
 * @Description: <p>
 * 地下城游戏
 * 恶魔们抓住了公主并将她关在了地下城 dungeon 的 右下角 。地下城是由 m x n 个房间组成的二维网格。
 * 我们英勇的骑士最初被安置在 左上角 的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。
 * <p>
 * 骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。
 * <p>
 * 有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；
 * 其他房间要么是空的（房间里的值为 0），要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。
 * <p>
 * 为了尽快解救公主，骑士决定每次只 向右 或 向下 移动一步。
 * <p>
 * 返回确保骑士能够拯救到公主所需的最低初始健康点数。
 * <p>
 * 注意：任何房间都可能对骑士的健康点数造成威胁，也可能增加骑士的健康点数，包括骑士进入的左上角房间以及公主被监禁的右下角房间。
 */
public class CalculateMinimumHP_2 {

    // 理解题意：就是问你至少需要多少初始生命值，能够让骑士从最左上角移动到最右下角，且任何时候生命值都要大于 0。

    /**
     * 1.动态规划(从后往前遍历)
     * <p>
     * 状态：网格位置 dungeon[i][j]
     * <p>
     * 选择：向下、向右
     * <p>
     * dp[i][j]:表示从坐标 (i,j)到终点所需的最小初始值。
     * <p>
     * base case:
     * dp[m][n] = dungeon[m-1][n-1]>0?1:-dungeon[m-1][n-1]+1
     * dp[m][j] = dp[m][j-1]-dungeon[i-1][0]
     * dp[i][n] = dp[i-1][n]-dungeon[0][j-1]
     * <p>
     * 状态转移
     * 基于子问题最优解，根据选择，转移状态
     * dp[i][j] 和 子问题dp[i-1][j]、dp[i][j-1] 有关
     * res = min(dp[i-1][j],dp[i][j-1]) - dungeon[i][j] ;
     * dp[i][j] = res>0?res:1
     */
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        // dp[i][j]表示(i,j)到终点所需的最小初始值。
        int[][] dp = new int[m + 1][n + 1];
        // base case
        dp[m - 1][n - 1] = dungeon[m - 1][n - 1] < 0 ? -dungeon[m - 1][n - 1] + 1 : 1;
        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (i == m || j == n) { // 越界处理，是设置为最大值，方便取min
                    dp[i][j] = Integer.MAX_VALUE;
                    continue;
                }
                if (i == m - 1 && j == n - 1) {  // 跳过base case
                    continue;
                }
                // 状态转移逻辑
                int res = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                dp[i][j] = res > 0 ? res : 1;
            }
        }
        return dp[0][0];
    }

    /**
     * 2.带备忘录的递归
     */
    public int calculateMinimumHP2(int[][] dungeon) {
        memo = new int[dungeon.length][dungeon[0].length];
        // 备忘录中都初始化为 -1
        for (int[] t : memo) {
            Arrays.fill(t, -1);
        }
        int res = dp(dungeon, 0, 0);
        return res;
    }

    private int[][] memo;

    // dp(dungeon,i,j)：从(i,j) 到达 右下角，需要的最低初始健康点数为 dp(dungeon,i,j)
    public int dp(int[][] dungeon, int i, int j) {
        //  base case
        if (i == dungeon.length - 1 && j == dungeon[i].length - 1) {
            return dungeon[i][j] >= 0 ? 1 : -dungeon[i][j] + 1;
        }
        // 越界处理，是设置为最大值，方便取min
        if (i == dungeon.length || j == dungeon[i].length) {
            return Integer.MAX_VALUE;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        // 状态转移逻辑
        int res = Math.min(
                dp(dungeon, i + 1, j),
                dp(dungeon, i, j + 1)
        ) - dungeon[i][j];
        memo[i][j] = res > 0 ? res : 1; // 任何时候生命值都要大于 0。即骑士的生命值至少为 1
        return memo[i][j];
    }
}
