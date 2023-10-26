package org.java.lambda;

/**
 * @Auther: Ban
 * @Date: 2023/7/5 14:30
 * @Description:lambda表达式
 * 函数式接口
 */
public class FunctionalInterface {

    /**
     * 参数为接口的对象，使用lambda表达式（作为一个函数参数）
     *
     * @param a
     * @param b
     * @param mathOperation
     * @return
     */
    private int operate(int a, int b, MathOperation mathOperation) {
        // 调用对象的方法，会执行lambda表达式的体
        return mathOperation.operation(a, b);
    }

    public static void main(String args[]) {
        FunctionalInterface l = new FunctionalInterface();

        // 函数式接口，生成接口对象
        // 类型声明
        MathOperation addition = (int a, int b) -> a + b;

        // 不用类型声明
        MathOperation subtraction = (a, b) -> a - b;

        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> {
            return a * b;
        };

        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;

        // 函数作为参数
        System.out.println("10 + 5 = " + l.operate(10, 5, addition));
        System.out.println("10 - 5 = " + l.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + l.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + l.operate(10, 5, division));

        // 不用括号
        GreetingService greetService1 = message ->
                System.out.println("Hello " + message);

        // 用括号
        GreetingService greetService2 = (message) ->
                System.out.println("Hello " + message);

        greetService1.sayMessage("Runoob");
        greetService2.sayMessage("Google");
    }

    // 函数式接口，只有一个抽象方法
    interface MathOperation {
        int operation(int a, int b);
    }

    // 函数式接口，只有一个抽象方法
    interface GreetingService {
        void sayMessage(String message);
    }


}