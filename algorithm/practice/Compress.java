package org.algorithm.practice;

/**
 * @Auther: Ban
 * @Date: 2023/11/1 19:42
 * @Description: <p>
 * 压缩字符串的规则如下：
 * 1.如果字母a连续出现n次,(10000>n>1),则表示为(a)n
 * 2.可以嵌套，比如((a)2(b)2)2,表示的是aabbaabb的压缩后结果
 * 3.只出现一次的字母不进行压缩，a的压缩后结果仍然为a
 * <p>
 * 输入为一个字符串的压缩结果，请输出压缩前的字符串。
 */
public class Compress {
    private static int index = 0;

    public static String decompressString(String compressed) {
        StringBuilder result = new StringBuilder();
        while (index < compressed.length()) {
            char currentChar = compressed.charAt(index);
            if (currentChar == '(') {
                index++;
                StringBuilder innerResult = new StringBuilder(decompressString(compressed));
                index++; // 跳过')'
                StringBuilder repeatCount = new StringBuilder();
                while (index < compressed.length() && Character.isDigit(compressed.charAt(index))) {
                    repeatCount.append(compressed.charAt(index));
                    index++;
                }
                int count = Integer.parseInt(repeatCount.toString());
                for (int i = 0; i < count; i++) {
                    result.append(innerResult);
                }
            } else if (currentChar == ')') {
                break;
            } else {
                result.append(currentChar);
                index++;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String compressedString = "(a)2(b)2(c)2";
        String decompressedString = decompressString(compressedString);
        System.out.println(decompressedString);  // 输出 "aabbcc"
    }
}
