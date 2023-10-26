package org.algorithm.tree.bst;

/**
 * @Auther: Ban
 * @Date: 2023/8/31 09:05
 * @Description: <p>
 * <p>
 * 不同的二叉搜索树
 */
public class NumTrees {

    // 备忘录
    private int[][] memo;

    /**
     * 1.带备忘录的递归
     * 「自顶向下」进行「递归」求解
     */

    public int numTrees(int n) {
        // 备忘录的值初始化为 0
        memo = new int[n + 1][n + 1];
        return count(1, n);
    }

    public int count(int lo, int hi) {
        if (lo > hi) return 1;
        // 查备忘录
        if (memo[lo][hi] != 0) {
            return memo[lo][hi];
        }

        int res = 0;
        for (int mid = lo; mid <= hi; mid++) {
            // mid 的值作为根节点 root
            int left = count(lo, mid - 1);
            int right = count(mid + 1, hi);
            // 左右子树的组合数乘积是 BST 的总数
            res += left * right;
        }
        // 将结果存入备忘录
        memo[lo][hi] = res;

        return res;
    }


    /**
     * 2.动态规划
     * 「自底向上」进行「递推」求解
     */
    public int numTrees2(int n) {
        int[] dp = new int[n + 1];
        // base case
        dp[0] = 1;
        dp[1] = 1;
        // 从 n =2 开始
        for (int i = 2; i <= n; i++) { // 求长度为 i 的序列能构成的 不同BST的个数
            for (int j = 1; j <= i; j++) {
                // 求以 j 为根节点的 BST数量
                int temp = dp[j - 1] * dp[i - j]; // 左右子树的组合数乘积是 BST数量
                dp[i] += temp;
            }
        }
        return dp[n];
    }

    /**
     * 3.数学
     */
    public int numTrees3(int n) {
        // 提示：我们在这里需要用 long 类型防止计算过程中的溢出
        long C = 1;
        for (int i = 0; i < n; i++) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }
}

