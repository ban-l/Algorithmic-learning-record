package org.java.proxy.CGLIBDynamic;

/**
 * @Auther: Ban
 * @Date: 2023/7/15 16:02
 * @Description:定义发送短信的类
 */
public class Sms {
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
