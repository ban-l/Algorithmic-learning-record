package org.algorithm.math;

import java.util.Arrays;

/**
 * @Auther: Ban
 * @Date: 2023/12/1 09:17
 * @Description: <p>
 * 计数质数
 * 给定整数 n ，返回 所有小于非负整数 n 的质数的数量。
 * <p>
 * 示例 1：
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * <p>
 * 示例 2：
 * 输入：n = 0
 * 输出：0
 * <p>
 * 示例 3：
 * 输入：n = 1
 * 输出：0
 */
public class CountPrimes {

    /* 素数筛选法 */
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        // 将数组都初始化为 true
        Arrays.fill(isPrime, true);

        for (int i = 2; i * i < n; i++)
            if (isPrime[i])
                // i 的倍数不可能是素数了
                for (int j = i * i; j < n; j += i)
                    isPrime[j] = false;

        int count = 0;
        for (int i = 2; i < n; i++)
            if (isPrime[i]) count++;

        return count;
    }

    /* 判断n是否为质数 */
    public boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CountPrimes c = new CountPrimes();
        System.out.println(c.countPrimes(499979));
    }
}
