package org.algorithm.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: Ban
 * @Date: 2023/7/14 11:14
 * @Description: 组合问题
 * <p>
 * 组合（元素无重不可复选）
 * <p>
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。你可以按 任何顺序 返回答案。
 * <p>
 * 组合和子集是一样的：大小为 k 的组合就是大小为 k 的子集
 */
public class Combine_1 {


    public static List<List<Integer>> res = new LinkedList<>(); // 结果
    public static LinkedList<Integer> track = new LinkedList<>(); // 记录路径

    public static List<List<Integer>> combine(int n, int k) {
        backtrack(n, k, 1);
        return res;
    }

    public static void backtrack(int n, int k, int start) {
        // 大小为 k 的组合就是大小为 k 的子集
        if (track.size() == k) {
            // 取子集中第K层的节点,遍历到了第 k 层，收集当前节点的值
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = start; i <= n; i++) {
            track.add(i);
            backtrack(n, k, i + 1);
            track.removeLast();
        }
    }


    //找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
    // 只使用数字1到9
    // 最多使用一次
    public static int trackSum = 0; // 记录 track路径和

    public static void backtrack2(int n, int k, int start) {
        // 大小为 k 的组合就是大小为 k 的子集
        if (track.size() == k) {
            if (trackSum == n) { // 和为 n
                res.add(new LinkedList<>(track));
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            track.add(i);
            trackSum += i;
            backtrack2(n, k, i + 1);
            track.removeLast();
            trackSum -= i;
        }
    }

    public static void main(String[] args) {
        combine(4, 2);
        System.out.println(res.toString());
    }
}
