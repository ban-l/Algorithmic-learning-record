package org.algorithm.interview;

/**
 * @Auther: Ban
 * @Date: 2023/12/19 10:05
 * @Description: <p>
 * 字符串相乘
 * <p>
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 */
public class Multiply_5 {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        // 结果最多为 m + n 位数
        int[] res = new int[m + n];
        // 从个位数开始逐位相乘
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // 乘积在 res 对应的索引位置
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); // 乘积
                int p1 = i + j; // 乘积的十位 对应 res索引
                int p2 = i + j + 1; // 乘积的个位 对应 res索引
                // 叠加到 res 上
                int sum = res[p2] + mul;
                // 更新res值
                res[p2] = sum % 10;
                res[p1] = res[p1] + sum / 10;
            }
        }
        // 结果前缀可能存的 0（未使用的位）
        int i = 0;
        while (i < res.length && res[i] == 0) {
            i++;
        }
        // 将计算结果转化成字符串
        StringBuilder s = new StringBuilder();
        for (; i < res.length; i++) {
            s.append(res[i]);
        }
        String ans = s.toString();
        // 可能0*0，字符串会为空，需要判断一下输出
        return ans.equals("") ? "0" : ans;
    }


    public static void main(String[] args) {
        Multiply_5 m = new Multiply_5();
        m.multiply("123", "456");
    }
}
