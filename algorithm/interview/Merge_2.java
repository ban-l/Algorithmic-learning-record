package org.algorithm.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: Ban
 * @Date: 2023/12/14 11:00
 * @Description: <p>
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
            // 相交区间
            if (t0 <= right && right <= t1) {
                right = t1;
            }
            // 完全不相交
            if (right < t0) {
                list.add(new int[]{left, right});
                left = t0;
                right = t1;
            }
        }
        list.add(new int[]{left, right});
        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

}
