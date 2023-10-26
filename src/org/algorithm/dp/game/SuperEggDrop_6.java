package org.algorithm.dp.game;

import java.util.Arrays;

/**
 * @Auther: Ban
 * @Date: 2023/10/2 08:53
 * @Description: <p>
 * 鸡蛋掉落
 * <p>
 * 给你 k 枚相同的鸡蛋，并可以使用一栋从第 1 层到第 n 层共有 n 层楼的建筑。
 * <p>
 * 已知存在楼层 f ，满足 0 <= f <= n ，任何从 高于 f 的楼层落下的鸡蛋都会碎，从 f 楼层或比它低的楼层落下的鸡蛋都不会破。
 * <p>
 * 每次操作，你可以取一枚没有碎的鸡蛋并把它从任一楼层 x 扔下（满足 1 <= x <= n）。如果鸡蛋碎了，你就不能再次使用它。如果某枚鸡蛋扔下后没有摔碎，则可以在之后的操作中 重复使用 这枚鸡蛋。
 * <p>
 * 请你计算并返回要确定 f 确切的值 的 最小操作次数 是多少？
 */
public class SuperEggDrop_6 {

    /**
     * 你面前有一栋从 1 到 N 共 N 层的楼，然后给你 K 个鸡蛋（K 至少为 1）。
     * 现在确定这栋楼存在楼层 0 <= F <= N，在这层楼将鸡蛋扔下去，鸡蛋恰好没摔碎（高于 F 的楼层都会碎，低于 F 的楼层都不会碎，如果鸡蛋没有碎，可以捡回来继续扔）。
     * 现在问你，最坏情况下，你至少要扔几次鸡蛋，才能确定这个楼层 F 呢？
     */

    /**
     * 1.带备忘录的递归
     * <p>
     * 状态：k个鸡蛋，n层楼
     * <p>
     * 选择：选择哪层楼(1…n)扔鸡蛋（每个选择有两种情况：碎了，没碎）
     * <p>
     * dp(k,n): 当前k个鸡蛋，n层楼，确定 f 确切的值的 最小操作次数为 dp(k,n)
     * <p>
     * base case:
     * k=1, dp=n，一个鸡蛋，只能线性扫描所有楼层
     * n=0，dp=0，楼层为0，不用扔鸡蛋
     * <p>
     * 状态转移方程：
     * 共 [1..n]选择，1<= i <= n,每个选择有两种情况：碎了，没碎
     * 碎了
     * dp(k,n) = dp(k-1,i+1)
     * 没碎
     * dp(k,n) = dp(k,n-i)
     */
    private int[][] memo; // 备忘录

    public int superEggDrop(int k, int n) {
        // 初始化备忘录，给予特殊值
        memo = new int[k + 1][n + 1];
        for (int[] t : memo) {
            Arrays.fill(t, -666);
        }
        return dp(k, n);
    }

    // 当前k个鸡蛋，n层楼，确定 f 确切的值的 最小操作次数为 dp(k,n)
    public int dp(int k, int n) {
        // base case
        if (k == 1) { // 一个鸡蛋， dp=n，只能线性扫描所有楼层
            return n;
        }
        if (n == 0) { // 楼层为0，, dp=0，不用扔鸡蛋
            return 0;
        }
        if (memo[k][n] != -666) {
            return memo[k][n];
        }
        // 状态转移
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) { // 线性扫描，1..n，n种选择，取最优
            // 取最优选择
            res = Math.min(
                    res,
                    // 碎和没碎取，取最坏情况
                    Math.max(
                            dp(k - 1, i - 1),    // 碎了
                            dp(k, n - i)    // 没碎
                    ) + 1     // 在第 i 楼扔了一次
            );
        }
        // 结果存入备忘录
        memo[k][n] = res;
        return res;
    }


    // 2.
    public int dp2(int k, int n) {
        // base case
        if (k == 1) { // 一个鸡蛋， dp=n，只能线性扫描所有楼层
            return n;
        }
        if (n == 0) { // 楼层为0，, dp=0，不用扔鸡蛋
            return 0;
        }
        if (memo[k][n] != -666) {
            return memo[k][n];
        }

        // 二分搜索代替线性搜索
        int res = Integer.MAX_VALUE;
        int lo = 1, hi = n;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            // 鸡蛋在第 mid 层碎了和没碎两种情况
            int broken = dp2(k - 1, mid - 1);
            int no_broken = dp2(k, n - mid);
            // res = min(max(碎，没碎) + 1)
            if (broken > no_broken) {
                hi = mid - 1;
                res = Math.min(res, broken + 1);
            } else {
                lo = mid + 1;
                res = Math.min(res, no_broken + 1);
            }
        }
        memo[k][n] = res;
        return res;
    }

}