package com.example.example.variable;

import static com.example.example.variable.PassValue2.swap;

public class PassValue2 {
    public static void swap(Person person1, Person person2) {
        //person1和person2交换的是实参的地址，并不会对实参产生影响
        //形参修改，实参也会修改，因为把实参的地址传递给了形参。
        Person temp = person1;
        person1 = person2;
        person2 = temp;
        System.out.println("person1:" + person1.getName());
        System.out.println("person2:" + person2.getName());
    }
}

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
// 省略构造函数、Getter&Setter方法
    public static void main(String[] args) {
        Person xiaoZhang = new Person("小张");
        Person xiaoLi = new Person("小李");


        swap(xiaoZhang, xiaoLi);
        System.out.println("xiaoZhang:" + xiaoZhang.getName());
        System.out.println("xiaoLi:" + xiaoLi.getName());
    }

}