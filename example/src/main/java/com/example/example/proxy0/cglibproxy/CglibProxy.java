package com.example.example.proxy0.cglibproxy;

public class CglibProxy {
    public static void main(String[] args) {
        AliSmsService aliSmsService = (AliSmsService)CglibProxyFactory.getProxy(AliSmsService.class);
        aliSmsService.send("java");
    }
}
