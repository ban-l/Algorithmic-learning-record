package org.algorithm.str;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: Ban
 * @Date: 2023/8/11 09:11
 * @Description: <p>
 * 重复的DNA序列
 */
public class FindRepeatedDnaSequences {


    /**
     * 1.暴力解法(穷举)
     *
     * @param s
     * @return
     */
    public static List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set = new HashSet<>();
        HashSet<String> res = new HashSet<>();
        for (int i = 0; 10 + i <= s.length(); i++) {
            // 穷举所有长度为10的字符串
            String temp = s.substring(i, 10 + i);
            if (set.contains(temp)) {
                res.add(temp);
            } else {
                set.add(temp);
            }
        }
        return new ArrayList<>(res);
    }


    /**
     * 2.滑动窗口
     *
     * @param s
     * @return
     */
    public static List<String> findRepeatedDnaSequences2(String s) {
        HashSet<String> set = new HashSet<>();
        HashSet<String> res = new HashSet<>();
        LinkedList<Character> list = new LinkedList<>();
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            list.add(s.charAt(right));
            right++;
            if (right - left == 10) { //固定窗口为10， 举所有长度为10的字符串
                String temp = list.toString().replaceAll("\\W*", "");
                if (set.contains(temp)) {
                    res.add(temp);
                } else {
                    set.add(temp);
                }
                list.removeFirst();
                left++;
            }
        }
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        String s = "AAAAAAAAAAAAA";
        List<String> res = findRepeatedDnaSequences2(s);
        System.out.println(res.toString());
    }
}
