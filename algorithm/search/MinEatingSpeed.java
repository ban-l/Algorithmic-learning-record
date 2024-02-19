package org.algorithm.search;

/**
 * @Auther: Ban
 * @Date: 2023/8/12 09:50
 * @Description: <p>
 * 爱吃香蕉的珂珂
 */
public class MinEatingSpeed {
    /**
     * 速度为k，吃完香蕉需要多久
     * 自变量x，吃香蕉速度 x 根/小时；
     * 因变量f(x)，若吃香蕉的速度为 x 根/小时，则需要 f(x) 小时吃完所有香蕉。
     * f(x) 随着 x 的增加单调递减
     */
    public static long find(int[] piles, int k) {
        long sum = 0;
        for (int i = 0; i < piles.length; i++) {
            // 每一堆几次吃完
            sum += piles[i] / k;
            if (piles[i] % k != 0) {
                sum++;
            }
        }
        return sum;
    }

    /**
     * 找最小值
     * 左边界的二分搜索
     */
    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1000000000;
        // f(x)单调递减
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (find(piles, mid) > h) {
                left = mid + 1;
            } else if (find(piles, mid) < h) {
                right = mid - 1;
            } else if (find(piles, mid) == h) {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] piles = {30, 11, 23, 4, 20};
        int res = minEatingSpeed(piles, 6);
        System.out.println(res);
    }
}