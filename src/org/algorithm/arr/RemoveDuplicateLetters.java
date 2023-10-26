package org.algorithm.arr;

import java.util.LinkedList;

/**
 * @Auther: Ban
 * @Date: 2023/8/14 10:42
 * @Description: <p>
 */
public class RemoveDuplicateLetters {

    /**
     * 1.去重
     * 2.去重后，相对顺序不变
     * 3.字典序最小
     */
    public static String removeDuplicateLetters(String s) {
        // 维护一个计数器记录字符串中字符的数量
        // 因为输入为 ASCII 字符，大小 256 够用了
        int[] count = new int[256];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        // 双端队列，选择在右端操作
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            count[c]--; // 每遍历过一个字符，都将对应的计数减一

            if (stack.contains(c)) continue; // 去重

            while (!stack.isEmpty() && stack.peekLast() > c) {
                // 若之后不存在栈顶元素了，则停止 poll
                if (count[stack.peekLast()] == 0) {
                    break;
                }
                // 若之后还有，则可以 poll
                stack.pollLast();
            }
            stack.offerLast(c);
        }
        return stack.toString().replaceAll("\\W*", "");
    }

    public static void main(String[] args) {
        String res = removeDuplicateLetters("ecbacba");
        System.out.println(res);
    }
}
