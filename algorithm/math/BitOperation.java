package org.algorithm.math;

/**
 * @Auther: Ban
 * @Date: 2023/11/14 09:47
 * @Description: <p>
 * 只出现一次的数字
 */
public class BitOperation {

    /**
     * 1. 转换大小写字母：| & ^
     */
    public static void operation1() {
        // 1.利用或操作 | 和空格将英文字符转换为小写
        char a1 = 'a' | ' ';
        char a2 = 'A' | ' ';
        System.out.println(a1 + " " + a2);

        // 2.利用与操作 & 和下划线将英文字符转换为大写
        char b1 = 'b' & '_';
        char b2 = 'B' & '_';
        System.out.println(b1 + " " + b2);

        // 3.利用异或操作 ^ 和空格进行英文字符大小写互换
        char c1 = 'd' ^ ' ';
        char c2 = 'D' ^ ' ';
        System.out.println(c1 + " " + c2);

        // 4.判断两个数是否异号
        int x1 = -1, y1 = 2;
        boolean f1 = ((x1 ^ y1) < 0); // true
        System.out.println(f1);

        int x2 = 3, y2 = 2;
        boolean f2 = ((x2 ^ y2) < 0); // false
        System.out.println(f2);

    }

    /**
     * 2. index & (arr.length - 1) 的运用
     * 前提：数组长度是 2 的幂次方
     * 使用 位运算& 代替 取模%
     */
    public static void operation2() {
        /*
        int[] arr = {1, 2, 3, 4};
        int index = 0;
        while (true) {
            // 在环形数组中转圈
            System.out.println(arr[index % arr.length]);
            index++;
        }
        输出：1,2,3,4,1,2,3,4,1,2,3,4...
        */
        int[] arr = {1, 2, 3, 4};
        int index = 0;
        while (true) {
            // 在环形数组中转圈
            System.out.println(arr[index & (arr.length - 1)]);
            index++;
        }
        // 输出：1,2,3,4,1,2,3,4,1,2,3,4...

    }

    /**
     * 3. n & (n-1) 的运用
     * n & (n-1) 这个操作在算法中比较常见，作用是消除数字 n 的二进制表示中的最后一个 1。
     * <p>
     */

    /**
     * 例题1： 位1的个数
     * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
     */
    public static int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            n = n & (n - 1);
        }
        return res;
    }

    /**
     * 例题2： 2 的幂
     * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
     * 如果存在一个整数 x 使得 n == 2^x ，则认为 n 是 2 的幂次方。
     */
    public static boolean isPowerOfTwo(int n) {
        // 2的幂次方都大于0
        if (n <= 0) return false;
        // 只有一个1，消去后看是否为0
        boolean res = (n & n - 1) == 0;
        return res;
    }


    /**
     * 4. a ^ a = 0 的运用（相同为0，不同为1）
     * <p>
     * 一个数和它本身做异或运算结果为 0，即 a ^ a = 0；
     * 一个数和 0 做异或运算的结果为它本身，即 a ^ 0 = a。
     * <p>
     */


    /**
     * 例题1：只出现一次的数字
     * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     */
    public static int singleNumber(int[] nums) {
        // 把所有数字进行异或，成对儿的数字就会变成 0，落单的数字和 0 做异或还是它本身
        // 所以最后异或的结果就是只出现一次的元素：
        int res = 0;
        for (int i : nums) {
            res ^= i;
        }
        return res;
    }

    /**
     * 例题2：丢失的数字
     * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
     */
    public static int missingNumber(int[] nums) {
        int res = 0;
        int n = nums.length;

        // 1.辅助空间
        int[] a = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            int index = nums[i];
            a[index] = 1;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                res = i;
            }
        }

        /**
         * 2.等差数列
         * 题目理解：现在有个等差数列 0, 1, 2,..., n，其中少了某一个数字，请你把它找出来。
         * 那这个数字就是 sum(0,1,..n) - sum(nums)
         */
        res = 0;
        n = nums.length;
        // 等差数列的和=(首数+尾数)*项数/2
        int expect = (0 + n) * (n + 1) / 2;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        res = expect - sum;


        /**3.位运算
         * 索引和数做异或运算
         * 把所有的元素 和 索引 做异或运算，成对儿的数字都会消为 0，只有这个落单的元素会剩下
         * 例如：
         * 索引：0 1 2 3
         * 数组：0 3 1 4
         * 缺失的元素是 2
         *
         * 补上一个索引
         * 索引：0 1 2 3 4
         * 数组：0 3 1 4 ?
         * 全部做异或运算，最后结果为 缺失元素 ？
         */
        res = 0;
        n = nums.length;
        // 先和新补的索引异或一下
        res ^= n;
        // 和其他的元素、索引做异或
        for (int i = 0; i < nums.length; i++) {
            res ^= i ^ nums[i];
        }
        return res;
    }


    public static void main(String[] args) {
        // operation1();
        // operation2();
    }
}
