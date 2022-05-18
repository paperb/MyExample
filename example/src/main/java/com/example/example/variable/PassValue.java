package com.example.example.variable;

public class PassValue {
    //Java中只有值传递
    public void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("a=" + a);
        System.out.println("b=" + b);
    }

    public static void main(String[] args) {

        int num1 = 10;
        int num2 = 20;
        PassValue passValue = new PassValue();
        //方法不能修改基本类型的参数
        passValue.swap(num1, num2);
        System.out.println("num1=" + num1 + "  " + "num2=" + num2);
    }
}
