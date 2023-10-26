package org.algorithm.arr;

/**
 * @Auther: Ban
 * @Date: 2023/5/14 14:43
 * @Description: 回文串
 * 1.暴力法
 * 2.动态规划
 * 3.中心扩展算法
 */
public class LongestPalindrome {
    // 判断是否是回文串
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 回文串为奇数，有一个中心字符
     * 回文串为偶数，有两个中心字符
     * <p>
     * 寻找以s[l]和s[r]为中心的最长回文串
     * 一个中心字符：l == r
     * 两个中心字符：l+1 = r
     *
     * @param s
     * @param l
     * @param r
     * @return
     */
    public static String palindrome(String s, int l, int r) {
        // 防止越界
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) == s.charAt(r)) {
                // 双指针，向两边展开
                l--;
                r++;
            } else {
                break;
            }
        }
        // 返回以 s[l] 和 s[r] 为中心的最长回文串
        return s.substring(l + 1, r);
    }


    /**
     * 中心扩展算法
     * 从中心向两端扩散的双指针技巧
     * <p>
     * for 0 <= i < len(s):
     * 找到以 s[i] 为中心的回文串
     * 找到以 s[i] 和 s[i+1] 为中心的回文串
     * 更新答案
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // 以 s[i] 为中心的最长回文串
            String s1 = palindrome(s, i, i);
            // 以 s[i] 和 s[i+1] 为中心的最长回文串
            String s2 = palindrome(s, i, i + 1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }
}
