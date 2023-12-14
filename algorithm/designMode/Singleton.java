package org.algorithm.designMode;

/**
 * @Auther: Ban
 * @Date: 2023/12/11 10:20
 * @Description: <p>
 * 单例模式
 */
public class Singleton {
    // 私有构造器
    private Singleton() {

    }

    // 私有静态对象变量
    private volatile static Singleton s;

    // 公有静态方法，返回对象变量
    // 1.双重校验锁-线程安全
    public static Singleton gert() {
        if (s == null) {
            synchronized (Singleton.class) {
                if (s == null) {
                    s = new Singleton();
                }
            }
        }
        return s;
    }

    // 公有静态方法，返回对象变量
    // 2.静态内部类实现
    public static Singleton getInstance() {
        return Internal.singleton;
    }

    // 静态内部类
    public static class Internal {
        private static final Singleton singleton = new Singleton();
    }
}
