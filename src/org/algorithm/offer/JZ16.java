package org.algorithm.offer;

/**
 * @Auther: Ban
 * @Date: 2023/8/7 10:00
 * @Description: <p>
 * 数值的整数次方
 */
public class JZ16 {
    public static double power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        double res = 1;
        if (exponent > 0) {
            for (int i = 0; i < exponent; i++) {
                res = res * base;
            }
        } else {
            for (int i = 0; i < -exponent; i++) {
                res = res / base;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(power(2, 3));
    }
}
