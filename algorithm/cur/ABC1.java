package org.algorithm.cur;

/**
 * @Auther: Ban
 * @Date: 2023/11/17 11:37
 * @Description: <p>
 */
public class ABC1 {

    /**
     * synchronized + wait/notify
     * 基本思路:
     * 线程A、线程B、线程C三个线程同时启动
     * 因为变量num的初始值为0，所以线程B或线程C拿到锁后，进入while()循环，然后执行wait()方法，线程线程阻塞，释放锁。
     * 只有线程A拿到锁后，不进入while()循环，执行num++，打印字符A，最后唤醒线程B和线程C。
     * 此时num值为1，只有线程B拿到锁后，不被阻塞，执行num++，打印字符B，最后唤醒线程A和线程C，后面以此类推。
     */
    private static final Object lock = new Object();
    private int num;

    public void printABC(int targetNum) {
        for (int i = 0; i < 10; i++) {
            synchronized (lock) { // 加锁
                while (num % 3 != targetNum) {
                    try {
                        lock.wait();  // 条件不满足，阻塞，释放锁o
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                num++;
                System.out.print(Thread.currentThread().getName());
                lock.notifyAll(); // 唤醒
            }
        }
    }
    public static void main(String[] args) {
        ABC1 abc = new ABC1();
        // lamda表达式
        // 函数式接口（一个抽象方法的接口，提供lambda表达式，调用时，执行lamda表达式的体）
        Thread t1 = new Thread(() -> abc.printABC(0), "A");
        Thread t2 = new Thread(() -> abc.printABC(1), "B");
        Thread t3 = new Thread(() -> abc.printABC(2), "C");
        t1.start();
        t2.start();
        t3.start();
    }
}
