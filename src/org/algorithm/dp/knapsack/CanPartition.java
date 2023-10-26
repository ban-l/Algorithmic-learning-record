package org.algorithm.dp.knapsack;

/**
 * @Auther: Ban
 * @Date: 2023/9/18 09:51
 * @Description: <p>
 * 分割等和子集
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */
public class CanPartition {

    /**
     * 理解题意：找到一个子集，使和为 sum/2
     * 转化成背包问题
     * 给你一个容量为 sum/2 的背包 和 n个物品，每个物品重量为nums[i]，现在让你装物品，是否存在一种装法，能够恰好将背包装满？
     * <p>
     * 1.状态：容量 sum/2
     * <p>
     * 2.选择：放、不放
     * <p>
     * 3.dp[i][j]:前i个物品，放入容量为j的背包中，是否能装满？能为true，不能为false
     * <p>
     * 4.base case：
     * 物品个数为0：i=0，j，dp[0][j]=flase;
     * 容量为0：i，j=0，dp[i][0]=true，容量为0，就相当于装满了
     * <p>
     * 5.状态转移方程：
     * 放不下（不放）
     * ——dp[i][j] = 前i-1个物品，放入容量为j的背包中，是否能装满？
     * ——dp[i][j] = dp[i-1][j];
     * <p>
     * 放得下
     * 如果不把 nums[i] 算入子集，或者说你不把这第 i 个物品装入背包，那么是否能够恰好装满背包，取决于上一个状态 dp[i-1][j]，继承之前的结果。
     * ——dp[i][j] = 前i-1个物品，放入容量为j的背包中，是否能装满？
     * ——dp[i][j] = dp[i - 1][j];
     * <p>
     * 如果把 nums[i] 算入子集，或者说你把这第 i 个物品装入了背包，那么是否能够恰好装满背包，取决于状态 dp[i-1][j-nums[i-1]]。
     * ——dp[i - 1][j-nums[i-1]] 也很好理解：你如果装了第 i 个物品，就要看背包的剩余重量 j - nums[i-1] 限制下是否能够被恰好装满。
     * ——如果 j - nums[i-1] 的重量可以被恰好装满，那么只要把第 i 个物品装进去，也可恰好装满 j 的重量；否则的话，重量 j 肯定是装不满的。
     * ——dp[i][j] = 前i-1个物品，放入容量为j - nums[i - 1]的背包中，是否能装满？
     * ——dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
     */
    public boolean canPartition(int[] nums) {
        int w = 0;
        for (int num : nums) {
            w += num;
        }
        // 和为奇数时，不可能划分成两个和相等的集合，直接返回false
        if (w % 2 != 0) {
            return false;
        }
        w = w / 2; // 容量
        int n = nums.length; // 物品
        // dp
        boolean[][] dp = new boolean[n + 1][w + 1];
        // base case
        for (int i = 0; i <= n; i++) { // 容量为0，就相当于装满了
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (nums[i - 1] > j) { // 背包容量不足，放不下
                    dp[i][j] = dp[i - 1][j];
                } else { // 放得下
                    // 放入或不放入背包
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
//                    if (dp[i - 1][j - nums[i - 1]]) { // 放入
//                        dp[i][j] = dp[i - 1][j - nums[i - 1]];
//                    } else {  // 不放入背包
//                        dp[i][j] = dp[i - 1][j];
//                    }
                }
            }
        }
        return dp[n][w];
    }
}
