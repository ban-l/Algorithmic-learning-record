package org.algorithm.backtrack.island;

/**
 * @Auther: Ban
 * @Date: 2023/10/27 14:57
 * @Description: <p>
 * 岛屿的最大面积
 */
public class MaxAreaOfIsland_3 {
    private int m;
    private int n;
    private int res;

    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 发现每一个岛屿
                if (grid[i][j] == 1) {
                    res = 0;
                    // 淹没岛屿
                    dfs(grid, i, j);
                    // 比较
                    max = Math.max(max, res);
                }
            }
        }
        return max;
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
