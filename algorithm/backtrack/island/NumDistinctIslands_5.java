package org.algorithm.backtrack.island;

import java.util.HashSet;

/**
 * @Auther: Ban
 * @Date: 2023/10/28 09:09
 * @Description: <p>
 * <p>
 * 题目还是输入一个二维矩阵，0 表示海水，1 表示陆地，这次让你计算 不同的 (distinct) 岛屿数量
 */
public class NumDistinctIslands_5 {

    private HashSet<String> res = new HashSet<>();
    private int m;
    private int n;

    public int numDistinctIslands(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, 0, sb);
                    res.add(sb.toString());
                }
            }
        }
        return res.size();
    }

    //  从i，j开始，把与之相邻的岛屿淹没，并记录路径
    private void dfs(int[][] grid, int i, int j, int dir, StringBuilder sb) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        if (grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        sb.append(dir);
        dfs(grid, i - 1, j, 1, sb);
        dfs(grid, i + 1, j, 2, sb);
        dfs(grid, i, j - 1, 3, sb);
        dfs(grid, i, j + 1, 4, sb);
        sb.append(-dir);
    }
}
