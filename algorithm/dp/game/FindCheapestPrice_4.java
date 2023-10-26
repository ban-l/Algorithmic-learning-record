package org.algorithm.dp.game;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: Ban
 * @Date: 2023/9/24 10:34
 * @Description: <p>
 * K 站中转内最便宜的航班
 * 有 n 个城市通过一些航班连接。给你一个数组 flights ，其中 flights[i] = [fromi, toi, pricei] ，表示该航班都从城市 fromi 开始，以价格 pricei 抵达 toi。
 * 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到出一条最多经过 k 站中转的路线，使得从 src 到 dst 的 价格最便宜 ，并返回该价格。
 * 如果不存在这样的路线，则输出 -1。
 * <p>
 * 输入:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 1
 * 输出: 200
 * <p>
 * 输入:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 0
 * 输出: 500
 */
public class FindCheapestPrice_4 {

    /**
     * 很明显，这题就是个 加权 有向图 中求 最短路径 的问题。
     * 就是给你一幅加权有向图，让你求 src 到 dst 权重最小的一条路径，同时要满足，这条路径最多不能超过 K + 1 条边（经过 K 个节点相当于经过 K + 1 条边）。
     */


    /**
     * 1.动态规划，自底向上递推
     * <p>
     * 状态：航班数量，到达城市
     * <p>
     * 选择：枚举前一个城市（起点，即上一个航班的终点） 到达 现在城市 的最小花费
     * <p>
     * dp[t][i]:从出发点str，经过 t 次航班，到达城市 i ，所需要的最小花费
     * <p>
     * base case：i是到达城市，src是出发城市
     * i==src, dp[i][j] = 0，到达城市和出发城市同一个，花费为0；
     * i!=src, dp[i][j] = MAX，不合法状态设为极大值，方便后续求最小值;
     * <p>
     * 状态转移方程：
     * dp[t][i] 只与 dp[t-1][...] 有关，取前一个航班 到达 现在航班 的最小花费；
     * <p>
     * dp[t][i] = min(dp[t-1][j] + cost(j,i))
     * 其中，(j,i)属于flights，表示在给定的航班数组 flights 中存在从城市 j 出发到达城市 i 的航班，cost(j,i)表示该航班的花费。
     *
     * <p>
     * 最终答案为：最多搭乘 k+1 次航班，到达城市 dst 的最小花费。即：dp[1][dst],dp[2][dst],⋯,dp[k+1][dst]的最小值
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // dp:最多搭乘 k+1 次航班，到达 n个城市
        int[][] dp = new int[k + 2][n];
        // base case 1，不合法，取极大值，方便后续求最小值;
        final int INF = 10000 * 101 + 1;
        for (int[] i : dp) {
            Arrays.fill(i, INF);
        }
        // base case 2，到达城市和出发城市同一个，花费为0
        dp[0][src] = 0;
        // 状态转移方程
        for (int t = 1; t <= k + 1; t++) { // t次航班
            for (int[] flight : flights) {
                int j = flight[0]; // 上一个城市（起点）
                int i = flight[1]; // 到达城市
                int cost = flight[2]; // j 到 i 的花费
                dp[t][i] = Math.min(dp[t][i], dp[t - 1][j] + cost);
            }
        }
        // 最终答案为：最多搭乘 k+1 次航班，到达城市 dst 的最小花费。即：dp[1][dst],dp[2][dst],⋯,dp[k+1][dst]的最小值
        int res = INF;
        for (int i = 1; i <= k + 1; i++) {
            res = Math.min(res, dp[i][dst]);
        }
        return res == INF ? -1 : res;
    }

    /**
     * 2.带备忘录的递归
     */
    public int findCheapestPrice2(int n, int[][] flights, int src, int dst, int k) {
        // 将中转站个数转化成边的条数
        k++;
        this.src = src;
        this.dst = dst;

        // 初始化备忘录，全部填一个特殊值
        memo = new int[n][k + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -888);
        }

        indegree = new HashMap<>();
        for (int[] f : flights) {
            int from = f[0];
            int to = f[1];
            int price = f[2];
            // 记录谁指向该节点(to)，以及之间的权重
            indegree.putIfAbsent(to, new LinkedList<>());
            indegree.get(to).add(new int[]{from, price});
        }

        return dp(dst, k);
    }

    // 哈希表记录每个点的入度
    // to -> [from, price]
    HashMap<Integer, List<int[]>> indegree;
    int src, dst;

    // 备忘录
    int[][] memo;

    // dp：从起点 src 出发，k 步之内（一步就是一条边），到达节点 s 的最小路径权重为 dp(s, k)
    public int dp(int s, int k) {
        if (s == src) {
            return 0;
        }
        if (k == 0) {
            return -1;
        }

        // 查备忘录，防止冗余计算
        if (memo[s][k] != -888) {
            return memo[s][k];
        }

        // 初始化为最大值，方便等会取最小值
        int res = Integer.MAX_VALUE;
        if (indegree.containsKey(s)) {
            // 当 s 有入度节点时，分解为子问题
            for (int[] v : indegree.get(s)) {
                int from = v[0];
                int price = v[1];
                // 从 src 到达相邻的入度节点所需的最短路径权重
                int subProblem = dp(from, k - 1);
                // 跳过无解的情况
                if (subProblem != -1) {
                    res = Math.min(res, subProblem + price);
                }
            }
        }
        // 如果还是初始值，说明此节点不可达
        // 存入备忘录
        memo[s][k] = res == Integer.MAX_VALUE ? -1 : res;
        return memo[s][k];
    }
}