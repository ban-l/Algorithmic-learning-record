package org.java.proxy.JDKDynamic;

/**
 * @Auther: Ban
 * @Date: 2023/7/13 14:33
 * @Description:实现发送短信的接口
 */
public class SmsServiceImpl implements SmsService {
    @Override
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
