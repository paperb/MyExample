package com.example.example.equals;



public class Equalsanddengyu {
    int a = 0;
    int b = 0;
    int c = 1;

    String s1 = "123";
    String s2 = "123";

    Integer d = 0;
    Integer e = 0;
    Integer f = 1;

    Object o1;
    Object o2;

    Object o3 = "123";
    Object o4 = "123";

    String s3 = s1;
    String s4 = s2;



    public static void main(String[] args) {
        Equalsanddengyu equalsanddengyu = new Equalsanddengyu();
        //基本数据类型用==比较，不能用equals()
        System.out.println(equalsanddengyu.a == equalsanddengyu.b);//true
        System.out.println(equalsanddengyu.a == equalsanddengyu.c);//false

        System.out.println(equalsanddengyu.d.equals(equalsanddengyu.e));//true

        //引用类型equals比较的是对象的地址，==比较的是值，这个值实际上是对象保存的地址
        //类没有重写 equals()方法，等价于==
        //类重写了 equals()方法，比较两个对象中的属性是否相等
        System.out.println(equalsanddengyu.o1==(equalsanddengyu.o2));//ture

        System.out.println(equalsanddengyu.o3.equals(equalsanddengyu.o4));//true

        //包装类如String的equals（）方法重写过，相当于比较值
        System.out.println(equalsanddengyu.s1.equals(equalsanddengyu.s2));//true

        System.out.println(equalsanddengyu.s3.equals(equalsanddengyu.s4));//true
    }
}
