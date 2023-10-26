package org.algorithm.graph;

import java.util.Arrays;

/**
 * @Auther: Ban
 * @Date: 2023/4/7 19:07
 * @Description:
 */
public class Dijkstra {
    public static int[] dist;
    public static int[] path;
    public static boolean[] st;
    public static int[][] g;

    public static int[] solution(int start) {
        int length = g.length;
        for (int i = 0; i < length; i++) {
            dist[i] = -1;
        }
        dist[0] = 0;
        // 初始化 未求出最短路径的点 notFound[]
        int[] notFound = new int[length];
        for (int i = 0; i < length; i++) {
            notFound[i] = g[start][i];
        }
        notFound[start] = -1;
        for (int i = 1; i < length; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int j = 0; j < length; j++) {
                if (notFound[j] > 0 && notFound[j] < min) {
                    min = notFound[j];
                    minIndex = j;
                }
            }
            dist[minIndex] = min;
            notFound[minIndex] = -1;
            for (int j = 0; j < length; j++) {
                if (g[minIndex][j] > 0 && dist[j] == -1) {
                    int newDistance = dist[minIndex] + g[minIndex][j];
                    if (newDistance < notFound[j] || notFound[j] == -1) {
                        notFound[j] = newDistance;
                    }
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        g = new int[][]{
                {0, 2, -1, 6},
                {2, 0, 3, 2},
                {-1, 3, 0, 2},
                {6, 2, 2, 0}
        };
        int n = 4;
        dist = new int[n];
        path = new int[n];
        st = new boolean[n];
        solution(0);
        System.out.println(Arrays.toString(dist));
    }
}
