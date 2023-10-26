package org.java.proxy.JDKDynamic;

/**
 * @Auther: Ban
 * @Date: 2023/7/13 14:33
 * @Description:创建代理类并同样实现发送短信的接口
 */
public class StaticSmsProxy implements SmsService {
    // 目标对象注入进代理类
    SmsServiceImpl smsService;

    public StaticSmsProxy(SmsServiceImpl smsService) {
        this.smsService = smsService;
    }

    @Override
    public String send(String message) {
        // 调用方法之前，我们可以添加自己的操作
        System.out.println("before method send()");
        smsService.send(message);
        // 调用方法之后，我们同样可以添加自己的操作
        System.out.println("after method send()");
        return null;
    }
}
