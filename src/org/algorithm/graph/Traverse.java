package org.algorithm.graph;


import sun.misc.Queue;

/**
 * @Auther: Ban
 * @Date: 2023/4/7 17:40
 * @Description: 深度优先搜索
 */
public class Traverse {

    public static int[][] g;
    public static boolean[] visited;
    public static Queue<Integer> queue;

    public static void dfs(int v, int n) {
        visited[v] = true;
        System.out.println(v);
        for (int i = 0; i < n; i++) {
            if (g[v][i] == 1 && !visited[i]) {
                dfs(i, n);
            }
        }
    }


    public static void bfs(int v, int n) throws InterruptedException {
        visited[v] = true;
        System.out.println(v);
        queue.enqueue(v);
        while (!queue.isEmpty()) {
            int temp = queue.dequeue();
            for (int i = 0; i < n; i++) {
                if (g[temp][i] == 1 && !visited[i]) {
                    System.out.println(i);
                    visited[i] = true;
                    queue.enqueue(i);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int n = 4;
        g = new int[][]{
                {0, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 0, 0},
                {1, 0, 0, 0}
        };
        queue = new Queue<>();
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, n);
            }
        }
    }
}
