package org.algorithm.backtrack.island;

/**
 * @Auther: Ban
 * @Date: 2023/10/27 14:42
 * @Description: <p>
 * 飞地的数量
 * 解法和“统计封闭岛屿的数目”一样
 */
public class NumEnclaves_2 {
    private int m;
    private int n;
    private int res;

    // 主函数：计算封闭岛屿的数量
    public int numEnclaves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        // 淹没 靠近边界 的岛屿
        for (int j = 0; j < n; j++) {
            // 淹没 靠近上边界 的岛屿
            dfs(grid, 0, j);
            // 淹没 靠近下边界 的岛屿
            dfs(grid, m - 1, j);
        }
        for (int i = 0; i < m; i++) {
            // 淹没 靠近左边界 的岛屿
            dfs(grid, i, 0);
            // 淹没 靠近右边界 的岛屿
            dfs(grid, i, n - 1);
        }
        // 处理其它岛屿，剩下的岛屿都是封闭岛屿
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 发现每一个岛屿
                if (grid[i][j] == 1) {
                    res = 0;
                    // 淹没岛屿
                    dfs(grid, i, j);
                    // 统计数量
                    ans += res;
                }
            }
        }
        return ans;
    }

    // 从 i,j开始，把与之相邻的岛屿淹没
    public void dfs(int[][] grid, int i, int j) {
        // 越界
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        // 已经是海水了
        if (grid[i][j] == 0) {
            return;
        }
        // 将 (i, j) 变成海水
        grid[i][j] = 0;
        // 统计数量
        res++;
        // 淹没上下左右的陆地
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}
