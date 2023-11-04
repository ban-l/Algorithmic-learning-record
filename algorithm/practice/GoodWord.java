package org.algorithm.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Ban
 * @Date: 2023/11/1 18:56
 * @Description: <p>
 * <p>
 * 写一个函数判断输入字符串是不是Good Word,具体方法：
 * 1.假设字符串中出现最多的字母出现次数是 maxn,最少的字母出现次数是 minn。
 * 2.若maxn除以minn的结果是一个大于1的整数，则是Good Word。
 * 3.若是Good Word返回True,否则返回False。
 * 4.字符串中只包含英文字母。
 */
public class GoodWord {
    public static void main(String[] args) {
        String word = "AaAaBbBb";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int maxn = 0;
        int minn = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> t : map.entrySet()) {
            if (t.getValue() > maxn) {
                maxn = t.getValue();
            }
            if (t.getValue() < minn) {
                minn = t.getValue();
            }
        }
        boolean res = false;
        if ((maxn % minn) == 0 && (maxn / minn) > 1) {
            res = true;
        }
        System.out.println(res);
    }
}
