package org.algorithm.arr;

import java.util.Arrays;

/**
 * @Auther: Ban
 * @Date: 2023/4/2 21:26
 * @Description: 差分法
 * 差分可以简单的看成序列中每个元素与其前一个元素的差。
 * 原序列为差分序列的前缀和
 * <p>
 * 输入
 * 6 3
 * 1 2 2 1 2 1
 * 1 3 1
 * 3 5 1
 * 1 6 1
 * <p>
 * 输出
 */
public class Difference {


    /**
     * 1.构造差分数组
     * 2.进行加减操作
     * 3.差分还原(前缀和)
     * <p>
     * 区间[l,r]中的所有值都 加上 常数c
     * b[l] += c;
     * b[r+1] -= c;
     * <p>
     * 区间[l,r]中的所有值都 减去 常数c
     * b[l] -= c;
     * b[r+1] += c;
     */
    private int[] diff; // 差分数组

    /* 1.输入一个初始数组，构造差分数组 */
    public Difference(int[] nums) {
        diff = new int[nums.length];
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }

    /* 2.给闭区间 [i, j] 增加 val（可以是负数）*/
    public void increment(int i, int j, int val) {
        diff[i] += val;
        if (j + 1 < diff.length) {
            diff[j + 1] -= val; // 边界处理
        }
    }

    /* 2.给闭区间 [i, j] 减去 val（可以是负数）*/
    public void decrement(int i, int j, int val) {
        diff[i] -= val;
        if (j + 1 < diff.length) { // 边界处理
            diff[j + 1] += val;
        }
    }

    /* 3.差分还原(前缀和) */
    public int[] result() {
        int[] res = new int[diff.length];
        // 根据 差分数组 还原 结果数组
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }


    /**
     * 区间[l,r]中的所有值都 加上 常数c
     * b[l] += c;
     * b[r+1] -= c;
     * <p>
     * 区间[l,r]中的所有值都 减去 常数c
     * b[l] -= c;
     * b[r+1] += c;
     */


    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 3, 9, 8};
        Difference d = new Difference(nums);
        d.increment(1, 2, 2);
        d.decrement(1, 2, 2);
        int[] res = d.result();
        System.out.println(Arrays.toString(res));


//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int m = in.nextInt();
//        int[] nums = new int[n];
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = in.nextInt();
//        }
//        int[][] lrc = new int[m][3];
//        for (int i = 0; i < lrc.length; i++) {
//            for (int j = 0; j < 3; j++) {
//                lrc[i][j] = in.nextInt();
//            }
//        }
//        in.close();
//        solution(nums, lrc);

    }

    /**
     * 车上最初有 capacity 个空座位。车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向）
     * <p>
     * 给定整数 capacity 和一个数组 trips ,  trip[i] = [numPassengersi, fromi, toi]
     * 表示第 i 次旅行有 numPassengersi 乘客，接他们和放他们的位置分别是 fromi 和 toi 。这些位置是从汽车的初始位置向东的公里数。
     * <p>
     * 当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false。
     *
     * @param trips
     * @param capacity
     * @return
     */
    public boolean carPooling(int[][] trips, int capacity) {
        // 1.差分数组
        int[] diff = new int[1001];
        for (int i = 0; i < trips.length; i++) {
            // 2.区间内加减
            int nums = trips[i][0];
            int f = trips[i][1];
            int t = trips[i][2] - 1;
            diff[f] += nums;
            if (t + 1 < diff.length) {
                diff[t + 1] -= nums;
            }
        }
        // 3.差分还原(前缀和)
        int sum = 0;
        for (int i = 0; i < diff.length; i++) {
            if (sum > capacity) {
                return false;
            }
            sum += diff[i];
        }
        return true;
    }
}
