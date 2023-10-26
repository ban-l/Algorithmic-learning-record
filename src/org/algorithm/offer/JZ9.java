package org.algorithm.offer;

import java.util.Stack;

/**
 * @Auther: Ban
 * @Date: 2023/7/24 08:54
 * @Description: <p>
 * 用两个栈来实现一个队列，使用n个元素来完成 n 次在队列尾部插入整数(push)和n次在队列头部删除整数(pop)的功能。
 * 队列中的元素为int类型。保证操作合法，即保证pop操作时队列内已有元素。
 */
public class JZ9 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    /**
     * 借助 栈 的 先进后出 规则模拟实现 队列 的 先进先出
     * 1.插入时，直接出入 stack1
     * 2.弹出时，
     * <p> 1）若 stack2 不为空，则弹出 stack2 栈顶元素
     * <p> 2）若 stack2 为空，则把 stack1 全部数据出栈，入栈到 stack2，然后再弹出 stack2 栈顶元素
     */


    // 入栈
    public void push(int node) {
        stack1.push(node);
    }

    // 出栈
    public int pop() {
        // stack2为空，stack1全部出栈，入栈到stack2
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        // 弹出stack2栈顶元素
        return stack2.pop();
    }
}
