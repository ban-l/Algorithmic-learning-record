package org.algorithm;

/**
 * @Auther: Ban
 * @Description: <p>
 */
public class Main {

    public static void main(String[] args) {
        Integer i1 = new Integer(100);
        Integer i2 = new Integer(100);
        System.out.println(i1 == i2);
        Integer i3 = 100;
        Integer i4 = 100;
        int i5 = 100;
        System.out.println(i3 == i4);
        System.out.println(i3 == i5);
    }
}
