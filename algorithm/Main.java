package org.algorithm;

/**
 * @Auther: Ban
 * @Description: <p>
 */
public class Main {
    // 私有构造器
    private Main() {

    }

    // 私有静态对象变量
    private volatile static Main m;

    // 公有静态方法，返回对象变量
    public static Main gert() {
        if (m == null) {
            synchronized (Main.class) {
                if (m == null) {
                    m = new Main();
                }
            }
        }
        return m;
    }
}
