package org.algorithm.Meituan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Auther: Ban
 * @Date: 2023/12/2 19:47
 * @Description: <p>
 * 3.小美的树上染色
 */
public class PastExamPapers3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            a.add(scanner.nextInt());
        }
        List<List<Integer>> g = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            g.add(new ArrayList<>());
        }
        for (int i = 1; i < n; ++i) {
            int u = scanner.nextInt() - 1;
            int v = scanner.nextInt() - 1;
            g.get(u).add(v);
            g.get(v).add(u);
        }
        int[][] dp = new int[n][2];
        dfs(0, -1, g, dp, a);
        System.out.println(Math.max(dp[0][0], dp[0][1]));
    }

    static void dfs(int u, int fa, List<List<Integer>> g, int[][] dp, List<Integer> a) {
        for (int v : g.get(u)) {
            if (v == fa) continue;
            dfs(v, u, g, dp, a);
            dp[u][0] += Math.max(dp[v][0], dp[v][1]);
        }
        for (int v : g.get(u)) {
            if (v == fa) continue;
            long val = (long) a.get(v) * a.get(u);
            long sq = (long) Math.sqrt(val + 0.5);
            if (sq * sq != val) continue;
            dp[u][1] = Math.max(dp[u][1], (dp[u][0] - Math.max(dp[v][0], dp[v][1])) + dp[v][0] + 2);
        }
    }
}
