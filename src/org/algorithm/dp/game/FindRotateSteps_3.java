package org.algorithm.dp.game;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: Ban
 * @Date: 2023/9/23 09:21
 * @Description: <p>
 * <p>
 * 自由之路
 * <p>
 * 电子游戏“辐射4”中，任务 “通向自由” 要求玩家到达名为 “Freedom Trail Ring” 的金属表盘，并使用表盘拼写特定关键词才能开门。
 * <p>
 * 给定一个字符串 ring ，表示刻在外环上的编码；给定另一个字符串 key ，表示需要拼写的关键词。您需要算出能够拼写关键词中所有字符的最少步数。
 * <p>
 * 最初，ring 的第一个字符与 12:00 方向对齐。您需要顺时针或逆时针旋转 ring 以使 key 的一个字符在 12:00 方向对齐，然后按下中心按钮，以此逐个拼写完 key 中的所有字符。
 * <p>
 * 旋转 ring 拼出 key 字符 key[i] 的阶段中：
 * <p>
 * 您可以将 ring 顺时针或逆时针旋转 一个位置 ，计为1步。旋转的最终目的是将字符串 ring 的一个字符与 12:00 方向对齐，并且这个字符必须等于字符 key[i] 。
 * 如果字符 key[i] 已经对齐到12:00方向，您需要按下中心按钮进行拼写，这也将算作 1 步。按完之后，您可以开始拼写 key 的下一个字符（下一阶段）, 直至完成所有拼写。
 * <p>
 * 输入: ring = "godding", key = "gd"
 * 输出: 4
 * <p>
 * 输入: ring = "godding", key = "godding"
 * 输出: 13
 */
public class FindRotateSteps_3 {

    /**
     * 状态：ring、key
     * 选择：如何拨动指针得到待输入的字符，顺时针，逆时针，选择最少的
     * dp[i][j]:表示从前往后，拼出 key 的第 i 个字符，ring 的第 j 个字符与12:00方向对齐的 最少步数
     * base case:
     */
    // 字符 -> 索引列表
    HashMap<Character, List<Integer>> charToIndex = new HashMap<>();
    // 备忘录
    private int[][] memo;

    public int findRotateSteps(String ring, String key) {
        int m = ring.length();
        int n = key.length();
        // 备忘录初始化为0
        memo = new int[m][n];
        // 记录圆环上字符到索引的映射
        for (int i = 0; i < m; i++) {
            char c = ring.charAt(i);
            if (!charToIndex.containsKey(c)) {
                charToIndex.put(c, new LinkedList<>());
            }
            charToIndex.get(c).add(i);
        }
        // 圆盘指针初始指向12点钟方向
        // 从第一个字符开始输入key
        return dp(ring, 0, key, 0);
    }

    // 计算圆盘指针在 ring[i]，输入 key[j..] 的最少操作数
    public int dp(String ring, int i, String key, int j) {
        // base case ，完成输入
        if (j == key.length()) {
            return 0;
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        int n = ring.length();
        // 做选择
        int res = Integer.MAX_VALUE;
        // ring 上可能有多个字符key[j]
        for (int k : charToIndex.get(key.charAt(j))) {
            // 拨动指针的次数
            int delta = Math.abs(k - i);
            // 选择顺时针、还是逆时针
            delta = Math.min(delta, n - delta);
            // 将指针拨到 ring[k]，继续输入[j+1...]
            int subProblem = dp(ring, k, key, j + 1);
            // 选择【整体】操作次数最少的
            // 加一 ，是因为按钮也是一次操作
            res = Math.min(res, 1 + delta + subProblem);
        }
        memo[i][j] = res;
        return memo[i][j];
    }
}
