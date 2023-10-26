package org.java.concurrence;

import org.java.concurrence.usage.MyCallable;
import org.java.concurrence.usage.MyRunnable;
import org.java.concurrence.usage.MyThread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Auther: Ban
 * @Date: 2023/7/30 20:58
 * @Description: <p>
 */
public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        // 函数式接口，提供一个lambda表达式
        // Runnable runnable = () -> System.out.println("test");
        //  t = new Thread(runnable);
        //  t.start();


        Runnable r = new MyRunnable();
        Thread t1 = new Thread(r);
        t1.start();

        Callable c = new MyCallable();
        FutureTask ft = new FutureTask<>(c);
        Thread t2 = new Thread(ft);
        t2.start();

        Thread t3 = new MyThread();
        t3.start();

        Thread.sleep(1000);
        Thread.yield();
        t1.join(1000);
        t1.getState();
        t1.wait();
        t1.interrupt();
        Thread.interrupted();
        t1.isInterrupted();
        t1.setDaemon(true);
        t1.setPriority(1);
    }


}
