package org.java.collection;

import org.java.demo.Demo;
import org.java.demo.Demo2;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Auther: Ban
 * @Date: 2023/6/20 10:37
 * @Description:
 */
public class TreeSetDemo {
    public static void main(String[] args) {
        Set<Demo> set = new TreeSet<>();
        // 1.Demo实现Comparable接口，排序
        set.add(new Demo(10));
        set.add(new Demo(5));
        set.add(new Demo(25));
        set.add(new Demo(50));
        set.add(new Demo(20));
        set.forEach(i -> System.out.println(i.getNumber()));

        // 2.传递⼀个⽐较器对象给 TreeSet 构造器
        Set<Demo2> set2 = new TreeSet<>(new MyComparator());
        set2.add(new Demo2(10));
        set2.add(new Demo2(5));
        set2.add(new Demo2(25));
        set2.add(new Demo2(50));
        set2.add(new Demo2(20));
        set2.forEach(i -> System.out.println(i.getNumber()));

        // 3.使用匿名内部类
        Set<Demo2> set3 = new TreeSet<>(new Comparator<Demo2>() {
            @Override
            public int compare(Demo2 o1, Demo2 o2) {
                return o1.getNumber() - o2.getNumber();
            }
        });
        set3.add(new Demo2(10));
        set3.add(new Demo2(5));
        set3.add(new Demo2(25));
        set3.add(new Demo2(50));
        set3.add(new Demo2(20));
        set3.forEach(i -> System.out.println(i.getNumber()));

        //  4.使⽤ lambda 表达式，传递⼀个⽐较器对象
        Set<Demo2> set4 = new TreeSet<>((o1, o2) -> o1.getNumber() - o2.getNumber());
        set4.add(new Demo2(10));
        set4.add(new Demo2(5));
        set4.add(new Demo2(25));
        set4.add(new Demo2(50));
        set4.add(new Demo2(20));
        set4.forEach(i -> System.out.println(i.getNumber()));
    }
}
