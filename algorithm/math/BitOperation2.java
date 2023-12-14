package org.algorithm.math;

/**
 * @Auther: Ban
 * @Date: 2023/11/14 09:47
 * @Description: <p>
 * 只出现一次的数字
 */
public class BitOperation2 {
    public static void solution() {

//        int x = 3;
//        //  x-- 和 (x--) 运算规则一样，括号不会影响
//        //  先赋值 再-1
//        int res1 = x--; // 3
//        int res2 = (x--); // 3


        int x = 3;
        System.out.println((x--) << x); // 3 << 2 = 3*2^2 = 12

        System.out.println(-2 >> 1); // -1
    }

    public static void main(String[] args) {
        solution();
    }
}
