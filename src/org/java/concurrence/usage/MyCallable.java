package org.java.concurrence.usage;

import java.util.concurrent.Callable;

/**
 * @Auther: Ban
 * @Date: 2023/8/6 21:37
 * @Description: <p>
 */
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("MyCallable");
        return "MyCallable";
    }
}