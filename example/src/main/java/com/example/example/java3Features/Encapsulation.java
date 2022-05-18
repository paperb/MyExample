package com.example.example.java3Features;

public class Encapsulation {

    //1.Encapsulation,封装
    //隐藏对象的属性和实现细节，仅对外提供公共访问方式
    //好处：保护数据成员，防止代码被破坏
    private String fengzhuang = "";

    public String getFengzhuang(){
        return fengzhuang;
    }

    public void setFengzhuang(String str){
        this.fengzhuang = str;
    }

    public static void main(String[] args) {


    }

}
