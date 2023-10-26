package org.algorithm.practice;

import java.util.HashMap;

/**
 * @Auther: Ban
 * @Date: 2023/9/4 09:12
 * @Description: <p>
 * 题目描述:
 * 小美想要买糖果店的一根长长的糖果。糖果店顾客可以从中选取一个位置然后老板会在那切
 * 断，糖果前端到那个切断位置的糖果就会出售给这位顾客。这个糖果其实不同段有着不同的口
 * 味，小美希望她选出来的糖果中各个段有着不同的口味，在这基础上希望能选出尽可能长的糖
 * 果。小美想知道她能买到最长多长的糖果，请你帮帮她。
 * <p>
 * 输入描述:
 * 第一行1个整数n,表示糖果的长度
 * 第二行n个整数a1,a2...an,其中ai表示从糖果前端开始第i段的口味，每段均1为单位长度。
 * 对于100%的数据，1≤n≤50000,1≤ai≤50000
 * 输出描述:
 * 输出一行一个整数表示能买到的糖果的最长长度，且其中不包含相同口味
 * <p>
 * 样例输入：
 * 5
 * 1 2 3 3 4
 * 样例输出：
 * 3
 * <p>
 * 提示：
 * 如果我们买长度为4的糖果，包含的口味为[1,2,3,3]，存在了重复。
 * 而长度为3时，包含的口味为[1,2,3]，不存在重复。因此长度3为最长的不存在重复口味糖果长度。
 * <p>
 */
public class Candy {

    /***
     * 滑动窗口
     * 请你找出其中不含有重复字符的 最长子串 的长度。
     * @param nums
     * @return
     */
    private static int solution(int[] nums) {
        int res = 1;
        HashMap<Integer, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        while (right < nums.length) {
            int c = nums[right];
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            while (window.get(c) > 1) {
                int d = nums[left];
                left++;
                window.put(d, window.get(d) - 1);
            }
            // 窗口每次变化都比较，更新答案
            res = Math.max(res, right - left);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 4};
        int res = solution(nums);
        System.out.println(res);

    }
}
