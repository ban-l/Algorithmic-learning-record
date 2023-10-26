package org.java;

import org.java.concurrence.usage.MyCallable;
import org.java.concurrence.usage.MyRunnable;
import org.java.concurrence.usage.MyThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Auther: Ban
 * @Date: 2023/8/9 21:20
 * @Description: <p>
 */
public class ExecutorDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service1 = Executors.newCachedThreadPool();
        ExecutorService service2 = Executors.newFixedThreadPool(16);
        ExecutorService service3 = Executors.newSingleThreadExecutor();

        // 提交到线程池，Future得到结果或取消任务
        Future f1 = service1.submit(new MyCallable());
        Future f2 = service2.submit(new MyRunnable());
        Future f3 = service3.submit(new MyThread());

        service1.shutdown();
        service1.shutdownNow();

        List<MyCallable> list = new ArrayList<>();
        service1.invokeAll(list);
        service1.invokeAny(list);
    }
}
