package com.example.example.proxy0.jdkproxy;

public class JDKproxy  {

    //JDK动态代理只能代理实现了接口的类
    public static void main(String[] args) {
        SmsService smsService = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());

        smsService.send("java");
    }


}
