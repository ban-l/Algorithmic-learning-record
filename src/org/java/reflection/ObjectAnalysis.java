package org.java.reflection;

import org.java.demo.Demo;

import java.lang.reflect.Field;

/**
 * @Auther: Ban
 * @Date: 2023/6/30 15:22
 * @Description:
 * 使用反射在运行时分析对象
 */
public class ObjectAnalysis {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Demo obj = new Demo();
        Class c = obj.getClass();
        Field f = c.getDeclaredField("number");
        // 覆盖权限 ，可以访问字段
        f.setAccessible(true);
        int value = f.getInt(obj);
        System.out.println(value);


        // Class c2 = Demo.class;
        // 抛出检查异常
        // Class.forName("org.java.test.Demo");
    }
}
