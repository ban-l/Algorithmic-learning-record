package org.algorithm.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Auther: Ban
 * @Date: 2023/3/21 14:52
 * @Description: 经典的树形DP问题
 * <p>
 * 深度优先搜索+动态规划
 * <p>
 * 使用递归的方式实现“树形DP”
 * <p>
 * 先计算“子节点”的值(两种，选择和不选择的值)，再根据子节点值“更新当前节点值”
 * <p>
 * dp[i][0]表示不取i节点的结果；
 * dp[i][1]表示取i节点的结果
 * <p>
 * 思路：对于i节点
 * 若不选择i节点，其相邻的节点j可以选、也可以不选，则dp[i][0] += max(dp[j][0], dp[j][1])，结果为：子节点j选择和不选择的值，取最大,累加。
 * 若选择i节点，其相邻的节点j“不”可以选、dp[i][1] += dp[j][0]，结果为：不选择子节点j的值累加。
 * <p>
 * 状态转移方程为：
 * dp[i][0] += max(dp[j][0], dp[j][1]); // i 是 j 的邻接点
 * dp[i][1] += dp[j][0];
 */
public class Algo4结点选择 {

    // dp[i][0]表示不取i节点的结果
    // dp[i][1]表示取i节点的结果
    public static int[][] dp;
    // 邻接表，存储节点之间关系
    public static List<List<Integer>> g = new ArrayList<>();

    public static void dfs(int son, int far) {
        List<Integer> node = g.get(son);
        for (int i = 0; i < node.size(); i++) {
            int temp = node.get(i); // 得到 son 的邻接点
            if (temp != far) { // 邻接点不能是父节点,要得到子节点
                dfs(temp, son); //深度优先遍历
                dp[son][0] += Math.max(dp[temp][0], dp[temp][1]); // 不选择,子节点选择和不选择的值，取最大,累加。
                dp[son][1] += dp[temp][0]; // 选择,不选择子节点的值累加。
            }
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine(); // 读取Enter,以防下一个nextLine读取到（会结束输入）
        String[] str = in.nextLine().split(" ");
        // 创建dp
        dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            dp[i][1] = Integer.parseInt(str[i]); // 初始化，存放每个节点权值
            g.add(new ArrayList<Integer>()); // 节点
        }
        // 构建图，使用邻接表来存储节点关系
        for (int i = 0; i < n - 1; i++) {
            String[] ab = in.nextLine().split(" ");
            int a = Integer.parseInt(ab[0]) - 1;
            int b = Integer.parseInt(ab[1]) - 1;
            // 关系
            g.get(a).add(b);
            g.get(b).add(a);
        }
        in.close();
        dfs(0, -1);
        // 累加到根节点，两种情况（选择，不选择）取最大值，即为最优
        System.out.println(Math.max(dp[0][0], dp[0][1]));
    }
}
