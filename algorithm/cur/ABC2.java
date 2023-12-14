package org.algorithm.cur;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: Ban
 * @Date: 2023/11/17 11:37
 * @Description: <p>
 */
public class ABC2 {

    /**
     * 思路：
     * 用三个标志来判断哪个线程应该wait
     * 在三个线程里面写入同步代码块，只有取得上面 syn 对象的对象锁，才能执行，这样保证同一时间只有一个线程在打印。
     * 配合wait 和notifyAll 还有三个标志就可以按照顺序打印ABC
     */
    public static void main(String[] args) {
        AtomicInteger syn = new AtomicInteger(0);
        Print a = new Print(syn, "A", 0);
        Print b = new Print(syn, "B", 1);
        Print c = new Print(syn, "C", 2);
        a.start();
        b.start();
        c.start();
    }
    static class Print extends Thread {
        private AtomicInteger syn;
        private String name;
        private int flag;
        private int count = 0;
        public Print(AtomicInteger syn, String name, int flag) {
            this.syn = syn;
            this.name = name;
            this.flag = flag;
        }
        @Override
        public void run() {
            while (true) {
                synchronized (syn) {
                    if (syn.get() % 3 == flag) {
                        syn.set(syn.get() + 1);
                        System.out.print(name);
                        syn.notifyAll();
                        count++;
                        if (count == 10) break;
                    } else {
                        try {
                            syn.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }
}
