package com.example.example.variable;

public class MemberVariableLocalVariable {
    //member,成员变量，是对象的一部分，生命周期同对象，在堆内存中。被static修饰属于类的成员，。
    String member = "";

    public String dos(){
        //a,局部变量，属于方法，随栈帧销毁而销毁。
        int a = 0;
        //new，创建一个对象实例，在堆内存中。对象引用是指向一个对象实例。
        return new String();
    }


}
