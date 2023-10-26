package org.java;


/**
 * @Auther: Ban
 * @Date: 2023/3/15 21:08
 * @Description: 初始化步骤
 *
 * 	 构造器的具体处理步骤：
 * 		○ 如果构造器第⼀⾏调⽤了第⼆个构造器， 则基于所提供的的参数执⾏第⼆个构造器，
 * 		○ 否则：
 * 			§ 所有数据域被初始化为默认值（0、false 或null)
 * 			§ 按照在类声明中出现的次序， 依次执⾏所有域初始化语句和初始化块
 * 				□ 先执⾏静态初始化块，再执⾏对象初始化块
 * 				□ 静态初始化块只执⾏⼀次，对象初始化块在每次创建这个类的对象时均执⾏）
 *      ○ 执⾏这个构造器的主体
 */
public class Initialize {

    // 0.所有数据域被初始化为默认值
    private int id;
    private static int count;

    public Initialize() {
        System.out.println("3.构造器主体");
    }

    public Initialize(int id) {
        this.id = id;
        System.out.println();
    }

    // 每次创建对象都执行
    {
        count++;
        id = count;
        System.out.println("2.对象初始化快");
    }

    // 只执行一次
    static {
        System.out.println("1.静态初始化快");
    }

    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException {
        Initialize test = new Initialize();
        Initialize test2 = new Initialize();
        System.out.println(count);
    }
}