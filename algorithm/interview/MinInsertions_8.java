package org.algorithm.interview;

/**
 * @Auther: Ban
 * @Date: 2024/1/2 21:42
 * @Description: <p>
 * 1541. 平衡括号字符串的最少插入次数
 * <p>
 * 给你一个括号字符串 s ，它只包含字符 '(' 和 ')' 。一个括号字符串被称为平衡的当它满足：
 * <p>
 * 任何左括号 '(' 必须对应两个连续的右括号 '))' 。
 * 左括号 '(' 必须在对应的连续两个右括号 '))' 之前。
 * 比方说 "())"， "())(())))" 和 "(())())))" 都是平衡的， ")()"， "()))" 和 "(()))" 都是不平衡的。
 * <p>
 * 你可以在任意位置插入字符 '(' 和 ')' 使字符串平衡。
 */
public class MinInsertions_8 {
    public int minInsertions(String s) {
        // res 记录插入数
        int res = 0;
        // need 记录需右括号的需求量
        int need = 0;
        for (char c : s.toCharArray()) {
            // 一个左括号对应两个右括号
            if (c == '(') {
                need += 2;
                if (need % 2 == 1) {
                    // 插入一个右括号
                    res++;
                    // 对右括号的需求减一
                    need--;
                }
            }
            if (c == ')') {
                need--;
                // 说明右括号太多了
                if (need == -1) {
                    // 需要插入一个左括号
                    res++;
                    // 同时，对右括号的需求变为 1
                    need = 1;
                }
            }
        }
        return res + need;
    }
}
