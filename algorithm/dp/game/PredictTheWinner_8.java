package org.algorithm.dp.game;

/**
 * @Auther: Ban
 * @Date: 2023/10/4 10:14
 * @Description: <p>
 * <p>
 * 博弈问题：
 * <p>
 * 你和你的朋友面前有一排石头堆，用一个数组 piles 表示，piles[i] 表示第 i 堆石子有多少个。
 * 你们轮流拿石头，一次拿一堆，但是只能拿走最左边或者最右边的石头堆。
 * 所有石头被拿完后，谁拥有的石头多，谁获胜。
 * <p>
 * 石头的堆数可以是任意正整数，石头的总数也可以是任意正整数，这样就能打破先手必胜的局面了。
 * 比如有三堆石头 piles = [1, 100, 3]，先手不管拿 1 还是 3，能够决定胜负的 100 都会被后手拿走，后手会获胜。
 * <p>
 * 假设两人都很聪明，请你写一个 stoneGame 函数，返回先手和后手的最后得分（石头总数）之差。
 * 比如上面那个例子，先手能获得 4 分，后手会获得 100 分，你的算法应该返回 -96。
 */
public class PredictTheWinner_8 {


    /**
     * 返回游戏最后先手和后手的得分之差
     * <p>
     * 状态：开始的索引 i，结束的索引 j，当前轮到的人。
     * <p>
     * 选择：选择最左边的那堆石头，或者选择最右边的那堆石头。
     * <p>
     * dp[i][j]: 对于i和j之间的值
     * dp[i][j].fir = x 表示，对于 piles[i...j] 这部分石头堆，先手能获得的最高分数为 x
     * dp[i][j].sec = y 表示，对于 piles[i...j] 这部分石头堆，后手能获得的最高分数为 y。
     * <p>
     * base case:
     * i==j
     * 先手可以获得值，后手为0
     * <p>
     * 状态转移方程：
     * 选择最左边的那堆石头，或者选择最右边的那堆石头，先手的选择会对后手有影响
     * <p>
     * dp[i][j].fir = max(piles[i] + dp[i+1][j].sec, piles[j] + dp[i][j-1].sec)
     * dp[i][j].fir = max(     选择最左边的石头堆     ,     选择最右边的石头堆      )
     * <p>
     * if 先手选择左边:
     * dp[i][j].sec = dp[i+1][j].fir
     * if 先手选择右边:
     * dp[i][j].sec = dp[i][j-1].fir
     * <p>
     * 遍历顺序：从下到上，从左到右
     */
    public boolean PredictTheWinner(int[] nums) {
        // 先手的分数大于等于后手，则能赢
        return stoneGame(nums) >= 0;
    }

    public int stoneGame(int[] nums) {
        int n = nums.length;
        // dp[i][j]
        Pair[][] dp = new Pair[n][n];
        // 初始化dp，否则默认为null
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                dp[i][j] = new Pair(0, 0);
            }
        }
        // base case i ==j
        for (int i = 0; i < n; i++) {
            dp[i][i].fir = nums[i]; // 先手为nums[i]
            dp[i][i].sec = 0; // 后手为0
        }
        // 倒着遍历数组
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                // 先手选择最左边 或 最右边的分数
                int left = nums[i] + dp[i + 1][j].sec;
                int right = nums[j] + dp[i][j - 1].sec;
                // 套用状态转移方程
                // 先手肯定会选择更大的结果，后手的选择随之改变
                if (left > right) {
                    dp[i][j].fir = left;
                    dp[i][j].sec = dp[i + 1][j].fir;
                } else {
                    dp[i][j].fir = right;
                    dp[i][j].sec = dp[i][j - 1].fir;
                }
            }
        }
        Pair res = dp[0][n - 1];
        return res.fir - res.sec;
    }

    class Pair {
        int fir, sec;

        Pair(int fir, int sec) {
            this.fir = fir;
            this.sec = sec;
        }
    }

}
