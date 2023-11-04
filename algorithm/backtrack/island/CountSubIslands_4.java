package org.algorithm.backtrack.island;

/**
 * @Auther: Ban
 * @Date: 2023/10/27 15:37
 * @Description: <p>
 * 统计子岛屿
 * 当岛屿 grid2 中所有陆地在岛屿 grid1 中也是陆地的时候，岛屿 grid2 是岛屿 grid1 的子岛。
 * 即是：当 grid2 中存在一片陆地，但 grid1 中对应位置是海水，那么 grid2的这个岛屿 一定不是 grid1的子岛屿
 * 只要遍历 grid2 中的所有岛屿，把那些不可能是子岛的岛屿排除掉，剩下的就是子岛。
 */
public class CountSubIslands_4 {
    private int m;
    private int n;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        m = grid1.length;
        n = grid1[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 这个岛屿肯定不是子岛，淹掉
                if (grid2[i][j] == 1 && grid1[i][j] == 0) {
                    dfs(grid2, i, j);
                }
            }
        }
        // 现在 grid2 中剩下的岛屿都是子岛，计算岛屿数量
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    res++;
                    dfs(grid2, i, j);
                }
            }
        }
        return res;
    }

    // 从 (i, j) 开始，将与之相邻的陆地都变成海水
    private void dfs(int[][] grid2, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }
        if (grid2[i][j] == 0) {
            return;
        }
        grid2[i][j] = 0;
        dfs(grid2, i - 1, j);
        dfs(grid2, i + 1, j);
        dfs(grid2, i, j - 1);
        dfs(grid2, i, j + 1);
    }

}
