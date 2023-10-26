package org.java;

/**
 * @Auther: Ban
 * @Date: 2023/8/12 09:13
 * @Description: <p>
 */
public class SwitchTest {
    public static void main(String[] args) {
        int a = 1;
        switch (a) {
            case 2:
                System.out.println(2);
            case 1:
                System.out.println(1);
            default:
                System.out.println("default");
            case 3:
                System.out.println(3);
        }
        /**
         * 输出
         * 1
         * default
         * 3
         */

        // param不允许为空，为null抛出异常
        String param = null;
        switch (param) {
            case "param":
                System.out.println("param");
                break;
            case "String":
                System.out.println("String");
                break;
            case "null":
                System.out.println("null");
                break;
            default:
                System.out.println("default");
        }
    }
}
