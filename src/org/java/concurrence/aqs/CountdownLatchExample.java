package org.java.concurrence.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: Ban
 * @Date: 2023/8/29 20:36
 * @Description: <p>
 * <p>
 * 用来控制一个或者多个线程等待多个线程。
 */
public class CountdownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        final int totalThread = 10;
        CountDownLatch countDownLatch = new CountDownLatch(totalThread);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < totalThread; i++) {
            executorService.execute(() -> {
                System.out.print("run..");
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();// 等待，只有 cnt 为0时，才会被唤醒
        System.out.println("end");
        executorService.shutdown();
    }
}
