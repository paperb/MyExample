package com.example.example.java3Features;

public class Polymorphism implements PolymorphismInterface{

    //多态的条件是：
    // 1.类继承或者接口实现
    //2.子类要重写父类的方法
    //3.父类的引用指向子类的对象

    //多态可以分为两种类型：编译时多态（方法的重载）
    // 和运行时多态（继承时方法的重写）
    public String polymorphism01(){
        return "01方法";
    }
    public String polymorphism01(String s){
        return "这是重载01方法";
    }

    @Override//对接口方法的实现就是多态的表现
    public String polymorphism02() {
        return null;
    }
    //一个有趣的说法是：继承是子类使用父类的方法，而多态则是父类使用子类的方法。
}
