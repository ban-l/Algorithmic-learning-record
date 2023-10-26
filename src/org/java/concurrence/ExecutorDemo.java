package org.java.concurrence;

import org.java.concurrence.usage.MyRunnable;
import org.java.concurrence.usage.MyThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: Ban
 * @Date: 2023/8/6 21:34
 * @Description: <p>
 */
public class ExecutorDemo {
    public static void main(String[] args) {
        // ExecutorService executorService = Executors.newCachedThreadPool();  // 个任务创建一个线程；
        // ExecutorService executorService = Executors.newFixedThreadPool(5); // 所有任务只能使用固定大小的线程；
        ExecutorService executorService = Executors.newSingleThreadExecutor(); // 相当于大小为 1 的 FixedThreadPool。
        for (int i = 0; i < 5; i++) {
            executorService.execute(new MyRunnable());
            executorService.submit(new MyThread());
        }
        executorService.shutdown();

    }
}
