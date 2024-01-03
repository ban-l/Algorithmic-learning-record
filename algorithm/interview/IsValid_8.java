package org.algorithm.interview;

import java.util.LinkedList;

/**
 * @Auther: Ban
 * @Date: 2023/12/25 20:48
 * @Description: <p>
 * 有效的括号
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 1.左括号必须用相同类型的右括号闭合。
 * 2.左括号必须以正确的顺序闭合。
 * 3.每个右括号都有一个对应的相同类型的左括号。
 */
public class IsValid_8 {

    /**
     * 使用栈
     * 遇到左括号入栈
     * 遇到右括号，去栈中寻找最近的左括号，看是否匹配
     */
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else { // 字符 c 是右括号')':则栈中 必须有相应左括号'('才合法
                // 栈不为空，c与最近的括号匹配，合法；否则不合法。
                if (!stack.isEmpty() && stack.peek() == leftOf(c)) {
                    stack.poll();
                } else {
                    // 和最近的左括号不匹配
                    return false;
                }
            }
        }
        // 是否所有的左括号都被匹配了
        return stack.isEmpty();
    }

    public char leftOf(char c) {
        if (c == ')') {
            return '(';
        } else if (c == '}') {
            return '{';
        } else {
            return '[';
        }
    }
}
