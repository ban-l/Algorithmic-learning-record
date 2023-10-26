package org.algorithm.common;

import java.util.Stack;

/**
 * @Auther: Ban
 * @Date: 2023/9/24 16:52
 * @Description: <p>
 * 用两个栈实现队列
 */
public class TwoStacksToQueue<E> {


    /**
     * 思路：
     * stack1 作为存储空间，stack2 作为临时缓冲区。
     * 入队时：将元素压入 stack1。
     * 出队时：判断 stack2 是否为空
     * 如不为空，则直接弹出顶元素；
     * 如为空，则将 stack1 的元素逐个弹出，并压入 stack2，将 stack2 栈顶元素弹出作为出队元素
     */

    private Stack<E> stack1 = new Stack<>();
    private Stack<E> stack2 = new Stack<>();

    // 入栈
    public void push(E e) {
        // 入栈stack1
        stack1.push(e);
    }

    // 出栈
    public E pop() {
        // stack2不为空，弹出栈顶元素
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        // stack2为空
        // 若stack1为空，则无元素，返回null
        if (stack1.isEmpty()) {
            return null;
        }
        // 若stack1不为空
        while (!stack1.isEmpty()) {
            // stack1依次弹出栈顶元素，压入stack2
            stack2.push(stack1.pop());
        }
        // stack2弹出栈顶元素
        return stack2.pop();
    }

    public int count() {
        return stack1.size() + stack2.size();
    }

    public static void main(String[] args) {
        TwoStacksToQueue<Integer> queue = new TwoStacksToQueue<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        queue.push(4);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}
