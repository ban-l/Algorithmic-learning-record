package org.java.concurrence;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: Ban
 * @Date: 2023/8/4 20:51
 * @Description: <p>
 * ReentrantLock
 * 可重入锁
 */
public class LockDemo {
    public static void main(String[] args) throws InterruptedException {
        Lock mylock = new ReentrantLock();
        mylock.lock();
        mylock.unlock();
        // 条件变量
        Condition condition = mylock.newCondition();
        // 等待，进入等待集
        condition.await();
        // 激活，可运行状态
        condition.signal();
        condition.signalAll();
        LockDemo demo = new LockDemo();
        demo.wait();
        demo.notify();
        demo.notifyAll();

    }

    // 1.同步方法
    // 只作用于同一个对象
    public synchronized void method() {
        // method body
    }

    // 2.同步代码块
    // 只作用于同一个对象
    public void method(Object obj) {
        synchronized (this) {
            // 同步方法1；
            // 同步方法2；
            //  ……
            // 同步方法n；
        }
    }

    // 3.同步静态方法
    // 作用于整个类
    public synchronized static void method2() {
        // method body
    }

    // 4.同步静态代码块
    // 作用于整个类
    public void method2(Object obj) {
        // 只作用于同一个对象
        synchronized (LockDemo.class) {
            // 同步方法1；
            // 同步方法2；
            //  ……
            // 同步方法n；
        }
    }
}
