package org.algorithm.interview;

import java.util.Arrays;

/**
 * @Auther: Ban
 * @Date: 2023/12/13 10:17
 * @Description: <p>
 * 删除被覆盖区间
 * <p>
 * 给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。
 * 只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。
 * 在完成所有删除操作后，请你返回列表中剩余区间的数目。
 */
public class RemoveCoveredIntervals_2 {
    /**
     * 按照起点排序
     * 若起点相同，降序排序
     */
    public int removeCoveredIntervals(int[][] nums) {
        // 按照起点升序排列，起点相同时降序排列
        Arrays.sort(nums, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        // 记录合并区间的起点和终点
        int left = nums[0][0];
        int right = nums[0][1];
        int res = 0;

        for (int i = 1; i < nums.length; i++) {
            int t0 = nums[i][0];
            int t1 = nums[i][1];
            // 情况一，找到覆盖区间
            if (left <= t0 && t1 <= right) {
                res++;
            }
            // 情况二，找到相交区间，合并
            if (t0 <= right && right <= t1) {
                right = t1;
            }
            // 情况三，两个区间完全不相交，更新起点和终点
            if (right < t0) {
                left = t0;
                right = t1;
            }
        }
        // 总数减去覆盖区间
        return nums.length - res;
    }
}
