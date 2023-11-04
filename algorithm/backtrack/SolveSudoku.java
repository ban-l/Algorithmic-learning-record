package org.algorithm.backtrack;

/**
 * @Auther: Ban
 * @Date: 2023/10/28 10:31
 * @Description: <p>
 * 解数独
 * 编写一个程序，通过填充空格来解决数独问题。
 * 数独的解法需 遵循如下规则：
 * 1. 数字 1-9 在每一行只能出现一次。
 * 2. 数字 1-9 在每一列只能出现一次。
 * 3. 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 */
public class SolveSudoku {

    private int n;

    public void solveSudoku(char[][] board) {
        n = board.length;
        backTrack(board, 0, 0);
    }

    public boolean backTrack(char[][] board, int i, int j) {
        if (i == n) { // 跳出递归
            // 找到一个可行解，触发 base case
            return true;
        }
        if (j == n) {
            // 穷举到最后一列的话就换到下一行重新开始
            return backTrack(board, i + 1, 0);
        }
        // 如果该位置是预设的数字，已经填好了，填写下一个
        if (board[i][j] != '.') {
            return backTrack(board, i, j + 1);
        }
        // 回溯
        // 1-9 数字 填入 i，j位置
        for (char c = '1'; c <= '9'; c++) {
            // 不合法，跳过这个数字
            if (!check(board, i, j, c)) {
                continue;
            }
            // 做选择
            board[i][j] = c;
            // 如果找到一个可行解，立即结束
            boolean flag = backTrack(board, i, j + 1);
            if (flag) {
                return true;
            }
            // 撤销选择
            board[i][j] = '.';
        }
        return false;
    }

    // c数字能否填入位置 i，j
    public boolean check(char[][] board, int row, int column, char c) {
        for (int i = 0; i < n; i++) {
            // 判断行
            if (board[row][i] == c) {
                return false;
            }
            // 判断列
            if (board[i][column] == c) {
                return false;
            }
            // 判断 3x3
            int x = (row / 3) * 3 + i / 3;
            int y = (column / 3) * 3 + i % 3;
            if (board[x][y] == c) {
                return false;
            }
        }
        return true;
    }
}
