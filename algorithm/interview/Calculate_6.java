package org.algorithm.interview;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Auther: Ban
 * @Date: 2023/12/20 09:52
 * @Description: <p>
 */
public class Calculate_6 {
    /*一般思路：中缀表达式计算，麻烦，不采用*/

    // 字符串转整数
    public int stringToInt(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum = 10 * sum + (s.charAt(i) - '0');
        }
        return sum;
    }

    /**
     * 1.处理加减法
     * 如果输入的这个算式只包含加、减
     * 存在空格加入判断：c != ' '
     */
    public int calculate1(String s) {
        Stack<Integer> stack = new Stack<>();
        // 算式：(sign)num
        // 记录算式中的数字
        int num = 0;
        // 记录 num 前的符号，初始化为 +
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 如果是数字，连续读取到 num（字符串转整数）
            if (Character.isDigit(c)) {
                num = 10 * num + (c - '0');
            }
            // 如果不是数字，就是遇到了下一个符号 或者 当 i 走到了算式的尽头
            // 将之前的数字和符号就要存进栈中，(sign)num
            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                // 当前数字和符号入栈，(sign)num
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                }
                // 处理完毕，开始下一个：重置num，并更新下一个符号为当前符号
                num = 0;
                sign = c;

            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.peek();
            stack.pop();
        }
        return res;
    }

    /**
     * 2.处理乘除法
     * 如果输入的这个算式包含加、减、乘、除
     * 存在空格加入判断：c != ' '
     */
    public int calculate2(String s) {
        Deque<Integer> stack = new LinkedList<>();
        // 算式：(sign)num
        // 记录算式中的数字
        int num = 0;
        // 记录 num 前的符号，初始化为 +
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 如果是数字，连续读取到 num（字符串转整数）
            if (Character.isDigit(c)) {
                num = 10 * num + (c - '0');
            }
            // 如果不是数字，就是遇到了下一个符号 或者 当 i 走到了算式的尽头
            // 遇到+-，将之前的数字和符号就要存进栈中，(sign)num
            // 遇到*/，只要拿出前一个数字做对应运算即可，结果入栈
            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                switch (sign) {
                    // 遇到+-，当前数字和符号入栈，(sign)num
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    // 遇到*/，和前一个数字做对应运算，结果入栈
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                // 处理完毕，开始下一个：重置num，并更新下一个符号为当前符号
                num = 0;
                sign = c;

            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    /**
     * 3.处理括号
     * 如果输入的这个算式包含加、减、乘、除、括号
     */
    public int calculate3(String s) {
        // 字符串元素都加入队列，方面后续递归判断
        Deque<Character> deque = new LinkedList<>();
        for (char c : s.toCharArray()) {
            // Deque 当作队列使用：offer
            deque.offer(c);
        }
        int res = recursion(deque);
        return res;
    }

    public int recursion(Deque<Character> s) {
        // Deque 当作栈使用：push
        Deque<Integer> stack = new LinkedList<>();

        // 算式：(sign)num
        // 记录算式中的数字
        int num = 0;
        // 记录 num 前的符号，初始化为 +
        char sign = '+';

        while (!s.isEmpty()) {
            char c = s.poll();
            // 如果是数字，连续读取到 num（字符串转整数）
            if (Character.isDigit(c)) {
                num = 10 * num + (c - '0');
            }
            // 遇到左括号开始递归计算 num
            if (c == '(') {
                num = recursion(s);
            }
            // 如果不是数字，就是遇到了下一个符号 或者 当 i 走到了算式的尽头
            // 遇到+-，将之前的数字和符号就要存进栈中，(sign)num
            // 遇到*/，只要拿出前一个数字做对应运算即可，结果入栈
            if ((!Character.isDigit(c) && c != ' ') || s.isEmpty()) {
                // 遇到+-，当前数字和符号入栈，(sign)num
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                }
                // 遇到*/，和前一个数字做对应运算，结果入栈
                else if (sign == '*') {
                    stack.push(stack.poll() * num);
                } else if (sign == '/') {
                    stack.push(stack.poll() / num);
                }
                // 处理完毕，开始下一个：重置num，并更新下一个符号为当前符号
                num = 0;
                sign = c;
            }
            // 遇到右括号返回递归结果
            if (c == ')') {
                break;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        Calculate_6 c = new Calculate_6();
        // 加减法
        System.out.println(c.calculate1("1-12+3"));
        System.out.println(c.calculate1("1 - 12 + 3"));
        // 加减乘除法
        System.out.println(c.calculate2("2-3*4+5"));
        System.out.println(c.calculate2("2 - 3 * 4 + 5"));
        // 有括号
        System.out.println(c.calculate3("2-3*4+5"));
        System.out.println(c.calculate3("2 - 3 * 4 + 5"));
    }
}
