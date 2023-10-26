package org.java.general;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Auther: Ban
 * @Date: 2023/7/28 14:50
 * @Description: <p>
 */
public class ObjectHeaderDemo {
    int test;
    public static void main(String[] args) {
        ObjectHeaderDemo demo = new ObjectHeaderDemo();
        String s = ClassLayout.parseInstance(demo).toPrintable();
        System.out.println(s);
    }
}
