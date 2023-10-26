package org.java;

/**
 * @Auther: Ban
 * @Date: 2023/7/24 15:27
 * @Description: <p>
 */
public class FloatTest {

    public static void main(String[] args) {

        /**
         * 精度丢失，科学记数法，有误差，2进制不能精确表示浮点数
         * Java 语言支持两种基本的浮点类型： float 和 double ，以及与它们对应的包装类 Float 和 Double 。
         * 它们都依据 IEEE 754 标准，该标准用科学记数法以底数为 2 的小数来表示浮点数。
         * 但浮点运算很少是精确的。虽然一些数字可以精确地表示为二进制小数，比如说 0.5，它等于 2^-1；
         * 但有些数字则不能精确的表示，比如说 0.1。
         * 因此，浮点运算可能会导致舍入误差，产生的结果接近但并不等于我们希望的结果。
         * 所以，我们看到了 0.1 的两个相近的浮点值，一个是比 0.1 略微大了一点点的 0.100000024，一个是比 0.1 略微小了一点点的 0.099999964。
         * Java 对于任意一个浮点字面量，最终都舍入到所能表示的最靠近的那个浮点值，遇到该值离左右两个能表示的浮点值距离相等时，默认采用偶数优先的原则
         *
         * 原来包装器不会解决精度的问题
         */
        float a = 1.0f - 0.9f; // 0.100000024
        float b = 0.9f - 0.8f; // 0.099999964
        System.out.println(a == b);

        Float m = Float.valueOf(a);
        Float n = Float.valueOf(b);
        System.out.println(m.equals(n));

        Double x = new Double(a);
        Double y = new Double(b);
        System.out.println(x.equals(y));


    }
}
