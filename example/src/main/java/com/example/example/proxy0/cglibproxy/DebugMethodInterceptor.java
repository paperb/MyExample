package com.example.example.proxy0.cglibproxy;


import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class DebugMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before method" + method.getName());
        //CglibProxy是生成一个被代理类的子类来拦截被代理类的方法调用，不能代理声明为final的类和方法
        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println("after method" + method.getName());
        return object;
    }
}
