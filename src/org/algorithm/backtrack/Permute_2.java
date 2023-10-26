package org.algorithm.backtrack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: Ban
 * @Date: 2023/7/15 11:10
 * @Description: 排列问题
 * 排列（元素可重不可复选）
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 */
public class Permute_2 {

    public static List<List<Integer>> res = new LinkedList<>();
    public static LinkedList<Integer> track = new LinkedList<>();
    public static boolean[] used;

    public static List<List<Integer>> permuteUnique(int[] nums) {
        // 先排序，让相同元素靠在一起
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backtrack(nums);
        return res;
    }

    // 剪枝，相同元素在排列中的相对位置保持不变
    private static void backtrack(int[] nums) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue; // 剪枝，已访问过，跳出
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue; // 剪枝，没有访问过的树枝，若值相同，跳过（相对位置改变导致重复啦,要跳过）
            track.add(nums[i]);
            used[i] = true;
            backtrack(nums);
            track.removeLast();
            used[i] = false;
        }
    }


    // 方法二 ，用 prevNum 记录前一条树枝的值，只遍历第一个树枝，后面相同的跳过
    private static void backtrack2(int[] nums) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        // 记录前一条树枝的值,初始化为特殊值
        int prevNum = -666;
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue; // 剪枝，已访问过，跳出
            if (prevNum == nums[i]) continue; // 剪枝,相同则跳过,去重复
            track.add(nums[i]);
            used[i] = true;
            prevNum = nums[i]; // 记录这条树枝上的值
            backtrack2(nums);
            track.removeLast();
            used[i] = false;
        }
    }

    // 方法三 ，找出全排列， 然后通过set去重，效率低
    // public static Set<List<Integer>> set = new HashSet<>();


    public static void main(String[] args) {
        int[] nums = {2, 1, 2};
        permuteUnique(nums);
        System.out.println(res.toString());
    }
}
