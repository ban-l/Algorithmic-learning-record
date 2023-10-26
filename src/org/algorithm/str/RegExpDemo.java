package org.algorithm.str;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @Auther: Ban
 * @Date: 2023/8/4 16:07
 * @Description: <p>
 * 正则表达式
 * https://juejin.cn/post/6844903952190816264#heading-2
 */
public class RegExpDemo {
    /**
     * 特殊字符需要转义
     * 如：
     * \  -> \\、 *  -> \*、 \*  -> \\*
     *
     * @param source
     * @return
     */
    public static List<String> removeComments(String[] source) {
        String[] res = String.join("\n", source).replaceAll("//.*|/\\*(.|\n)*?\\*/", "").split("\n");
        return Arrays.stream(res).filter(e -> (e.length() > 0)).collect(Collectors.toList());
    }


    public static void test() {
        String str = "123@qq.com 2323";
        String pattern = "[0-9]{3,}@qq.com";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        System.out.println(m.replaceAll("111"));
    }

    public static void main(String[] args) {
//        String[] source = {"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"};
//        String[] source2 = {"a/*comment", "line", "more_comment*/b"};
//        List<String> res = removeComments(source);
//        for (String s : res) {
//            System.out.println(s);
//        }

        test();
    }
}
