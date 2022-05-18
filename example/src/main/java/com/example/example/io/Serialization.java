package com.example.example.io;


import java.beans.Transient;

public class Serialization{
    //序列化对象就是把数据结构或对象转换成二进制字节流的过程
    //反序列化就是把二进制字节流转换成数据结构或者对象的过程
}

class SeEntity {
    String name;
    //transient用来阻止变量序列化，修饰的变量值不会被持久化和恢复
    transient String nickname;
}
