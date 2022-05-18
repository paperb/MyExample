package com.example.example.string;

public class StringBuffer0 {

    //StringBuffer提供了append等更多关于String的api
    //StringBuffer继承了AbstractStringBuilder，但是数组没有使用final关键字修饰
    //StringBuffer，是线程安全的，对方法加了同步锁或者对调用的方法加了同步锁。
    StringBuffer buffer = new StringBuffer("1234"+"4434254");

    public void appendStr(){


        buffer.append("ok");
        String s1 = buffer.toString();

        System.out.println(buffer);
        System.out.println(s1);
    }


    public static void main(String[] args) {
        StringBuffer0 stringBuffer0 = new StringBuffer0();

        stringBuffer0.appendStr();
    }
}
