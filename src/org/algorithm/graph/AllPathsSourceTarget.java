package org.algorithm.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: Ban
 * @Date: 2023/9/2 10:55
 * @Description: <p>
 * 所有可能的路径
 * 给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
 */
public class AllPathsSourceTarget {
    // 记录所有路径
    private List<List<Integer>> res = new LinkedList<>();

    // DFS，以 0 为起点遍历图，同时记录遍历过的路径，当遍历到终点时将路径记录下来即可。
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // 维护递归过程中经过的路径
        LinkedList<Integer> path = new LinkedList<>();
        traverse(graph, 0, path);
        return res;
    }

    /* 图的遍历框架 */
    public void traverse(int[][] graph, int s, LinkedList<Integer> path) {
        // 做选择，添加节点 s 到路径
        path.addLast(s);

        // 到达终点 n-1
        if (s == graph.length - 1) {
            res.add(new LinkedList<>(path));
            // 可以在这直接 return，但要 removeLast 正确维护 path
            // path.removeLast();
            // return;
            // 不 return 也可以，因为图中不包含环，不会出现无限递归
        }
        // s的相邻节点
        int[] nodes = graph[s];
        // 递归每个相邻节点
        for (int i : nodes) {
            traverse(graph, i, path);
        }
        // 撤销选择，从路径移出节点 s
        path.removeLast();
    }
}