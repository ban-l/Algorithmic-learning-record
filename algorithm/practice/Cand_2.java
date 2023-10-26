package org.algorithm.practice;

import java.util.Scanner;

/**
 * @Auther: Ban
 * @Date: 2023/9/4 09:12
 * @Description: <p>
 * 题目描述:
 * 糖果工厂可以生产 n 种不同的糖果，假设这些糖果的编号分别为 1 到 n，每一天工厂可以生产 ci 个编号为 i 的糖果。
 * 今天工厂接到了一个订单，需求是 a 包糖果，且每包糖果必须是同一种类的，每包数量不能少于 b 个。
 * 假设糖果工厂在无存货的情况下，至少需要多少天才能完成这个订单？
 * <p>
 * 输入描述
 * 第一行是三个正整数n、a、b
 * 分别表示糖果工厂可以生成的糖果种类数、订单的需求是a包糖果、每包不少于b个。
 * 第二行是n个正整数c1,c2..,cn,其中 第 i 个数 ci 表示工厂每天能生产的编号为 i 的糖果的数量。
 * 对所有的数据保证：1<=n<=100000,1<=a,b<=10^7,1<=ci<=10000
 * 输出描述
 * 一行一个正整数，表示完成订单所需的最少天数。
 */
public class Cand_2 {

    /***
     */
    private static int solution(int a, int b, int[] nums) {
        int left = 0;
        int right = Integer.MAX_VALUE;
        while (left <= right) {
            // 天数为mid
            int mid = left + (right - left) / 2;
            // mid天，能生产 temp包 糖果
            int temp = find(nums, mid, b);
            if (temp < a) {
                left = mid + 1;
            } else if (temp > a) {
                right = mid - 1;
            } else if (temp == a) {
                right = mid - 1; // 最少天数，取左边界
            }
        }
        return left;
    }

    /**
     * 函数定义：天数为 day，能生产出多少 包 糖果（每包糖果同一种类），单调递增
     * <p>
     * 每天，每种糖果，产生数量为：c1、c2、...、cn,
     * 一共day天，每种糖果，共产生数量为，day*nums[i]
     * 要求每包糖果同一种类，所以，分别计算 每类糖果 能装多少包，然后加在一起，即共产生多少包糖果
     */
    public static int find(int[] nums, int day, int b) {
        // 记录总包数
        int count = 0;
        for (int i : nums) {
            // mod天，每类糖果的产量
            int temp = i * day;
            // 产量，能装多少包
            int iCount = temp / b;
            count += iCount;
        }
        return count;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = in.nextInt();
        }
        in.close();
        int res = solution(a, b, c);
        System.out.println(res);
    }
}
