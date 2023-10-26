package org.java.reflection;

import org.java.demo.Employee;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @Auther: Ban
 * @Date: 2023/7/1 16:30
 * @Description:调用任意方法和构造器
 */
public class MethodTableTest {
    public static void main(String[] args)
            throws ReflectiveOperationException {
        // 调用任意方法
        // get method pointers to the square and sqrt methods
        Method square = MethodTableTest.class.getMethod("square", double.class);
        Method sqrt = Math.class.getMethod("sqrt", double.class);
        // 提供参数值，调用方法
        System.out.println(sqrt.invoke(null, 4));

        // print tables of x- and y-values
        printTable(1, 10, 10, square);
        printTable(1, 10, 10, sqrt);

        // 调用任意构造器
        // 提供参数类型，获取构造器
        Constructor c = Employee.class.getConstructor(String.class);
        // 提供参数值，调用构造器
        Object obj = c.newInstance("name");
    }

    /**
     * 调用任意方法
     * Returns the square of a number
     *
     * @param x a number
     * @return x squared
     */
    public static double square(double x) {
        return x * x;
    }

    /**
     * Prints a table with x- and y-values for a method
     *
     * @param from the lower bound for the x-values
     * @param to   the upper bound for the x-values
     * @param n    the number of rows in the table
     * @param f    a method with a double parameter and double return value
     */
    public static void printTable(double from, double to, int n, Method f)
            throws ReflectiveOperationException {
        // print out the method as table header
        System.out.println(f);

        double dx = (to - from) / (n - 1);

        for (double x = from; x <= to; x += dx) {
            // 变参方法，两个参数（隐式参数，显示参数），若是静态方法，第一个参数为null
            double y = (Double) f.invoke(null, x);
            System.out.printf("%10.4f | %10.4f%n", x, y);
        }
    }
}
