package com.example.example.equals;

public class HashAndEquals {
    //hashCode()方法，确定该对象在哈希表中的索引位置

    String s1 = "123";
    String s2 = "123";

    public static void main(String[] args) {
        HashAndEquals hashAndEquals = new HashAndEquals();
        hashAndEquals.s1.hashCode();
        hashAndEquals.s2.hashCode();
        System.out.println(hashAndEquals.s1.hashCode());
        System.out.println(hashAndEquals.s2.hashCode());
        //如果两个对象的hashCode 值相等，那这两个对象不一定相等（哈希碰撞），哈希算法可能会使多个对象传回同一个hashcode
        //如果两个对象的hashCode 值相等并且equals()方法也返回 true，我们才认为这两个对象相等。
        //如果两个对象的hashCode 值不相等，我们就可以直接认为这两个对象不相等。

        //为什么重写 equals() 时必须重写 hashCode() 方法？
        //因为两个相等的对象的 hashCode 值必须是相等,equals判断两个对象相等时，hashcode必须相等
    }
}
