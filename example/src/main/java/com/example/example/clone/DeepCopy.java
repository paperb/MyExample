package com.example.example.clone;

public class DeepCopy {
    public static void main(String[] args) {
        PersonDeep personDeep = new PersonDeep(new Address("chengdu"));
        PersonDeep personDeepClone = personDeep.clone();

        //深拷贝，克隆对象的成员变量也被克隆了，每一个克隆对象都有一个成员变量
        System.out.println(personDeep.getAddress()==(personDeepClone.getAddress()));//false

    }
}
