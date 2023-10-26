package org.java.concurrence.aqs;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Auther: Ban
 * @Date: 2023/8/29 21:13
 * @Description: <p>
 * FutureTask 实现了 RunnableFuture 接口，RunnableFuture 接口继承自 Runnable 和 Future<V> 接口
 * FutureTask 可以当做一个任务(线程)执行
 * FutureTask 也可以有返回值，返回异步计算结果
 */
public class FutureTaskExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int result = 0;
                for (int i = 1; i <= 100; i++) {
                    Thread.sleep(10);
                    result += i;
                }
                return result;
            }
        });

        Thread computeThread = new Thread(futureTask);
        computeThread.start();

        //
        Thread otherThread = new Thread(() -> {
            System.out.println("other task is running...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        otherThread.start();
        // futureTask异步获取执行结果 result
        System.out.println(futureTask.get());
    }
}
