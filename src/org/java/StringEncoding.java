package org.java;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @Auther: Ban
 * @Date: 2023/7/6 14:51
 * @Description:
 */
public class StringEncoding {

    public static void main(String[] args) throws UnsupportedEncodingException {

        String str1 = "中文";
        byte[] bytes = str1.getBytes("UTF-8"); // 使用UTF-8 编码，字符转换成字节
        System.out.println(bytes.length); // 6
        System.out.println(Arrays.toString(bytes)); // [-28, -72, -83, -26, -106, -121]
        String str2 = new String(bytes, "UTF-8"); // 使用UTF-8 解码，字节转换成字符
        System.out.println(str2); // "中文"
        // String的默认编码方式为 UTF-8
    }

}