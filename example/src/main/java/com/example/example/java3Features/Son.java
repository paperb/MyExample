package com.example.example.java3Features;

public class Son extends Parent {

//子类继承了父类可以使用父类非private成员变量和方法，只能单继承，可以实现多个接口
//继承抽象类和实现接口必须重写所有抽象/接口方法

    //子类可以实现父类的所有、某些或者不重写父类的方法
    public String son_method() {
        return "这是子类自己的方法";
    }



    @Override
    public String my_method() {
        return "这是子类重写后的方法";
    }
}

class Test{

    //子类继承了父类可以使用父类非private成员变量和方法
    public static void main(String[] args) {
        Son son = new Son();
        String name = son.getName();
        Integer age = son.age;
        System.out.println("这是子类使用父类的成员变量："+age);
        System.out.println("这是子类调用父类方法："+name);
        System.out.println(son.son_method());
        System.out.println(son.my_method());
    }
}
