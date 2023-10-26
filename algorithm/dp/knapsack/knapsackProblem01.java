package org.algorithm.dp.knapsack;

import java.util.Scanner;

/**
 * @Auther: Ban
 * @Date: 2023/3/29 10:06
 * @Description: 动态规划
 * 01背包问题
 * <p>
 * 有 n 个物品和一个容量为 W 的背包，每个物品有重量 w_i  和价值v_i  两种属性，
 * 要求选若干物品放入背包，使背包中物品的总价值最大，且背包中物品的总重量不超过背包的容量。
 */
public class knapsackProblem01 {
    /**
     * 状态：物品个数，重量
     * <p>
     * 选择：放、不放
     * <p>
     * dp[i][j]:共i个物品，放入限重为j的背包中的最大价值
     * <p>
     * base case：
     * 物品个数为0：i=0，j，dp[0][j]=0;
     * 限重为0：i，j=0，dp[j][0]=0;
     * <p>
     * 状态转移方程（根据选择转移状态）
     * 1.放的下
     * ——放
     * ——dp[i][j] = 第i个物品的价值 + 前i-1个物品放入限重为剩余重量的背包中的最大价值
     * ——dp[i][j] = v[i-1] + dp[i-1][j-w[i-1]];
     * <p>
     * ——不放
     * ——dp[i][j] = 前i-1个物品放入限重为j的背包中的最大价值
     * ——dp[i][j] = dp[i-1][j]
     * <p>
     * ——放和不放 取最大值 dp[i][j] = max(v[i-1] + dp[i-1][j-w[i-1]],dp[i-1][j]);
     * <p>
     * 2.放不下(不放)
     * ——不放
     * ——dp[i][j] = 前i-1个物品放入限重为j的背包中的最大价值
     * ——dp[i][j] = dp[i-1][j];
     */
    public static int knapsack(int n, int m, int[] w, int[] v) {
        // dp
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) { // 遍历物品，物品w下标从0开始，i-1表示重量和价值
            for (int j = 1; j <= m; j++) {  // 遍历重量
                // 状态转移方程
                if (w[i - 1] > j) { // 放不下
                    dp[i][j] = dp[i - 1][j]; // 只能选择不放
                } else { // 放得下
                    int temp0 = v[i - 1] + dp[i - 1][j - w[i - 1]]; // 放
                    int temp1 = dp[i - 1][j]; // 不放
                    // 放和不放 取最大值
                    dp[i][j] = Math.max(temp0, temp1);
                }
            }
        }
        // 最大价值
        return dp[n][m];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // 物品个数
        int m = in.nextInt(); // 总重量
        int[] w = new int[n]; // 物品重量
        int[] v = new int[n]; // 物品价值
        for (int i = 0; i < n; i++) {
            w[i] = in.nextInt();
            v[i] = in.nextInt();
        }
        in.close();
        int max = knapsack(n, m, w, v);
        System.out.print(max);
    }
}