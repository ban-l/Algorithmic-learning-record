package org.algorithm.str;

/**
 * @Auther: Ban
 * @Date: 2023/11/4 14:49
 * @Description: <p>
 */
public class FindTheLongestBalancedSubstring {
    public static int findTheLongestBalancedSubstring(String s) {
        char[] c = s.toCharArray();
        int ans = 0; // 答案
        int cur = 0; // 记录上一段连续字符个数
        int pre = 0; // 记录当前连续字符个数
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            cur++;
            // "01" 、"10" 才会进入判断
            // "10" 或者 '1' 在最末尾时，更新答案
            if (i == n - 1 || c[i] != c[i + 1]) {
                // 更新答案
                if (c[i] == '1') {
                    // 平衡子字符串的长度，取较小者*2
                    int temp = Math.min(pre, cur) * 2;
                    ans = Math.max(ans, temp);
                }
                // 更新字符个数
                pre = cur;
                cur = 0;
            }
        }
        return ans;
    }
}
