package org.algorithm.common;

/**
 * @Auther: Ban
 * @Date: 2023/4/5 14:33
 * @Description: 七段码
 */
public class SevenSegmentCode {
    public static int ans = 0; // 记录次数
    public static int n = 8; //邻接矩阵大小
    public static int[] fa = new int[n];
    public static int[] rank = new int[n];
    public static boolean[] st = new boolean[n]; //记录各种情况，点亮与否
    public static int[][] e = new int[n][n]; // 邻接矩阵

    // 初始化
    public static void init(int n) {
        for (int i = 1; i < n; i++) {
            fa[i] = i;
            rank[i] = 1;
        }
    }

    // 查询
    public static int find(int x) {
        if (x == fa[x]) {
            return x;
        } else {
            fa[x] = find(fa[x]);
            return fa[x];
        }
    }

    // 合并
    public static void union(int x, int y) {
        // 找到代表元
        x = find(x);
        y = find(y);
        if (x == y) { // 找到代表元相等，在一个集合内
            return;
        }
        if (rank[x] > rank[y]) {
            fa[y] = x;
        } else {
            if (rank[x] == rank[y]) {
                rank[y]++;
            }
            fa[x] = y;
        }
    }

    /**
     * 类似二叉树的先序遍历
     * dfs遍历出所有结果
     * 每个结点有0、1两种可能（关闭、打开），共2^种结果，0000000-1111111
     *
     * @param row
     */
    public static void dfs(int row) {
        if (row >= n) { // 递归终止，代表着一种结果
            // 每次都要 初始化并查集
            init(n);
            // st存储已经点亮情况(几个1)
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < n; j++) {
                    // i、j都点亮并且相连
                    if (st[i] && st[j] && e[i][j] == 1) {
                        // 合并
                        union(i, j);
                    }
                }
            }
            int count = 0;
            // 查询有几个代表元，一个表示只有一个集合(一个连通分量)，全相连
            for (int i = 1; i < n; i++) {
                // 找代表元,存在+1
                if (st[i] && find(i) == i) {
                    count++;
                }
            }
            // 只有一个，连通
            if (count == 1) {
                ans++;
            }
            return;
        }
        // 只有0、1两种可能，同阶层dfs两次
        st[row] = true; // 打开，对应 1 这种可能
        dfs(row + 1);
        st[row] = false; // 关闭，对应 0 这种可能
        dfs(row + 1);
    }

    // 非递归写法
    public static void solution() {
        // 所有结果,全0不算，共2^n-1种结果
        for (int i = 1; i <= 127; i++) {
            // 转为2进制，掩码得到二进制各个位
            int[] map = new int[n];
            for (int j = 0; j < 7; j++) {
                map[j + 1] = (i & 1 << j) >> j;
            }
            // 初始化并查集
            init(n);
            for (int j = 1; j < n; j++) {
                for (int k = 1; k < n; k++) {
                    if (map[j] == 1 && map[k] == 1 && e[j][k] == 1) {
                        // 合并
                        union(j, k);
                    }
                }
            }
            // 记录代表元个数
            int count = 0;
            for (int j = 1; j < n; j++) {
                if (map[j] == 1 && find(j) == j) {
                    count++;
                }
            }
            if (count == 1) {
                ans++;
            }
        }
    }

    public static void main(String[] args) {
        // 邻接矩阵存储图的关系
        e[1][2] = e[1][6] = 1; //表示相邻
        e[2][1] = e[2][7] = e[2][3] = 1;
        e[3][2] = e[3][7] = e[3][4] = 1;
        e[4][3] = e[4][5] = 1;
        e[5][7] = e[5][6] = e[5][4] = 1;
        e[6][5] = e[6][7] = e[6][1] = 1;
        e[7][2] = e[7][3] = e[7][5] = e[7][6] = 1;
        dfs(1); // 递归写法
        System.out.println(ans);
        ans = 0;
        solution(); // 非递归写法
        System.out.println(ans);
    }
}
