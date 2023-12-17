package org.algorithm.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: Ban
 * @Date: 2023/12/14 11:00
 * @Description: <p>
 * 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 */
public class Merge_2 {
    public int[][] merge(int[][] intervals) {
        // 排序
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - b[1]; // 终点降序
            }
            return a[0] - b[0]; // 起点升序
        });
        // 三种情况
        List<int[]> list = new ArrayList<>();
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int t0 = intervals[i][0];
            int t1 = intervals[i][1];
            // 覆盖区间
            if (left <= t0 && t1 <= right) {
                continue;
            }
            // 相交区间,合并为大区间
            if (t0 <= right && right <= t1) {
                // 更新大区间
                right = t1;
            }
            // 相邻区间，完全不相交
            if (right < t0) {
                // 添加上一个区间
                list.add(new int[]{left, right});
                left = t0;
                right = t1;
            }
        }
        // 添加最后一个区间
        list.add(new int[]{left, right});

        return list.toArray(new int[list.size()][]);
    }

    public int[][] merge2(int[][] intervals) {
        // 排序
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - b[1]; // 终点降序
            }
            return a[0] - b[0]; // 起点升序
        });
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            // 相邻区间进行判断
            // 当前区间
            int[] cur = intervals[i];
            // 前一个区间，res 中最后一个元素的引用
            int[] last = res.get(res.size() - 1);

            // 区间 相交 或者 覆盖，合并为大区间
            if (cur[0] <= last[1]) {
                // 合并，更新 last，去最大值
                last[1] = Math.max(cur[1], last[1]);
            }
            // 区间完全不相交，加入res
            else {
                res.add(cur);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

}
