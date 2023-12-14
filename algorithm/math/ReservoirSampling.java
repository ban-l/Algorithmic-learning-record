package org.algorithm.math;

import org.algorithm.linear.ListNode;

import java.util.Random;

/**
 * @Auther: Ban
 * @Date: 2023/11/20 11:09
 * @Description: <p>
 * 水塘抽样算法
 */
public class ReservoirSampling {

    // 返回链表中一个随机节点的值

    /**
     * 1.水塘抽样
     * 当你遇到第 i 个元素时，应该有 1/i 的概率选择该元素，1 - 1/i 的概率保持原有的选择
     */
    public int getRandom(ListNode head) {
        Random r = new Random();
        int i = 0, res = 0;
        ListNode p = head;
        // while 循环遍历链表
        while (p != null) {
            i++;
            // 生成一个 [0, i) 之间的整数
            // 这个整数等于 0 的概率就是 1/i
            if (0 == r.nextInt(i)) {
                res = p.val;
            }
            p = p.next;
        }
        return res;
    }


    /**
     * 2.常规做法：遍历两次
     * 先遍历一遍链表，得到链表的总长度 n，
     * 再生成一个 [0,n-1) 之间的随机数为索引,
     * 然后找到索引对应的节点（遍历第二遍）。
     */
    public int getRandom2(ListNode head) {
        // 一次遍历，求出长度
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }
        // 生成[0,len)的随机数 为索引 r
        int r = new Random().nextInt(len);
        int res = 0; // 答案
        int count = 0; // 索引移动
        p = head;
        // 两次遍历
        while (p != null) {
            // 返回索引 r 对应的节点值
            if (r == count) {
                res = p.val;
                break;
            }
            count++;
            p = p.next;
        }
        return res;
    }

    // 单链表中随机选择 k 个数
    public int[] getRandom(ListNode head, int k) {
        Random r = new Random();
        int[] res = new int[k];
        ListNode p = head;

        // 前 k 个元素先默认选上
        for (int i = 0; i < k && p != null; i++) {
            res[i] = p.val;
            p = p.next;
        }

        int i = k;
        // while 循环遍历链表
        while (p != null) {
            i++;
            // 生成一个 [0, i) 之间的整数
            // 1/i的概率 == [0, i) 之间的整数
            int j = r.nextInt(i);
            // 这个整数小于 k 的概率就是 k/i
            if (j < k) {
                res[j] = p.val;
            }
            p = p.next;
        }
        return res;
    }


}
