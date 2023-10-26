package org.java.general;

/**
 * @Auther: Ban
 * @Date: 2023/7/12 15:20
 * @Description: 内部类
 */
public class InnerClassDemo {
    String name;

    public InnerClassDemo(String name) {
        this.name = name;
    }

    public void method() {
        class InnerClassTest2 { // 局部内部类,当这个类的对象只被⼀个⽅法创建⼀次时，在⼀个⽅法中的局部地定义这个类
            int high;

            public void test2() {
                System.out.println(InnerClassDemo.this.name); // 外围类引用 OuterClass.this
                System.out.println(high);
            }
        }
        // 只创建一次
        InnerClassTest2 test2 = new InnerClassTest2();
        test2.test2();
    }

    public static void main(String[] args) {
        InnerClassDemo demo = new InnerClassDemo("hi");
        InnerClassTest test = demo.new InnerClassTest(); // 内部类对象的构造器 outerObject.new InnerClass(construction param)
        test.test();
        demo.method(); // 方法中有局部内部类

    }

    class InnerClassTest { // 内部类
        int age;

        void test() {
            System.out.println(InnerClassDemo.this.name); // 外围类引用 OuterClass.this
            System.out.println(age);
        }
    }
}

