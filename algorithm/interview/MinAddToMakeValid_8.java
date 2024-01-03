package org.algorithm.interview;

import java.util.LinkedList;

/**
 * @Auther: Ban
 * @Date: 2023/12/25 21:29
 * @Description: <p>
 * 使括号有效的最少添加
 * <p>
 * 给定一个括号字符串 s ，在每一次操作中，你都可以在字符串的任何位置插入一个括号
 * 请问你最少需要几次插入才能使得 s 变成一个有效的括号串？
 * <p>
 * 比如说输入 s = "())("，算法应该返回 2，
 * 因为我们至少需要插入两次把 s 变成 "(())()"，
 * 这样每个左括号都有一个右括号匹配，s 是一个有效的括号串。
 */
public class MinAddToMakeValid_8 {

    /**
     * 核心思路是以左括号为基准，通过维护对右括号的需求数 need，来计算最小的插入次数。需要注意两个地方：
     * 1、当 need == -1 的时候意味着什么？
     * 2、算法为什么返回 res + need？
     */
    public int minAddToMakeValid(String s) {
        // 记录插入次数
        int res = 0;
        // need变量记录右括号的需求量
        int need = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                // 对右括号的需求 + 1
                need++;
            }
            if (c == ')') {
                // 对右括号的需求 -1
                need--;
                if (need == -1) {
                    need = 0;
                    // 需插入一个左括号
                    res++;
                }
            }
        }
        // 插入剩余所需的右括号
        return res + need;
    }

    /**
     * 消去合法的括号，剩下的不合法，都在栈中，插入相应的括号会合法，栈的长度即为最少添加次数
     */
    public int minAddToMakeValid2(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else { // c == ) ，匹配，消则去 ( )
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.poll();
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.size();
    }
}
