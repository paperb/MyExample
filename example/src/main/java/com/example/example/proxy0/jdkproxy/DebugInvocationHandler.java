package com.example.example.proxy0.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DebugInvocationHandler implements InvocationHandler {
    private final Object target;

    public DebugInvocationHandler(Object target) {
        this.target = target;
    }

    //动态代理对象调用原生方法的时候，实际上用的是invoke()方法，invoke()代替我们去调用原生方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //方法执行之前
        System.out.println("before method" + method.getName());


        Object result = method.invoke(target, args);

        //方法执行之后
        System.out.println("after method" + method.getName());
        return result;
    }
}

//获取代理对象的工厂类
class JdkProxyFactory {
    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // 目标类的类加载
                target.getClass().getInterfaces(),  // 代理需要实现的接口，可指定多个
                new DebugInvocationHandler(target)   // 代理对象对应的自定义 InvocationHandler
        );
    }
}