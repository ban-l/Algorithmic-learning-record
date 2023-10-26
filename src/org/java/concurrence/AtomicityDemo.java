package org.java.concurrence;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

/**
 * @Auther: Ban
 * @Date: 2023/8/7 21:14
 * @Description: <p>
 * 原子性
 */
public class AtomicityDemo {
    public static void main(String[] args) {
        AtomicInteger atom = new AtomicInteger(1);
        // 原子操作，自增自减
        atom.incrementAndGet();
        atom.decrementAndGet();

        // 安全的生成一个数值
        AtomicLong observed = new AtomicLong();
        long value = observed.incrementAndGet();

        // 多线程最大值
        AtomicLong largest = new AtomicLong();
        // 这个代码不行，这个更新不是原子的
        largest.set(Math.max(largest.get(), value));

        // 采用lambda表达式更新变量，原子
        largest.updateAndGet(x -> Math.max(x, value));
        // 或者
        largest.accumulateAndGet(value, Math::max);
        largest.getAndUpdate(x -> Math.max(x, value));
        largest.getAndAccumulate(value, Math::max);

        // 大量线程访问相同的原子值，使用 LongAdder、LongAccumulator,当然也有处理double的类
        LongAdder longAdder = new LongAdder(); // 包含多个变量（加数），总和为当前值，所有线程完成工作后才求总和
        LongAccumulator longAccumulator = new LongAccumulator(Long::sum, 0);
    }
}
