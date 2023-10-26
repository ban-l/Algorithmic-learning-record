package org.java.proxy.JDKDynamic;

import java.lang.reflect.Proxy;

/**
 * @Auther: Ban
 * @Date: 2023/7/13 15:37
 * @Description: 获取代理对象的工厂类
 */
public class JdkProxyFactory {

    /**
     * 通过Proxy.newProxyInstance（）方法获取某个类的代理对象
     *
     * @param target
     * @return
     */
    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // 目标类的类加载
                target.getClass().getInterfaces(), // 代理需要实现的接口，可指定多个
                new CustomizedHandler(target)); // 调用处理器，代理对象对应的自定义 InvocationHandler
    }
}
