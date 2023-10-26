package org.java.proxy.JDKDynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Auther: Ban
 * @Date: 2023/7/13 15:18
 * @Description: JDK 动态代理类
 * <p>
 * 实现InvocationHandler 来自定义处理逻辑
 */
public class CustomizedHandler implements InvocationHandler {
    /**
     * 代理类中的真实对象
     */
    private final Object target;

    /**
     * 真实对象注入
     *
     * @param target
     */
    public CustomizedHandler(Object target) {
        this.target = target;
    }

    /**
     * 当你使用代理对象调用方法的时候实际会调用到这个方法
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //调用方法之前，我们可以添加自己的操作
        System.out.println("before method " + method.getName());
        // 调用原生方法
        Object result = method.invoke(target, args);
        //调用方法之后，我们同样可以添加自己的操作
        System.out.println("after method " + method.getName());
        return result;
    }
}
