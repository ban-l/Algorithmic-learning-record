package org.java.concurrence.aqs;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Auther: Ban
 * @Date: 2023/8/29 20:49
 * @Description: <p>
 * Semaphore 类似于操作系统中的信号量，可以控制对互斥资源的访问线程数。
 */
public class SemaphoreExample {
    public static void main(String[] args) {
        // clientCount=3，对互斥资源的访问线程数为3。
        // clientCount=1，则是临界资源，互斥访问，一次一个
        final int clientCount = 3;
        final int totalRequestCount = 10;
        Semaphore semaphore = new Semaphore(clientCount);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < totalRequestCount; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire(); // 信号量-1，阻塞线程
                    System.out.print(semaphore.availablePermits() + " ");
                } catch (InterruptedException e) {
                    e.printStackTrace(); // 信号量 +1，唤醒线程
                } finally {
                    semaphore.release();
                }
            });
        }
        executorService.shutdown();
    }
}