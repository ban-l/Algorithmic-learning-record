package org.algorithm.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Ban
 * @Date: 2023/12/14 11:48
 * @Description: <p>
 * 区间列表的交集
 * <p>
 * 给定两个由一些 闭区间 组成的列表，firstList 和 secondList ，其中 firstList[i] = [starti, endi] 而 secondList[j] = [startj, endj] 。
 * 每个区间列表都是成对 不相交 的，并且 已经排序 。
 * 返回这 两个区间列表的交集 。
 * 形式上，闭区间 [a, b]（其中 a <= b）表示实数 x 的集合，而 a <= x <= b 。
 * 两个闭区间的 交集 是一组实数，要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3] 。
 */
public class IntervalIntersection_2 {

    /**
     * 两个区间无交集 b2 < a1 or a2 < b1
     * 两个区间存在交集 b2 >= a1 and a2 >= b1
     */
    public int[][] intervalIntersection(int[][] f, int[][] s) {
        List<int[]> res = new ArrayList<>();
        // 双指针
        int i = 0, j = 0;
        while (i < f.length && j < s.length) {
            // 两个区间[a1,a2],[b1][b2]
            int a1 = f[i][0];
            int a2 = f[i][1];
            int b1 = s[j][0];
            int b2 = s[j][1];
            // 两个区间存在交集 b2 >= a1 and a2 >= b1
            if (b2 >= a1 && a2 >= b1) {
                // 交集区间是 [c1, c2], c1 = max(a1, b1)，c2 = min(a2 ,b2)
                int c1 = Math.max(a1, b1);
                int c2 = Math.min(a2, b2);
                res.add(new int[]{c1, c2});
            }
            //指针移动
            if (a2 > b2) {
                j++;
            } else {
                i++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
