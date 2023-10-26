package org.algorithm.offer;

/**
 * @Auther: Ban
 * @Date: 2023/7/24 09:44
 * @Description: <p>
 * 矩阵中的路径
 * DFS
 */
public class JZ12 {

    private final static int[] ROW_C = {-1, 1, 0, 0,};
    private final static int[] COL_C = {0, 0, -1, 1};

    private static int n = 0;
    private static int m = 0;
    public static boolean[][] visited = null;
    public static char[] words = null;

    public static boolean hasPath(char[][] matrix, String word) {
        if (matrix == null || matrix.length == 0 || word == null || word.length() == 0) {
            return false;
        }
        n = matrix.length;
        m = matrix[0].length;
        visited = new boolean[n][m];
        words = word.toCharArray();
        //遍历矩阵找起点
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == word.charAt(0)) {
                    //通过dfs找到路径
                    if (dfs2(matrix, i, j, 0))
                        return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] matrix, int i, int j, int index) {
        // 找到返回
        if (index == words.length) {
            return true;
        }
        // 下标越界，返回false
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return false;
        }
        // 如果 matrix[i][j] 不等于 words[index] ，路走不通，返回false
        // visited[i][j] 防止走回头路
        if (matrix[i][j] != words[index] || visited[i][j]) {
            return false;
        }
        // 回溯
        visited[i][j] = true;
        //该结点任意方向可行就可
        boolean res = dfs(matrix, i - 1, j, index + 1) ||
                dfs(matrix, i + 1, j, index + 1) ||
                dfs(matrix, i, j - 1, index + 1) ||
                dfs(matrix, i, j + 1, index + 1);
        visited[i][j] = false;
        return res;
    }

    public static boolean dfs2(char[][] matrix, int i, int j, int index) {
        // 找到返回
        if (index == words.length) {
            return true;
        }
        // 下标越界，返回false
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return false;
        }
        // 如果 matrix[i][j] 不等于 words[index] ，路走不通，返回false
        // visited[i][j] 防止走回头路
        if (matrix[i][j] != words[index] || visited[i][j]) {
            return false;
        }
        // 回溯
        visited[i][j] = true;
        //该结点任意方向可行就可
        for (int k = 0; k < 4; k++) {
            int row = i + ROW_C[k];
            int col = j + COL_C[k];
            if (dfs(matrix, row, col, index + 1))
                return true;
        }
        visited[i][j] = false;
        return false;
    }


    public static void main(String[] args) {
        char[][] matrix = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        String target = "ABCCED";
        boolean result = hasPath(matrix, target);
        System.out.println("Path exists: " + result); // Output: true
    }
}
