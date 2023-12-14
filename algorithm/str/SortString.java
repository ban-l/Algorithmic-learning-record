package org.algorithm.str;

import java.util.Arrays;

/**
 * @Auther: Ban
 * @Date: 2023/12/11 10:04
 * @Description: <p>
 * 数据排序
 * 假设有如下字符串“A12”，其中“A”表示数据类型（A-Z），“12”表示数据序号（0-9）。
 * 现在需要对一组数据先按照数据序号再按照数据类型进行排序。
 * 例如：["B3","D2","F1","A9","D12","A2","C1","Z0","B1"]=>["Z0","B1","C1","F1","A2","D2","B3","A9","D12"]
 */
public class SortString {
    /**
     * 思路：
     * 1.91进制 转 10进制
     * 2.10进制比大小
     * 3.10进制 转 91进制
     * <p>
     * A的ascii码是65
     * Z的ascii码是90
     */
    public static String[] sort(String[] s) {
        int n = s.length;
        int[] nums = new int[n];
        // 1. 91进制 转 10进制
        for (int i = 0; i < n; i++) {
            String t = s[i];
            // char转int
            int a = t.charAt(0) - '0';
            int b = Integer.valueOf(t.substring(1, t.length())) * 91;
            nums[i] = a + b;
        }
        // 2. 10进制比大小
        Arrays.sort(nums);
        // 3. 10进制 转 91进制
        for (int i = 0; i < n; i++) {
            String s1 = String.valueOf(nums[i] / 91);
            // int转char
            String s2 = String.valueOf((char) (nums[i] % 91 + '0'));
            s[i] = s2 + s1;
        }
        return s;
    }

    public static void main(String[] args) {
        String[] s = {"B3", "D2", "F1", "A9", "D12", "A2", "C1", "Z0", "B1"};
        s = sort(s);
        System.out.println(Arrays.toString(s));
    }
}
