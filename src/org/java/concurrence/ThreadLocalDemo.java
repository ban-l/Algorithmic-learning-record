package org.java.concurrence;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Auther: Ban
 * @Date: 2023/8/8 20:07
 * @Description: <p>
 */
public class ThreadLocalDemo {

    // 不安全
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    // 线程本地变量，不共享
    public static final ThreadLocal<SimpleDateFormat> threadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

    public static void main(String[] args) {
        // 不安全
        String dateStamp = dateFormat.format(new Date());
        System.out.println(dateStamp);
        // 安全
        // 首次调用get，会执行lambda表达式内容，返回属于当前线程的实例
        String s = threadLocal.get().format(new Date());
        System.out.println(s);

        // Random实现线程安全的，若多个线程共享一个随机数生成器，很低效
        // 1.ThreadLocal辅助类为 各个线程提供一个单独的 随机数生成器
        ThreadLocal<Random> local = ThreadLocal.withInitial(Random::new);
        // ThreadLocal<Random> local = ThreadLocal.withInitial(() -> new Random());
        Random localRandom = local.get();
        System.out.println(localRandom.nextInt(100));


        // 2.ThreadLocalRandom.current() 返回属于当前线程的 Random类实例
        Random random = ThreadLocalRandom.current();
        System.out.println(random.nextInt(100));

        threadLocal.remove();
        local.remove();



    }
}
