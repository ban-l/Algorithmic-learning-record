package org.java.proxy;

import org.java.proxy.CGLIBDynamic.CglibProxyFactory;
import org.java.proxy.CGLIBDynamic.Sms;
import org.java.proxy.JDKDynamic.JdkProxyFactory;
import org.java.proxy.JDKDynamic.SmsService;
import org.java.proxy.JDKDynamic.SmsServiceImpl;
import org.java.proxy.JDKDynamic.StaticSmsProxy;

import java.lang.reflect.Proxy;

/**
 * @Auther: Ban
 * @Date: 2023/7/13 14:36
 * @Description:
 */
public class ProxyTest {
    public static void main(String[] args) {
        // 静态代理
        SmsServiceImpl smsService = new SmsServiceImpl(); // 真实对象
        StaticSmsProxy staticSmsProxy = new StaticSmsProxy(smsService); // 静态代理对象
        staticSmsProxy.send("静态代理");

        // JDK 动态代理
        SmsServiceImpl service = new SmsServiceImpl();// 真实对象,接口实现类对象
        SmsService proxyJDK = (SmsService) JdkProxyFactory.getProxy(service); // 代理对象(只能代理接口实现类)
        proxyJDK.send("JDK动态代理");

        // CGLIB 动态代理
        Sms sms = new Sms(); // 真实对象
        Sms proxyCGLIB = (Sms) CglibProxyFactory.getProxy(sms.getClass());  // 代理对象（代理类）
        proxyCGLIB.send("CGLIB 动态代理");

    }
}
