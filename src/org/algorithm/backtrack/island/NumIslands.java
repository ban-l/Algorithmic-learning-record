package org.algorithm.backtrack.island;

/**
 * @Auther: Ban
 * @Date: 2023/10/24 14:30
 * @Description: <p>
 * 岛屿数量
 * <p>
 * dfs+剪枝
 * dfs遍历二维数组
 */
public class NumIslands {
    private int res = 0;

    // 主函数，计算岛屿数量
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 遍历grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 每发现一个岛屿，岛屿数量加一
                if (grid[i][j] == '1') {
                    res++;
                    // 使用dfs 淹没 发现的岛屿
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    // 从 (i, j) 开始，将与之相邻的陆地都变成海水
    private void dfs(char[][] grid, int i, int j) {
        // 越界返回
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) return;
        // 是海水返回
        if (grid[i][j] == '0') return;
        // 淹没，将 (i, j) 变成海水
        grid[i][j] = '0';
        // 淹没上下左右的陆地
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}
