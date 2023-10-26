package org.algorithm.str;

/**
 * @Auther: Ban
 * @Date: 2023/8/9 11:03
 * @Description: <p>
 * 反转字符串中的单词
 */
public class ReverseWords {
    public static String reverseWords(String s) {
        s = s.trim();
        // 匹配空格 一次或多次
        String[] arr = s.split("\\s+");
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            String temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return String.join(" ", arr);
    }


    public static void main(String[] args) {
        String s = "  hello         world  ";
        String res = reverseWords(s);
        System.out.println(res);
    }

}
