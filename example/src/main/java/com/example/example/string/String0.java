package com.example.example.string;


public class String0 {
    //String用字符数组来保存字符串
    //String是不可变的，因为他的成员数组value[]被final修饰，并且没有提供/暴露修改这个字符串的方式。
    //当改变一个String对象时，实际上是把这个String对象指向了新的String对象
    //String是线程安全的，可以理解为常量。
    String str = "";


    String s = "12435r25";

    public static void main(String[] args) {
        String0 string0 = new String0();

        boolean contains = string0.s.contains("1");
        System.out.println(contains);
    }
    /*

//public final class String implements java.io.Serialization, Comparable_<String>, CharSequence {
//    /** The value is used for character storage. */
//    private final char value[];
}
