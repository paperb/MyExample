package com.example.example.clone;

public class ShallowCopy {

    public static void main(String[] args) {
        PersonShadow personShadow1 = new PersonShadow(new Address("wuhan"));
        PersonShadow personShadowCopy = personShadow1.clone();
        //浅拷贝，clone()复制了新的Person对象，没有复制成员变量，还是使用原来的成员变量。
        System.out.println(personShadow1.getAddress()==(personShadowCopy.getAddress()));//true
    }
}
