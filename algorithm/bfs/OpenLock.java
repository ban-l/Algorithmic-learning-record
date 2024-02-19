package org.algorithm.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Auther: Ban
 * @Date: 2023/7/20 09:35
 * @Description: 打开转盘锁
 * https://leetcode.cn/problems/open-the-lock/
 */
public class OpenLock {


    /**
     * 1.穷举出所有可能
     * 比如说从 "0000" 开始，转一次，可以穷举出 "1000", "9000", "0100", "0900", "0010", "0090", "0001", "0009"共 8 种密码。
     * 然后，再以这 8 种密码作为基础，对每个密码再转一下，穷举出所有可能...
     * 抽象为找最短路径（最少次数）：抽象成一幅图，每个节点有 8 个相邻的节点，求最短距离.
     * 典型的 BFS
     * <p>
     * 2.剪枝
     * -1）比如说从 "0000" 拨到 "1000"，但是等从队列拿出 "1000" 时，还会拨出一个 "0000"，这样的话会产生死循环，需要记录已经穷举过的密码，防止走回头路
     * -2）跳过 deadends
     * -3）终止条件：找到 target，返回拨动的次数
     * <p>
     * 3.到达终点
     *
     * @param deadends
     * @param target
     * @return
     */
    public int openLock(String[] deadends, String target) {
        // 记录需要跳过的死亡密码
        Set<String> deadList = new HashSet<>();
        for (int i = 0; i < deadends.length; i++) {
            deadList.add(deadends[i]);
        }

        // 记录已经穷举过的密码，防止走回头路
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        // 从起点开始启动广度优先搜索
        queue.offer("0000");
        visited.add("0000");
        int minimum = 0;

        // 从上到下遍历每一层(第i层 代表 转动i次 的结果)
        while (!queue.isEmpty()) {
            int sz = queue.size();
            // 从左到右遍历每一层的每个节点
            for (int i = 0; i < sz; i++) {
                String cur = queue.poll(); // 出队
                if (deadList.contains(cur)) { // 剪枝，跳过死亡密码
                    continue;
                }
                // 判断是否到达终点
                if (cur.equals(target)) {
                    return minimum;
                }
                // 将下一层节点放入队列
                // 共4个位置，拨动 s 一次，每个位置 可以向上、向下拨动，有 8 种可能
                for (int j = 0; j < cur.length(); j++) {
                    String up = plusOne(cur, j); // cur[j]向上转动一次结果
                    if (!visited.contains(up)) {
                        queue.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(cur, j); // cur[j]向下转动一次结果
                    if (!visited.contains(down)) {
                        queue.offer(down);
                        visited.add(down);
                    }
                }
            }
            // 增加步数
            minimum++;
        }
        // 如果穷举完都没找到目标密码，那就是找不到了
        return -1;
    }


    // 将 s 向 上 拨动一次
    public String plusOne(String s, int index) {
        char[] c = s.toCharArray();
        if (c[index] == '9') {
            c[index] = '0';
        } else {
            c[index] += 1;
        }
        return String.valueOf(c);
    }

    // 将 s 向 下 拨动一次
    public String minusOne(String s, int index) {
        char[] c = s.toCharArray();
        if (c[index] == '0') {
            c[index] = '9';
        } else {
            c[index] -= 1;
        }
        return String.valueOf(c);
    }

    public static void main(String[] args) {
        String[] deadends = {"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"};
        OpenLock lock = new OpenLock();
        int minimum = lock.openLock(deadends, "8805");
        System.out.println(minimum);
    }
}
