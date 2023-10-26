package org.java.reflection;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Auther: Ban
 * @Date: 2023/7/1 16:01
 * @Description:
 * 使用反射编写泛型数组代码
 */
public class CopyOfTest {

    /**
     * This method grows an array by allocating a new array of the same type and
     * copying all elements.
     *
     * @param a the array to grow. This can be an object array or a primitive
     *          type array
     * @return a larger array that contains all elements of a.
     */
    public static Object goodCopyOf(Object a, int newLength) {
        // 1.获取数组的类对象
        Class cl = a.getClass();
        // 2.判断是否是数组
        if (!cl.isArray()) return null;
        // 3.确定数组的正确类型：Class类的 getComponentType()方法
        Class componentType = cl.getComponentType();
        // 4.获得旧数组长度, Array.getLength(a);
        int length = Array.getLength(a);
        // 5.静态方法 Array.newInstance(元素类型，数组长度) ，构造新数组
        Object newArray = Array.newInstance(componentType, newLength);
        // 6.赋值
        System.arraycopy(a, 0, newArray, 0, Math.min(length, newLength));
        // 返回值为Object类型，不是数组Object[]
        return newArray;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        a = (int[]) goodCopyOf(a, 10);
        System.out.println(Arrays.toString(a));

        String[] b = {"Tom", "Dick", "Harry"};
        b = (String[]) goodCopyOf(b, 10);
        System.out.println(Arrays.toString(b));
    }
}
