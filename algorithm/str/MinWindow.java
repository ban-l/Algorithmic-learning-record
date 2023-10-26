package org.algorithm.str;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Ban
 * @Date: 2023/7/23 09:37
 * @Description: <p>
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
 * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 * <p>
 */
public class MinWindow {
    public static String minWindow(String s, String t) {
        // 记录需要的字符及其 出现的次数
        Map<Character, Integer> need = new HashMap<>();
        // 记录窗口中的字符及其 出现的次数
        Map<Character, Integer> window = new HashMap<>();
        // 统计 t 中各字符出现次数
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        // 窗口中满足需要的字符个数
        int valid = 0;
        // 记录最小覆盖子串的起始索引及长度
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            // c 是将移入窗口的字符
            char c = s.charAt(right);
            // 扩大窗口
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                // window 和 need 比较 某一个字符的需求数量，满足+1
                if (window.get(c).equals(need.get(c))) {
                    // 只有当 window[c] 和 need[c] 对应的出现次数一致时，才能满足条件，valid 才能 +1
                    valid++;
                }
            }
            // 当 window 包含 need 的全部字符，开始减少窗口
            // 判断左侧窗口是否要收缩
            while (valid == need.size()) {
                // 更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 缩小窗口
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        // 只有当 window[d] 内的出现次数和 need[d] 相等时，才能 -1
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        // 返回最小覆盖子串
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String res = minWindow(s, t);
        System.out.println(res);
    }
}
