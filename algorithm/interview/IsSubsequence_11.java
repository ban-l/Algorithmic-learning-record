package org.algorithm.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Ban
 * @Date: 2024/1/9 21:27
 * @Description: <p>
 */
public class IsSubsequence_11 {


    /**
     * 判断子序列
     * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
     * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
     */

    /**
     * 1.双指针
     * 利用双指针 i, j 分别指向 s, t，一边前进一边匹配子序列
     * 相等都移动，不相等j移动
     */
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i == s.length();
    }


    /**
     * 2.二分思路
     */
    public boolean isSubsequence2(String s, String t) {
        ArrayList<Integer>[] index = new ArrayList[256];
        // 先记下 t 中每个字符出现的位置
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (index[c] == null) {
                index[c] = new ArrayList<>();
            }
            index[c].add(i);
        }
        // 串 t 上的指针
        int j = 0;
        // 借助 index 查找 s[i]
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // // 整个 t 压根儿没有字符 c，直接返回false
            if (index[c] == null) return false;
            int pos = left_bound(index[c], j);
            // 二分搜索区间中没有找到字符 c
            if (pos == -1) return false;
            // 向前移动指针 j
            j = index[c].get(pos) + 1;
        }
        return true;
    }


    /**
     * 匹配子序列的单词数
     * 给定字符串 s 和字符串数组 words, 返回  words[i] 中是s的子序列的单词个数 。
     * <p>
     * 字符串的 子序列 是从原始字符串中生成的新字符串，可以从中删去一些字符(可以是none)，而不改变其余字符的相对顺序。
     * <p>
     * 例如， “ace” 是 “abcde” 的子序列。
     */

    public int numMatchingSubseq(String s, String[] words) {
        // 对 s 进行预处理
        // char -> 该 char 的索引列表
        ArrayList<Integer>[] index = new ArrayList[256];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (index[c] == null) {
                index[c] = new ArrayList<>();
            }
            index[c].add(i);
        }

        int res = 0;
        for (String word : words) {
            // 字符串 word 上的指针
            int i = 0;
            // 串 s 上的指针
            int j = 0;
            // 借助 index 查找 word 中每个字符的索引
            for (; i < word.length(); i++) {
                char c = word.charAt(i);
                // 整个 s 压根儿没有字符 c
                if (index[c] == null) {
                    break;
                }
                int pos = left_bound(index[c], j);
                // 二分搜索区间中没有找到字符 c
                if (pos == -1) {
                    break;
                }
                // 向前移动指针 j
                j = index[c].get(pos) + 1;
            }
            // 如果 word 完成匹配，则是子序列
            if (i == word.length()) {
                res++;
            }
        }

        return res;
    }


    /**
     * 左边界的二分查找
     * 若不存在，返回大于target的第一个值的索引
     */
    public int left_bound(List<Integer> nums, int target) {
        int left = 0;
        int right = nums.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (left < 0 || left >= nums.size()) {
            return -1;
        }
        return left;
    }
}
