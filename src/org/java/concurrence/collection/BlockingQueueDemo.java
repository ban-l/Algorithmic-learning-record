package org.java.concurrence.collection;

import java.util.PriorityQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Auther: Ban
 * @Date: 2023/8/8 21:11
 * @Description: <p>
 */
public class BlockingQueueDemo {
    public static void main(String[] args) {
        LinkedBlockingQueue<Integer> link = new LinkedBlockingQueue<>();
        ArrayBlockingQueue<Integer> list = new ArrayBlockingQueue<>(100);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
    }
}
