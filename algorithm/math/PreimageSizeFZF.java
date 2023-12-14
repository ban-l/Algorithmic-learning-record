package org.algorithm.math;

/**
 * @Auther: Ban
 * @Date: 2023/11/30 10:40
 * @Description: <p>
 * <p>
 * f(x) 是 x! 末尾是 0 的数量。回想一下 x! = 1 * 2 * 3 * ... * x，且 0! = 1 。
 * • 例如， f(3) = 0 ，因为 3! = 6 的末尾没有 0 ；而 f(11) = 2 ，因为 11!= 39916800 末端有 2 个 0 。
 * 给定 k，找出返回能满足 f(x) = k 的非负整数 x 的数量。
 * 即：现在是给你一个非负整数 K，问你有多少个 n，使得 n! 结果末尾有 K 个 0。
 */
public class PreimageSizeFZF {
    // 1.穷举法（暴力）
    public int exhaustion(int k) {
        int res = 0;
        for (int n = 0; n < Integer.MAX_VALUE; n++) {
            // n!末尾 0 大于 k，跳出循环，trailingZeroes是递增的，后面也都大于k
            if (trailingZeroes(n) > k) break;
            // n!末尾 0 小于 k，继续
            if (trailingZeroes(n) < k) continue;
            if (trailingZeroes(n) == k) { // n!末尾 0 等于 k，累加
                res++;
            }
        }
        return res;
    }


    /**
     * 2.左、右边界的二分查找
     * 搜索有多少个 n 满足 trailingZeroes(n) == K
     * 其实就是在问：满足条件的 n 最小是多少，最大是多少，最大值和最小值一减，就可以算出来有多少个 n 满足条件了
     * 即 二分查找 中「搜索左侧边界」和「搜索右侧边界」
     * 结果为： 左边界和右边界之差 + 1
     */
    public int preimageSizeFZF(int k) {
        // 左边界和右边界之差 + 1
        int res = (int) (right_bound(k) - left_bound(k) + 1);
        return res;
    }

    /* 二分查找，搜索 trailingZeroes(n) == K 的左侧边界 */
    public long left_bound(int k) {
        long lo = 0;
        long hi = Long.MAX_VALUE;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            if (trailingZeroes(mid) > k) {
                hi = mid - 1;
            } else if (trailingZeroes(mid) < k) {
                lo = mid + 1;
            } else if (trailingZeroes(mid) == k) {
                hi = mid - 1;
            }
        }
        return lo;
    }

    /* 二分查找，搜索 trailingZeroes(n) == K 的右侧边界 */
    public long right_bound(int k) {
        long lo = 0;
        long hi = Long.MAX_VALUE;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            if (trailingZeroes(mid) > k) {
                hi = mid - 1;
            } else if (trailingZeroes(mid) < k) {
                lo = mid + 1;
            } else if (trailingZeroes(mid) == k) {
                lo = mid + 1;
            }
        }
        return hi;
    }

    /**
     * 递增函数：阶乘 n! 的结果末尾有几个 0
     * <p>
     * 随着n的增大，n!是递增的，trailingZeroes(n!) 也是递增的
     */
    public long trailingZeroes(long n) {
        long res = 0;
        long divisor = 5;
        while (divisor <= n) { // 跳出循环
            res += n / divisor; // 5、25、125....提供的5 累加计数
            divisor *= 5; // 更新 divisor：5、25、125....
        }
        return res;
    }
}
