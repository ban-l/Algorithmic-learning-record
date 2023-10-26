package org.algorithm.offer;

/**
 * @Auther: Ban
 * @Date: 2023/7/18 09:34
 * @Description: 请实现一个函数，将一个字符串s中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class JZ5 {

    public static final String CONSTANT = "%20";

    public static String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isSpaceChar(s.charAt(i))) {
                sb.append(CONSTANT);
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace("We Are Happy"));
    }
}
