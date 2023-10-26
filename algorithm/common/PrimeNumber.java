package org.algorithm.common;

import java.util.Scanner;

/**
 * 分解质因数
 *
 * @author Ban
 */
public class PrimeNumber {

    /**
     * 质数是指在大于1的自然数中，除了1和它本身以外不再有其他因数的自然数
     * 判断是否是质数
     *
     * @param n
     */
    public static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 分解质因数
     * <p>
     * 分解质因数只针对合数。
     * <p>
     * 合数是指在大于1的整数中除了能被1和本身整除外，还能被其它数除外的数
     */
    public static void resolvePrimeNumber() {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        in.close();
        for (int i = a; i <= b; i++) {
            if (isPrime(i)) {
                System.out.println(i + "=" + i);
            } else { // 合数
                System.out.print(i + "=");
                int temp = i;
                boolean flag = false;
                while (temp != 1) {
                    // 从小到大找，找到一个后，再重新开始找
                    for (int j = 2; j <= temp; j++) {
                        if (isPrime(j) && temp % j == 0) {
                            if (flag) {
                                System.out.print("*");
                            }
                            System.out.print(j);
                            temp = temp / j;
                            break;
                        }
                    }
                    flag = true;
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        resolvePrimeNumber();
    }
}
