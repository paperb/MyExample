package com.example.example.string;

public class StringBuilder0 {

    //StringBuilder并没有对方法加同步锁，
    //StringBuilder是线程不安全的
    //循环拼接字符串使用StringBuilder.append防止使用String.append造成StringBuild创建对象过多
    StringBuilder builder = new StringBuilder();

    public StringBuilder testBuilder(){
        builder.append("123?");
        builder.append("456?");
        builder.append("789.");
        return builder;
    }

    public static void main(String[] args) {
        StringBuilder0 s0 = new StringBuilder0();
        System.out.println(s0.testBuilder());
    }
}
