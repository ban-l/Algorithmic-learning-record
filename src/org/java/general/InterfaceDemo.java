package org.java.general;


/**
 * @Auther: Ban
 * @Date: 2023/3/15 21:08
 * @Description: test文件
 */
public class InterfaceDemo implements InterfaceTest {

    public static void main(String[] args) {
        InterfaceDemo test = new InterfaceDemo();
        test.test1();
    }

    @Override
    public void test2() {
        System.out.println("test2");
    }
}