package org.algorithm.common;

import java.util.*;

/**
 * @Auther: Ban
 * @Date: 2023/3/23 10:34
 * @Description: 幂方分解
 * <p>
 * 深度优先遍历
 * 任何⼀个正整数都可以用 2 的幂次方表示
 */
public class NumberResolve {
    /**
     * 短除法
     * 先把10进制转2进制,然后表示为2的幂次方
     *
     * @param n
     */
    public static Set<Integer> resolve(int n) {
        // 10进制转2进制
        List<Integer> list = new ArrayList<>();
        while (n != 0) {
            int temp = n % 2;
            list.add(temp);
            n = n / 2;
        }
        // 2的幂次方表示
        TreeSet<Integer> result = new TreeSet<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 1) {
                result.add(i);
            }
        }
        // 降序排列
        return result.descendingSet();
    }

    /**
     * 2的幂次方表示
     *
     * @param n
     * @return
     */
    public static Set<Integer> resolve2(int n) {
        TreeSet<Integer> result = new TreeSet<>();
        int count = 0;
        while (n != 0) {
            int temp = n % 2;
            if (temp != 0) {
                result.add(count); // 记录2的幂次方表示
            }
            n = n / 2;
            count++;
        }
        return result.descendingSet();
    }

    /**
     * 递归的方式实现深度优先遍历
     *
     * @param n
     */
    public static String recursion(int n) {
        // n=0，1，2时，跳出递归
        if (n == 0 || n == 2) {
            return "" + n;
        }
        if (n == 1) {
            return "";
        }
        StringBuilder s = new StringBuilder();
        // n分解为2的幂次方表示
        Set<Integer> result = resolve2(n);
        for (Integer i : result) {
            if (i != 1) {
                s.append("2(" + recursion(i) + ")+");
            } else {
                // n=1时，表示为2，而不是2（1）
                s.append("2" + recursion(i) + "+");
            }
        }
        s.deleteCharAt(s.length() - 1);
        return s.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();
        System.out.println(recursion(n));
    }
}
