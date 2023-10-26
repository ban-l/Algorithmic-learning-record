package org.java.collection;

import org.java.demo.Demo2;

import java.util.Comparator;

/**
 * @Auther: Ban
 * @Date: 2023/6/20 10:49
 * @Description: 为自定义类，创建一个比较器
 */
public class MyComparator implements Comparator<Demo2> {
    @Override
    public int compare(Demo2 o1, Demo2 o2) {
        return o1.getNumber() - o2.getNumber();
    }
}
