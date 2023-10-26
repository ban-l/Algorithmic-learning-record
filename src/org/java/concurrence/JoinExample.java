package org.java.concurrence;

/**
 * @Auther: Ban
 * @Date: 2023/8/6 21:58
 * @Description: <p>
 */
public class JoinExample {
    public static void main(String[] args) {
        A a = new A();
        B b = new B(a);
        // 线程 a, b 启动
        // 先执行 线程 b，执行中 调用 a.join(), b会等待 a终止后，b继续执行
        b.start();
        a.start();

    }

    // 线程A
    private static class A extends Thread {
        @Override
        public void run() {
            System.out.println("A");
        }
    }

    // 线程B
    private static class B extends Thread {

        private A a;

        B(A a) {
            this.a = a;
        }

        @Override
        public void run() {
            try {
                System.out.println("B1");
                // 等待线程 a 终止，线程 b 才会继续执行
                a.join(); // 等待指定的线程终止
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B2");
        }
    }
}
