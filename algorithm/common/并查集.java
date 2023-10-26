package org.algorithm.common;

/**
 * @Auther: Ban
 * @Date: 2023/4/5 20:11
 * @Description: 并查集
 * 用于处理一些不交集（Disjoint sets，一系列没有重复元素的集合）的合并及查询问题
 * 并查集操作：
 * 查询：对于某个点x，查询属于哪个集合，返回其代表元，用于判断两个元素是否在一个集合内
 * 合并：合并两个不相交的集合
 */
public class 并查集 {

    public static int[] fa; // 存储每个结点的父结点
    public static int[] rank; // 树的秩


    /**
     * 初始化
     * fa[]
     * rank[]
     *
     * @param n
     */
    public static void init(int n) {
        for (int i = 0; i < n; i++) {
            fa[i] = i; // 初始化，每个结点的父节点设为自己
            rank[i] = 1; // 初始化，每个结点构成树，秩为1
        }
    }


    /**
     * find()函数，查询x的根节点
     *
     * @param x
     * @return
     */
    public static int find(int x) {
        /*
        // 递归写法
        if (x == pre[x]) { // 自己就是代表元,父节点是本身
            return x;
        } else { // 否则一直找
            return find(pre[x]);
        }
         */
        while (x != fa[x]) { //一层一层访问父节点，直到根节点（代表元）
            x = fa[x];
        }
        return x;
    }

    /**
     * 路径压缩算法一
     * 优化find()函数
     * 把沿途的每个节点的父节点都设为根节点
     *
     * @param x
     * @return
     */
    public static int optimizeFind(int x) {
        if (x == fa[x]) {
            return x;
        } else {
            fa[x] = optimizeFind(fa[x]);
            return fa[x];
        }
    }

    /**
     * join()函数，合并
     *
     * @param x
     * @param y
     */
    public static void join(int x, int y) {
        // 找到代表元
        x = find(x);
        y = find(y);
        if (x != y) { // 不相等，随便找一个结点当作代表元
            fa[x] = y;
        }
    }

    /**
     * 路径压缩算法二
     * 按秩合并
     *
     * @param x
     * @param y
     */
    public static boolean union(int x, int y) {
        // 找到代表元
        x = find(x);
        y = find(y);
        if (x == y) { // 在同一个集合内
            return false;
        }
        if (rank[x] > rank[y]) {
            fa[y] = x; // x为y的父节点
        } else {
            if (rank[x] == rank[y]) { // 如果高度相等，y的高度+1
                rank[y]++;
            }
            fa[x] = y; // y为x的父节点
        }
        return true;
    }

    // 判断两个结点是否连通
    public static boolean isSame(int x, int y) {
        return find(x) == find(y);
    }


    public static void main(String[] args) {
        int n = 0;
        fa = new int[n];
        rank = new int[n];
        init(n);

    }
}
